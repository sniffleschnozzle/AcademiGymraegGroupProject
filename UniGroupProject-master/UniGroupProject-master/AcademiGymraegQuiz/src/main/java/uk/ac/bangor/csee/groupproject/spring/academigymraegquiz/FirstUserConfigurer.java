/**
 * Author: Sophie Jolley
 * Date: 24.03.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model.User;
import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.repository.UserRepository;

@Component
public class FirstUserConfigurer {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RepositoryBasedUserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void createFirstUser() {
		try {
			User loaded = (User) userDetailsService.loadUserByUsername("admin");
			if (!loaded.isSysAdmin()) {
				loaded.setSysAdmin(true);
				repository.save(loaded);
			}
		} catch (UsernameNotFoundException e) {
			User firstUser = new User();
			firstUser.setUsername("admin");
			firstUser.setPassword(passwordEncoder.encode("admin"));
			firstUser.setSysAdmin(true);
			firstUser.setInstructor(true);
			firstUser.setStudent(true);
			repository.save(firstUser);
		}
	}
}
