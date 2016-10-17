package com.cisc181.core;

import java.util.UUID;
import com.cisc181.eNums.eMajor;



public class Course {
	private UUID CourseID;
	private String CourseName;
	private int GradePoint;
	private eMajor eMajor;

	public UUID getCourseID() {
		return CourseID;
	}

	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public int getGradePoint() {
		return GradePoint;
	}
	
	public void setGradePoint(int gradePoint){
		GradePoint=gradePoint;
	}
	
	public eMajor geteMajor(){
		return eMajor;
	}
	
	public void seteMajor(eMajor eMajor){
		this.eMajor=eMajor;
	}
	
	public Course(){
		this.CourseID=UUID.randomUUID();
	}
	
	public Course(String CourseName, int GradePoints){
		this();
		this.CourseName=CourseName;
		this.GradePoint=GradePoints;
	}

}
