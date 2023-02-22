/**
 * Author: James Da Silva
 * Date: 23.04.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model.QuestionFormat;

import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.repository.QuestionFormatRepository;

@Component
public class InitialQuestionFormatTableConfigurer {
	
	@Autowired
	private QuestionFormatRepository repository;

	@PostConstruct
	public void createFirstTable() {

		if(repository.findAll().size() == 0) {
			QuestionFormat format = new QuestionFormat();
			
			format.setQuestionType(0);
			format.setQuestionFull("What is the gender of the Welsh noun");
			repository.save(format);
			
			format.setQuestionType(1);
			format.setQuestionFull("What is the meaning of the Welsh noun");
			repository.save(format);
			
			format.setQuestionType(2);
			format.setQuestionFull("What is the Welsh noun for the English word");
			repository.save(format);
		}
	}
}
