/**
 * Author: Will Stephenson
 * Date: 31.03.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class AcademiGymraegQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademiGymraegQuizApplication.class, args);
	}

}
