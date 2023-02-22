/**
 * Author:Sophie Jolley
 * Date:10.04.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {

	@Id
	@GeneratedValue
	private int questionId;
	
	private int testId, nounId, questionType;
	
	private boolean correct;
	
	private String answer, questionString;
	
	public int getQuestionId() {
		return questionId;
	}
	
	public int getQuestionType() {
		return questionType;
	}

	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public int getNounId() {
		return nounId;
	}

	public void setNounId(int nounId) {
		this.nounId = nounId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answerWord) {
		this.answer = answerWord;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getQuestionString() {
		return questionString;
	}

	public void setQuestionString(String questionString) {
		this.questionString = questionString;
	}
}
