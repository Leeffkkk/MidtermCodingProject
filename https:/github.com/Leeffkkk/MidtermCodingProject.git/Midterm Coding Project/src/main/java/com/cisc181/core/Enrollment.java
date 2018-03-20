package com.cisc181.core;

import java.util.UUID;

public class Enrollment {
	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double Grade;
	
	private Enrollment() {
	}
	
	public Enrollment(UUID StudentID, UUID SectionID) {
		this.StudentID = StudentID;
		this.SectionID = SectionID;
		this.EnrollmentID = UUID.randomUUID();
	}
	
	protected Enrollment(UUID StudentID, UUID SectionID, double grade) {
		this.StudentID = StudentID;
		this.SectionID = SectionID;
		this.EnrollmentID = UUID.randomUUID();
		this.Grade = grade;
	}
	
	public void setGrade(double grade) {
		this.Grade = grade;
	}
	
	public double getGrade() {
		return this.Grade;
	}
	
	public Double getGPA() {
		if (Grade >= 90) {
			return 4.0;
		}
		else if (Grade >= 80) {
			return 3.0;
		}
		else if (Grade >= 70) {
			return 2.0;
		}
		else if (Grade >= 60) {
			return 1.0;
		}
		else
			return 0.0;
	}

	public UUID getSectionID() {
		return SectionID;
	}

	public UUID getStudentID() {
		return StudentID;
	}
	
}
