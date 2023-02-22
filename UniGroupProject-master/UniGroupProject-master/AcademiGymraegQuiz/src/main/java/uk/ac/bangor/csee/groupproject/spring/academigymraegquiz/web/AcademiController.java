/**
 * Authors: Will Stephenson & Emeline Fredrick
 * Date: 31.03.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AcademiController {

	@RequestMapping("/")
	public String welcomePage() {
		return "welcome";
	}
	
	@RequestMapping("/login")
	public String loginForm() {
		return "login";
	}
}
