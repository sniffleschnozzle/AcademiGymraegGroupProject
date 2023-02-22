/**
 * Author: Will Stephenson
 * Date: 31.03.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AcademiGymraegQuizApplication.class);
	}

}
