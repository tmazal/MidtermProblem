package com.cisc181.core;

import java.util.UUID;
import java.util.Date;

public class Semester {

	private UUID SemesterID;
	private Date StartDate;
	private Date EndDate;
	
	public Semester(){
	}
	
	public Semester(UUID semesterID, Date startDate, Date endDate) {
		SemesterID = semesterID;
		StartDate = startDate;
		EndDate = endDate;
	}
	public UUID getSemesterID() {
		return SemesterID;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public Date getEndDate() {
		return EndDate;
	}

	public void setSemesterID(UUID semesterID) {
		SemesterID = semesterID;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	
}
