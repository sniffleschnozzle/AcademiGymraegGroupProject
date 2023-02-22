/**
 * Author:Sophie Jolley
 * Date:19.04.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model;

import java.util.LinkedList;
import java.util.List;

public class QuestionsCreationDto {
	private List<Question> questions;
	
	public QuestionsCreationDto() {
		this.questions = new LinkedList<>();
	}
	
	public QuestionsCreationDto(List<Question> questions) {
		this.questions = questions;
	}
	
	public void addQuestion(Question question) {
		this.questions.add(question);
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	
}
