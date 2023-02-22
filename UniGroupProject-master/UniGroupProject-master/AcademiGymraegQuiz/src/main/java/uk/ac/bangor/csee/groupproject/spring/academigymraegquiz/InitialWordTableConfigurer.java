/**
 * Author: Emily Nguyen
 * Date: 23.04.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model.Word;
import uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.repository.WordRepository;

@Component
public class InitialWordTableConfigurer {
	
	@Autowired
	private WordRepository repository;

	@PostConstruct
	public void createFirstTable() {

		if(repository.findAll().size() == 0) {
			Word word = new Word();
			
			word.setEnglishNoun("arm");
			word.setWelshNoun("braich");
			word.setWelshNounGender("feminine");
			repository.save(word);
			
			word.setEnglishNoun("back");
			word.setWelshNoun("yn ôl");
			word.setWelshNounGender("masculine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("cheeks");
			word.setWelshNoun("ruddiau");
			word.setWelshNounGender("masculine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("chest");
			word.setWelshNoun("brest");
			word.setWelshNounGender("feminine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("jaw");
			word.setWelshNoun("gên");
			word.setWelshNounGender("feminine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("ear");
			word.setWelshNoun("clust");
			word.setWelshNounGender("feminine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("elbow");
			word.setWelshNoun("penelin");
			word.setWelshNounGender("masculine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("eye");
			word.setWelshNoun("llygad");
			word.setWelshNounGender("feminine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("face");
			word.setWelshNoun("wyneb");
			word.setWelshNounGender("masculine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("finger");
			word.setWelshNoun("bys");
			word.setWelshNounGender("masculine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("fingers");
			word.setWelshNoun("bysedd");
			word.setWelshNounGender("masculine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("foot");
			word.setWelshNoun("troed");
			word.setWelshNounGender("feminine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("hair");
			word.setWelshNoun("gwallt");
			word.setWelshNounGender("masculine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("hand");
			word.setWelshNoun("llaw");
			word.setWelshNounGender("feminine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("head");
			word.setWelshNoun("pen");
			word.setWelshNounGender("masculine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("heart");
			word.setWelshNoun("calon");
			word.setWelshNounGender("feminine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("knee");
			word.setWelshNoun("pen-glin");
			word.setWelshNounGender("masculine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("leg");
			word.setWelshNoun("coes");
			word.setWelshNounGender("feminine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("lip");
			word.setWelshNoun("gwefus");
			word.setWelshNounGender("feminine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("mouth");
			word.setWelshNoun("genau");
			word.setWelshNounGender("masculine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("neck");
			word.setWelshNoun("gwddf");
			word.setWelshNounGender("masculine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("nose");
			word.setWelshNoun("trwyn");
			word.setWelshNounGender("masculine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("shoulder");
			word.setWelshNoun("ysgwydd");
			word.setWelshNounGender("feminine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("stomach");
			word.setWelshNoun("stumog");
			word.setWelshNounGender("feminine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("teeth");
			word.setWelshNoun("dannedd");
			word.setWelshNounGender("masculine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("hip");
			word.setWelshNoun("clun");
			word.setWelshNounGender("feminine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);

			word.setEnglishNoun("throat");
			word.setWelshNoun("llwnc");
			word.setWelshNounGender("masculine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("thumb");
			word.setWelshNoun("bawd");
			word.setWelshNounGender("masculine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("tongue");
			word.setWelshNoun("tafod");
			word.setWelshNounGender("masculine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
			
			word.setEnglishNoun("tooth");
			word.setWelshNoun("dant");
			word.setWelshNounGender("masculine");
			word.setNounId(word.getNounId() + 1);
			repository.save(word);
		}
	}
}
