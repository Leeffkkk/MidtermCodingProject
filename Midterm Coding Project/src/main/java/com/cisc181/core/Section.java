package com.cisc181.core;

import java.util.UUID;

public class Section {
	private UUID CourseID;
	private UUID SemesterID;
	private UUID SectionID;
	private int RoomID;
	
	public Section(UUID courseID, UUID semesterID, int roomID) {
		this.CourseID = courseID;
		this.SemesterID = semesterID;
		this.SectionID = UUID.randomUUID();
		this.RoomID = roomID;
	}
	
	public UUID getSectionID() {
		return this.SectionID;
	}
}
