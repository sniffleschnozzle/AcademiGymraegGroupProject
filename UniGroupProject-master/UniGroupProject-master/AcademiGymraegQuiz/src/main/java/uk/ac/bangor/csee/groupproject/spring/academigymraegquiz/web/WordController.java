/**
 * Author:Emeline Fredrick, William Stephenson, Sophie Jolley
 * Date:17.04.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model.Word;
import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.repository.WordRepository;

@Secured("ROLE_INSTRUCTOR")
@Controller
@RequestMapping("/word")
public class WordController {
	
	@Autowired
	private WordRepository repository;

	@RequestMapping(method = GET)
	public String wordForm(Model model) {
		if(!model.containsAttribute("word"))
			model.addAttribute("word", new Word());
		
		//Produces list of all the words in the database to be displayed
		model.addAttribute("pastWords", repository.findAll());
		
		return "word";
	}
	
	@RequestMapping(method=POST)
	public String addWord(@ModelAttribute("word") @Valid Word word, 
			BindingResult result, Model model) {
		
		//All fields must be filled in or error message is shown
		if(result.hasErrors()) {
			model.addAttribute("word", word);
			return wordForm(model);
		}
		
		//Word is added if the English and Welsh translation are unique to English and Welsh translations in the database
		if(repository.findByEnglishNoun(word.getEnglishNoun()) == null && repository.findByWelshNoun(word.getWelshNoun()) == null) {
			repository.save(word);
			model.addAttribute("confirmation", "Word added");
		}
		else {
			//User is stopped from adding duplicate of Welsh and English words
			if(repository.findByEnglishNoun(word.getEnglishNoun()) != null)
				model.addAttribute("confirmation", "Failed to add word - " + word.getEnglishNoun() + " already exists with the translation of " 
			+ repository.findByEnglishNoun(word.getEnglishNoun()).getWelshNoun());
			if(repository.findByWelshNoun(word.getWelshNoun()) != null)
				model.addAttribute("confirmation", "Failed to add word - " + word.getWelshNoun() + " already exists with the translation of " 
			+ repository.findByWelshNoun(word.getWelshNoun()).getEnglishNoun());
		}
		
		model.addAttribute("word", word);
		
		return wordForm(model);
	}
	
	@RequestMapping(value = "/remove/{word}", method = GET)
	public String removeWord(@PathVariable("word") Word word, Model model) {
		if(word != null)
			repository.delete(word);
		
		model.addAttribute("confirmation", "Word " + word.getEnglishNoun() + " was removed");
		
		return wordForm(model);
	}
	
	@RequestMapping(value = "/edit/{word}", method = GET)
	public String editWordRedirect(@PathVariable("word") Word word, Model model)  
	{
		model.addAttribute("editForm", word);
		
		return "wordEdit";
	}
	
	@RequestMapping(value = "/edit", method = POST)
	public String editWord(@ModelAttribute("word") @Valid Word word, 
			BindingResult result, Model model) {

		//All fields must be filled in or error message is shown
		if(result.hasErrors()) {
			model.addAttribute("word", word);
			return wordForm(model);
		}
		
		model.addAttribute("word", word);

		//Case of Welsh / English word in database has same English/Welsh noun value (possible duplicate)
		//If English word is a duplicate
		if(repository.findByEnglishNoun(word.getEnglishNoun()) != null)
		if(repository.findByEnglishNoun(word.getEnglishNoun()).getNounId() != word.getNounId()) {
			model.addAttribute("confirmation", "Failed to edit - word with this English translation already exists");
			return wordForm(model);
		}
		
		//If Welsh word is a duplicate
		if(repository.findByWelshNoun(word.getWelshNoun()) != null)
		if(repository.findByWelshNoun(word.getWelshNoun()).getNounId() != word.getNounId()) {
			model.addAttribute("confirmation", "Failed to edit - word with this Welsh translation already exists");
			return wordForm(model);
		}
		
		model.addAttribute("confirmation", "Word edited successfully");
		repository.save(word);
		return wordForm(model);
	}
}
