package com.cisc181.core;

import java.util.UUID;

public class Enrollment {
	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double Grade;
	
	public UUID getSectionID(){
		return SectionID;
	}
	
	public UUID getStudentID(){
		return StudentID;
	}
	
	public UUID getEnrollmentID(){
		return EnrollmentID;
	}
	
	public double getGrade(){
		return Grade;
	}
	
	public void setGrade(double grade){
		Grade=grade;
	}
	
	private Enrollment(){
		this.EnrollmentID=UUID.randomUUID();
	}
	
	public Enrollment(UUID SectionID, UUID StudentID){
		this();
		this.SectionID=SectionID;
		this.StudentID=StudentID;
	}


}
