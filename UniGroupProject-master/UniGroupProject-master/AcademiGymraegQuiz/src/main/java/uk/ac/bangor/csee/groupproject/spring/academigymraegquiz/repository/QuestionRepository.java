/**
 * Author:Sophie Jolley
 * Date:18.04.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model.Question;

public interface QuestionRepository extends JpaSpecificationExecutor<Question>, CrudRepository<Question, Integer> {

	Collection<Question> findAllByTestId(int testId);
}
