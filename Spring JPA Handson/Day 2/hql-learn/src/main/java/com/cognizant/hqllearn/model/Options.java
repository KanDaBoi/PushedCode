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
@Table(name = "options")
public class Options {
	@Id
	@Column(name = "op_id")
	private int id;
	@Column(name = "op_qt_id")
	private int qtId;
	@Column(name = "op_score")
	private double score;
	@Column(name = "op_text")
	private String text;

	@OneToMany(mappedBy = "options")
	private Set<AttemptOption> attemptOptionList;

	@ManyToOne
	@JoinColumn(name = "op_qt_id")
	private Question questionFromO;

	@Override
	public String toString() {
		return "Options [id=" + id + ", qtId=" + qtId + ", score=" + score + ", text=" + text + ", attemptOptionList="
				+ attemptOptionList + ", questionFromO=" + questionFromO + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtId() {
		return qtId;
	}

	public void setQtId(int qtId) {
		this.qtId = qtId;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Set<AttemptOption> getAttemptOptionList() {
		return attemptOptionList;
	}

	public void setAttemptOptionList(Set<AttemptOption> attemptOptionList) {
		this.attemptOptionList = attemptOptionList;
	}

	public Question getQuestionFromO() {
		return questionFromO;
	}

	public void setQuestionFromO(Question questionFromO) {
		this.questionFromO = questionFromO;
	}
}
