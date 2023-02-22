/**
 * Author:Sophie Jolley
 * Date:20.04.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model.Test;
import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.repository.TestRepository;

@Secured("ROLE_STUDENT")
@Controller
@RequestMapping("/result")
public class ResultController {

	@Autowired
	private TestRepository repository;
	
	@RequestMapping(method = GET)
	public String resultForm(Model model) {
		if(!model.containsAttribute("result"))
			model.addAttribute("result", new Test());
		
		//Determines the username of the logged in user in order to bring up the relevant tests
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		
		model.addAttribute("pastTests", repository.findAllByUsernameOrderByTestIdDesc(username));
		
		return "result";
	}
}
