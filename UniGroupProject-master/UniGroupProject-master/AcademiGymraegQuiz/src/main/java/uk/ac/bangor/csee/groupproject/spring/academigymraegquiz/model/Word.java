/**
 * Author: Gbogboade Akindele & Emeline Fredrick
 * Date: 14.04.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Word {

	@Id
	@GeneratedValue
	private int nounId;
	
	@Size(min=1, message="English noun was not entered")
	private String englishNoun;
	
	@Size(min=1, message="Welsh noun was not entered")
	private String welshNoun;
	
	@NotNull(message = "Gender was not selected")
	private String welshNounGender;

	public int getNounId() {
		return nounId;
	}
	
	public void setNounId(int nounId) {
		this.nounId = nounId;
	}
	
	public String getEnglishNoun() {
		return englishNoun;
	}

	public void setEnglishNoun(String englishNoun) {
		this.englishNoun = englishNoun;
	}

	public String getWelshNoun() {
		return welshNoun;
	}

	public void setWelshNoun(String welshNoun) {
		this.welshNoun = welshNoun;
	}

	public String getWelshNounGender() {
		return welshNounGender;
	}

	public void setWelshNounGender(String welshNounGender) {
		this.welshNounGender = welshNounGender;
	}
}
