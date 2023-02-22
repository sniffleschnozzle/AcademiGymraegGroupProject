/**
 * Author: Sophie Jolley
 * Date: 18.04.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model.Question;
import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model.QuestionsCreationDto;
import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model.Test;
import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model.Word;
import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.repository.QuestionFormatRepository;
import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.repository.TestRepository;
import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.repository.WordRepository;

@Secured("ROLE_STUDENT")
@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private WordRepository wordRepository;
	
	@Autowired
	private TestRepository testRepository;
	
	@Autowired
	private QuestionFormatRepository questionFormatRepository;
	
	private Random randomGenerator = new Random();
	
	@RequestMapping(method = GET)
	public String testForm(Model model) {
		if(!model.containsAttribute("test"))
			model.addAttribute("test", new Test());
		
		return "test";
	}
	
	@RequestMapping(method = POST)
	public String startTest(@ModelAttribute("test") @Valid Test test, 
			BindingResult result, Model model) {
	
		if(result.hasErrors()) {
			model.addAttribute("test", test);
			return testForm(model);
		}
		
		//Creates row in Test table with no score for student who is logged in
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		test.setUsername(username);
		
		model.addAttribute("test", test);
		testRepository.save(test);
	
		//Creates a list of 20 distinct words
		List<Word> words = (List<Word>) wordRepository.findAll();
		Collections.shuffle((words));
		List<Word> testWords = new LinkedList<Word>();
		testWords = words.subList(0, 20);
		
		List<Question> testQuestions = new LinkedList<Question>();
		
		//Creates a list of 20 dinstinct questions
		for(Word word : testWords) {
			Question question = new Question();
			question.setNounId(word.getNounId());
			question.setTestId(test.getTestId());
			question.setQuestionType(randomGenerator.nextInt(3));
			
			testQuestions.add(question);
		}
		
		Word quesWord = null;
		String noun = null, type = null;
		
		//Questions are converted into a list of strings the user can understand
		//The string is then saved to the relevant question
		for(Question question : testQuestions) {
			
			quesWord = wordRepository.findByNounId(question.getNounId());
			
			if(question.getQuestionType() == 0) {
				type = (questionFormatRepository.findByQuestionType(0)).getQuestionFull();
				noun = quesWord.getWelshNoun();
			}
			if(question.getQuestionType() == 1) {
				type = (questionFormatRepository.findByQuestionType(1)).getQuestionFull();
				noun = quesWord.getWelshNoun();
			}
			if(question.getQuestionType() == 2) {
				type = (questionFormatRepository.findByQuestionType(2)).getQuestionFull();
				noun = quesWord.getEnglishNoun();
			}
			
			question.setQuestionString(type + " " + noun);
		}
		
		model.addAttribute("questions", testQuestions);
		//Saved as a list using QuestionsCreationDto.java to allow editing of the list through the html
		model.addAttribute("form", new QuestionsCreationDto(testQuestions));
		
		return testForm(model);
	}
}
