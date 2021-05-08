package com.cognizant.hqllearn.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "attempt_question")
public class AttemptQuestion {
	@Id
	@Column(name = "aq_id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "aq_at_id")
	private Attempt attempt;

	@ManyToOne
	@JoinColumn(name = "aq_qt_id")
	private Question questionFromAQ;

	@OneToMany(mappedBy = "attemptQuestion")
	private Set<AttemptOption> attemptOptionList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Attempt getAttempt() {
		return attempt;
	}

	public void setAttempt(Attempt attempt) {
		this.attempt = attempt;
	}

	public Question getQuestionFromAQ() {
		return questionFromAQ;
	}

	public void setQuestionFromAQ(Question questionFromAQ) {
		this.questionFromAQ = questionFromAQ;
	}

	public Set<AttemptOption> getAttemptOptionList() {
		return attemptOptionList;
	}

	public void setAttemptOptionList(Set<AttemptOption> attemptOptionList) {
		this.attemptOptionList = attemptOptionList;
	}

	@Override
	public String toString() {
		return "AttemptQuestion [id=" + id + ", attempt=" + attempt + ", questionFromAQ=" + questionFromAQ
				+ ", attemptOptionList=" + attemptOptionList + "]";
	}

}
