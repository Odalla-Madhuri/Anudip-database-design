package com.ajp.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Assignment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int assignmentId;
	private String assignmentName;
	private Date duedate;
	
	@ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

	public Assignment() {

	}

	public Assignment(int assignmentId, String assignmentName, Date duedate, Subject subject) {
		super();
		this.assignmentId = assignmentId;
		this.assignmentName = assignmentName;
		this.duedate = duedate;
		this.subject = subject;
	}

	public int getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}

	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Assignment [assignmentId=" + assignmentId + ", assignmentName=" + assignmentName + ", duedate="
				+ duedate + ", subject=" + subject + "]";
	}
	
}
