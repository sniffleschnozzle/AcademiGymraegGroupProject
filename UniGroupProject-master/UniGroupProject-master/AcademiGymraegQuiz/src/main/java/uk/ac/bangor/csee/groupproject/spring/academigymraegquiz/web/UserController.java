/**
 * Author:Sophie Jolley & Gbogboade Akindele & William Stephenson
 * Date:14.04.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model.User;
import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.repository.UserRepository;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(method = GET)
	public String userForm(Model model) {
		if(!model.containsAttribute("user"))
			model.addAttribute("user", new User());
		
		return "user";
	}
	
	@RequestMapping(method=POST)
	public String addUser(@ModelAttribute("user") @Valid User user, 
			BindingResult result, Model model) {
		
		//Must have values for username & password entered, with username being < 16 char
		if(result.hasErrors()) {
			model.addAttribute("user", user);
			return userForm(model);
		}
		
		//Takes the password entered and encodes it before saving to database
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		model.addAttribute("user", user);
		
		//Determines message to be displayed to user and saves user if user not found
		if(repository.findByUsername(user.getUsername()) == null) {
			repository.save(user);
			model.addAttribute("message", "User " + user.getUsername() + " saved");
		}
		else {
			model.addAttribute("message", "Failed to add user - User " + user.getUsername() + " already exists");
		}
		
		return userForm(model);
	}
	
	@RequestMapping(value = "/remove", method = POST)
	public String removeUser(@ModelAttribute("user") @Valid User user, 
			BindingResult result, Model model) {
		
		//Must have values for username & password entered, with username being < 16 char
		if(result.hasErrors()) {
			model.addAttribute("user", user);
			return userForm(model);
		}
		
		//Determines message to be displayed to user and deletes user if user found
		if(repository.findByUsername(user.getUsername()) == null) {
			model.addAttribute("message", "Failed to remove user - User " + user.getUsername() + " doesn't exist");
		}
		else {
			repository.delete(user);
			model.addAttribute("message", "User " + user.getUsername() + " deleted");
		}
		
		return userForm(model);
	}
	
	@RequestMapping(value = "/edit", method = POST)
	public String editUser(@ModelAttribute("user") @Valid User user, 
			BindingResult result, Model model) {
		
		//Must have values for username & password entered, with username being < 16 char
		if(result.hasErrors()) {
			model.addAttribute("user", user);
			return userForm(model);
		}
		
		//Takes the password entered and encodes it before saving to database
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		model.addAttribute("user", user);
		
		//Determines message to be displayed to user and saves user if user found
		if(repository.findByUsername(user.getUsername()) != null) {
			repository.save(user);
			model.addAttribute("message", "Password for " + user.getUsername() + " reset");
		}
		else {
			model.addAttribute("message", "Failed to reset password - User " + user.getUsername() + " doesn't exist");
		}
		
		return userForm(model);
	}
}
