/**
 * Author:Sophie Jolley, James Da Silva
 * Date:10.04.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class QuestionFormat {

	@Id
	private int questionType;
	
	private String questionFull;

	public int getQuestionType() {
		return questionType;
	}
	
	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}
	
	public String getQuestionFull() {
		return questionFull;
	}

	public void setQuestionFull(String questionFull) {
		this.questionFull = questionFull;
	}
}
