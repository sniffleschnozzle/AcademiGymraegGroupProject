/**
 * Author:Sophie Jolley
 * Date:18.04.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model.QuestionFormat;

public interface QuestionFormatRepository extends JpaSpecificationExecutor<QuestionFormat>, CrudRepository<QuestionFormat, Integer> {
	
	Collection<QuestionFormat> findAll();
	QuestionFormat findByQuestionType(int questionType);
}
