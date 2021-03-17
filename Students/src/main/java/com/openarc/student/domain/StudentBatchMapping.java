package com.openarc.student.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="StudentBatchMapping")
public class StudentBatchMapping {
	
	@Id
	@GeneratedValue
	@Column(name="studentBatchMappingId")
	private Long studentBatchMappingId;
	private String status;
	@ManyToOne
	@JoinColumn(name="studentId",nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Student student;
	@ManyToOne
	@JoinColumn(name="batchId",nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Batch batch;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Long getStudentBatchMappingId() {
		return studentBatchMappingId;
	}
	
	public void setStudentBatchMappingId(Long studentBatchMappingId) {
		this.studentBatchMappingId = studentBatchMappingId;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
