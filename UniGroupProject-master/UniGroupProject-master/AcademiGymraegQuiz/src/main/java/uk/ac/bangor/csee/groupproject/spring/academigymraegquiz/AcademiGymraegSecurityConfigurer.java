/**
 * Author: Sophie Jolley
 * Date: 24.03.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class AcademiGymraegSecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private RepositoryBasedUserDetailsServiceImpl userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/")
			.and()
		.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
			.and()
		.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder createPasswordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
