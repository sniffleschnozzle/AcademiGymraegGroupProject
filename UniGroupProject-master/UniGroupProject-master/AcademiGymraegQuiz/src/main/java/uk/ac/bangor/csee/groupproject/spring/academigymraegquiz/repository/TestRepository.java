/**
 * Author: Sophie Jolley
 * Date: 18.04.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model.Test;

public interface TestRepository extends JpaSpecificationExecutor<Test>, CrudRepository<Test, Integer> {

	Test findByTestId(int testId);
	
	Collection<Test> findAllByUsernameOrderByTestIdDesc(String username);
}
