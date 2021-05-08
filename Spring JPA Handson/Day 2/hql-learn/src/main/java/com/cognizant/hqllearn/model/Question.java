package com.cognizant.hqllearn.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {
	@Id
	@Column(name = "qt_id")
	private int id;
	@Column(name = "qt_text	")
	private String text;

	@OneToMany(mappedBy = "questionFromAQ")
	private Set<AttemptQuestion> attemptQuestionList;

	@OneToMany(mappedBy = "questionFromO")
	private Set<Options> options;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Set<AttemptQuestion> getAttemptQuestionList() {
		return attemptQuestionList;
	}

	public void setAttemptQuestionList(Set<AttemptQuestion> attemptQuestionList) {
		this.attemptQuestionList = attemptQuestionList;
	}

	public Set<Options> getOptions() {
		return options;
	}

	public void setOptions(Set<Options> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", text=" + text + ", attemptQuestionList=" + attemptQuestionList + ", options="
				+ options + "]";
	}

}
