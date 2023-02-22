/**
 * Author: Emeline Fredrick & Sophie Jolley
 * Date: 17.04.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model.Word;

public interface WordRepository extends JpaSpecificationExecutor<Word>, CrudRepository<Word, Integer> {

	Collection<Word> findAll();
	
	Word findByNounId(int nounId);
	Word findByEnglishNoun(String englishNoun);
	Word findByWelshNoun(String welshNoun);
}

