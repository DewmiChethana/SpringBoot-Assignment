package com.openarc.student.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Course")
public class Course {
	
	@Id
	@GeneratedValue
	private long courseID;
	private String courseCode;
	private String courseName;
	private int noOfInstallment;
	
	public long getCourseID() {
		return courseID;
	}
	
	public void setCourseID(long courseID) {
		this.courseID = courseID;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public int getNoOfInstallment() {
		return noOfInstallment;
	}
	
	public void setNoOfInstallment(int noOfInstallment) {
		this.noOfInstallment = noOfInstallment;
	}		
}
