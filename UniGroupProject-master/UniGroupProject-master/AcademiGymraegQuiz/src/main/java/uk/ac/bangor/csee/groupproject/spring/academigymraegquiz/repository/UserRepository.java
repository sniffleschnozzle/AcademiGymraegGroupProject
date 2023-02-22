/**
 * Author: Sophie Jolley
 * Date: 21.03.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model.User;

public interface UserRepository extends CrudRepository<User, String>, JpaSpecificationExecutor<User> {

	User findByUsername(String username);
}
