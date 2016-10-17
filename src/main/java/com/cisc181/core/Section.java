package com.cisc181.core;

import java.util.UUID;

public class Section {
	private UUID CourseID;
	private UUID SemesterID;
	private UUID SectionID;
	private int RoomID;
	
	public UUID getCourseID(){
		return CourseID;
	}

	public UUID getSemesterID(){
		return SemesterID;
	}
	
	public UUID getSectionID(){
		return SectionID;
	}
	
	public Section(){
		this.SectionID=UUID.randomUUID();
	}
	
	public int getRoomID(){
		return RoomID;
	}
	
	public void setRoomID(int roomID){
		RoomID=roomID;
	}

	public Section(UUID SemesterID, UUID CourseID, int RoomID){
		this();
		this.CourseID=CourseID;
		this.SemesterID=SemesterID;
		this.RoomID=RoomID;
	}


}
