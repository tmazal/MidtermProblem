package com.cisc181.core;

import java.util.UUID;

public class Enrollment {

	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double Grade;
	
	private Enrollment(){
	}
	
	public Enrollment (UUID StudentID, UUID SectionID){
		this();
		this.StudentID = StudentID;
		this.SectionID = SectionID;
		this.EnrollmentID = UUID.randomUUID();
	}

	public UUID getSectionID() {
		return SectionID;
	}

	public UUID getStudentID() {
		return StudentID;
	}

	public UUID getEnrollmentID() {
		return EnrollmentID;
	}

	public double getGrade() {
		return Grade;
	}

	public void setSectionID(UUID sectionID) {
		SectionID = sectionID;
	}

	public void setStudentID(UUID studentID) {
		StudentID = studentID;
	}

	public void setEnrollmentID(UUID enrollmentID) {
		EnrollmentID = enrollmentID;
	}

	//REQUIRED SETTER
	public void setGrade(double grade) {
		Grade = grade;
	}
	
}
