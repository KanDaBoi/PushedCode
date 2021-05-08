package com.cognizant.hqllearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attempt_option")
public class AttemptOption {
	@Id
	@Column(name = "ao_id")
	private int id;
	@Column(name = "ao_op_id")
	private int opId;
	@Column(name = "ao_aq_id")
	private int aqId;
	@Column(name = "ao_selected")
	private boolean selected;
	
	@ManyToOne
	@JoinColumn(name="ao_aq_id")
	private AttemptQuestion attemptQuestion;
	
	@ManyToOne
	@JoinColumn(name="ao_op_id")
	private Options options;

	@Override
	public String toString() {
		return "AttemptOption [id=" + id + ", opId=" + opId + ", aqId=" + aqId + ", selected=" + selected
				+ ", attemptQuestion=" + attemptQuestion + ", options=" + options + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOpId() {
		return opId;
	}

	public void setOpId(int opId) {
		this.opId = opId;
	}

	public int getAqId() {
		return aqId;
	}

	public void setAqId(int aqId) {
		this.aqId = aqId;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public AttemptQuestion getAttemptQuestion() {
		return attemptQuestion;
	}

	public void setAttemptQuestion(AttemptQuestion attemptQuestion) {
		this.attemptQuestion = attemptQuestion;
	}

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}
	}
