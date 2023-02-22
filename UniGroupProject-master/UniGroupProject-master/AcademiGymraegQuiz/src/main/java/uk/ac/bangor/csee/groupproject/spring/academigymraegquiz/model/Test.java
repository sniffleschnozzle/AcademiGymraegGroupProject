/**
 * Author: Sophie Jolley
 * Date: 09.04.22
 */
package uk.ac.bangor.csee.groupproject.spring.academigymraegquiz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Test {

	@Id
	@GeneratedValue
	private int testId;
	
	private String username;
	
	private int totalScore;
	
	public int getTestId() {
		return testId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
}
