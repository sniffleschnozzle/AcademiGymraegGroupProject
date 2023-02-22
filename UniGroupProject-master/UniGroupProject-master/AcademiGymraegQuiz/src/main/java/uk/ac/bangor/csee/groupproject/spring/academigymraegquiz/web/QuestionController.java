/**
 * Author: Sophie Jolley
 * Date: 18.04.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.text.Collator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model.Question;
import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model.QuestionsCreationDto;
import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model.Test;
import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model.Word;
import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.repository.QuestionRepository;
import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.repository.TestRepository;
import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.repository.WordRepository;

@Secured("ROLE_STUDENT")
@Controller
@RequestMapping("/test/previous")
public class QuestionController {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private TestRepository testRepository;
	
	@Autowired
	private WordRepository wordRepository;
	
	@RequestMapping(method = GET)
	public String answerForm(Model model) {
		if(!model.containsAttribute("form"))
			model.addAttribute("form", new QuestionsCreationDto());
		
		return "view";
	}
	
	@RequestMapping(value = "/save", method = POST)
	public String submitTest(@ModelAttribute QuestionsCreationDto form, Model model) {
		Test test = null;
		Word noun = null;
		String ans = null;
		int total = 0;
		Collator coll = Collator.getInstance();
		
	    for(Question question : form.getQuestions()) {
	    	noun = wordRepository.findByNounId(question.getNounId());
	    	
	    	//Determines what the correct answer for the question is based on the type of question
	    	if(question.getQuestionType() == 0) {
				ans = noun.getWelshNounGender();
			}
			if(question.getQuestionType() == 1) {
				ans = noun.getEnglishNoun();
			}
			if(question.getQuestionType() == 2) {
				ans = noun.getWelshNoun();
			}
	    	
			//Compares the correct answer with the students answer and increments the total score if correct
			//Ignores case and accepts any version of special characters such as ô being o
			if(question.getAnswer() != null) {
				coll.setStrength(Collator.PRIMARY);
		    	if(coll.compare(question.getAnswer(), ans) == 0) {
		    		question.setCorrect(true);
		    		total += 1;
		    	}
		    }
			questionRepository.save(question);
	    }
	    
	    test = testRepository.findByTestId(form.getQuestions().get(0).getTestId());
	    test.setTotalScore(total);
	    testRepository.save(test);
	    
	    return "redirect:/result";
	}
	
	@RequestMapping(value = "/{test}", method = GET)
	public String removeCalculation(@PathVariable("test") int testId, Model model) {
		
		model.addAttribute("questions", questionRepository.findAllByTestId(testId));
		
		return "view";
	}
}
