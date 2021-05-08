package com.cognizant.hqllearn.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "attempt")
public class Attempt {

	@Id
	@Column(name = "at_id")
	private int id;
	@Column(name = "at_date")
	private Date date;
	@Column(name = "at_score")
	private double score;

	@ManyToOne
	@JoinColumn(name = "at_us_id")
	private User user;

	@OneToMany(mappedBy = "attempt")
	private Set<AttemptQuestion> attemptQuestionList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<AttemptQuestion> getAttemptQuestionList() {
		return attemptQuestionList;
	}

	public void setAttemptList(Set<AttemptQuestion> attemptQuestionList) {
		this.attemptQuestionList = attemptQuestionList;
	}

	@Override
	public String toString() {
		return "Attempt [id=" + id + ", date=" + date + ", score=" + score + ", user=" + user + ", attemptList="
				+ attemptQuestionList + "]";
	}

}
