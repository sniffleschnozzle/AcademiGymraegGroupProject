/**
 * Author: Will Stephenson
 * Date: 31.03.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model.User;
import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.repository.UserRepository;

@Component
public class RepositoryBasedUserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> u = repository.findById(username);
		
		if(u.isPresent()) 
			return u.get();	
		
		throw new UsernameNotFoundException(username + " not found.");
	}

}
