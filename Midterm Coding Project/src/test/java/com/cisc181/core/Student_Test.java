package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {

	private static ArrayList<Section> sections = new ArrayList<Section>(6);
	private static ArrayList<Student> students = new ArrayList<Student>(10);
	private static ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
	
	@BeforeClass
	public static void setup() throws ParseException, PersonException {
		Course course1 = new Course(UUID.randomUUID(), "BUSI101", 100, eMajor.BUSINESS);
		Course course2 = new Course(UUID.randomUUID(), "CHEM101", 100, eMajor.CHEM);
		Course course3 = new Course(UUID.randomUUID(), "PHYS242", 100, eMajor.PHYSICS);
		
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date FallStartDate = dateFormat1.parse("2017-08-24");
		Date FallEndDate = dateFormat1.parse("2017-12-17");
		Date SpringStartDate = dateFormat1.parse("2018-02-02");
		Date SpringEndDate = dateFormat1.parse("2018-05-24");
		
		Semester fall = new Semester(UUID.randomUUID(), FallStartDate, FallEndDate);
		Semester spring = new Semester(UUID.randomUUID(), SpringStartDate, SpringEndDate);
		
		Section fallcourse1 = new Section(course1.getCourseID(), fall.getSemesterID(), 101);
		Section springcourse1 = new Section(course1.getCourseID(), spring.getSemesterID(), 102);
		Section fallcourse2 = new Section(course2.getCourseID(), fall.getSemesterID(), 103);
		Section springcourse2 = new Section(course2.getCourseID(), spring.getSemesterID(), 104);
		Section fallcourse3 = new Section(course3.getCourseID(), fall.getSemesterID(), 105);
		Section springcourse3 = new Section(course3.getCourseID(), spring.getSemesterID(), 106);
		
	//	ArrayList<Section> sections = new ArrayList<Section>(6);
		sections.add(fallcourse1);
		sections.add(springcourse1);
		sections.add(fallcourse2);
		sections.add(springcourse2);
		sections.add(fallcourse3);
		sections.add(springcourse3);
		
		Student student1 = new Student("Billy", "de", "Wang", dateFormat1.parse("2009-08-24"), eMajor.BUSINESS,
				"311 Mid St", "3033333333", "billywang@gmail.com");
		Student student2 = new Student("Goo", "d", "Bye", dateFormat1.parse("2002-04-12"), eMajor.CHEM,
				"312 Mid St", "3033333334", "goodbye@gmail.com");
		Student student3 = new Student("Gle", "e", "Numb", dateFormat1.parse("2001-07-23"), eMajor.COMPSI,
				"313 Mid St", "3033333335", "glenumb@gmail.com");
		Student student4 = new Student("Ji", "y", "The", dateFormat1.parse("2000-06-22"), eMajor.NURSING,
				"314 Mid St", "3033333336", "jithe@gmail.com");
		Student student5 = new Student("Bu", "k", "Show", dateFormat1.parse("1999-05-21"), eMajor.PHYSICS,
				"315 Mid St", "3033333337", "bushow@gmail.com");
		Student student6 = new Student("Idk", "dk", "Must", dateFormat1.parse("1998-04-20"), eMajor.BUSINESS,
				"316 Mid St", "3033333338", "idkmust@gmail.com");
		Student student7 = new Student("Nump", "ky", "Go", dateFormat1.parse("1997-03-19"), eMajor.CHEM,
				"317 Mid St", "3033333339", "numpgo@gmail.com");
		Student student8 = new Student("Harry", "op", "On", dateFormat1.parse("1996-02-18"), eMajor.COMPSI,
				"318 Mid St", "3033333331", "harryon@gmail.com");
		Student student9 = new Student("Bill", "po", "Bro", dateFormat1.parse("1995-01-17"), eMajor.NURSING,
				"319 Mid St", "3033333321", "billbro@gmail.com");
		Student student10 = new Student("Tom", "dklafsjnklejnw", "Uno", dateFormat1.parse("1994-12-16"), 
				eMajor.PHYSICS, "320 Mid St", "3033333292", "tomuno@gmail.com");
		
	//	ArrayList<Student> students = new ArrayList<Student>(10);
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		students.add(student5);
		students.add(student6);
		students.add(student7);
		students.add(student8);
		students.add(student9);
		students.add(student10);
		
		Random random = new Random();
		
		for(Student student : students) {
			for (Section section : sections) {
				enrollments.add(new Enrollment(student.getStudentID(), section.getSectionID(), 
						(double) random.nextInt(100)));
			}
		}
	}

	@Test
	public void studentTest() {
		for (Student student : students) {
			double totalGPA = 0;
			int totalCourses = 0;
			for (Enrollment enrollment : enrollments) {
				if (enrollment.getStudentID().equals(student.getStudentID())) {
					totalGPA += enrollment.getGPA();
					totalCourses++;
				}
			}
			double GPA = totalGPA / totalCourses;
			assertEquals(true, GPA <= 4 && GPA >= 0);
		}
	}
	
	@Test
	public void sectionTest() {
		for (Section section : sections) {
			double totalGrade = 0;
			int totalStudents = 0;
			for (Enrollment enrollment : enrollments) {
				if (enrollment.getSectionID().equals(section.getSectionID())) {
					totalGrade += enrollment.getGrade();
					totalStudents ++;
				}
			}
			double averageGrade = totalGrade / totalStudents;
			assertEquals(true, averageGrade <= 100 && averageGrade >= 0);
		}
	}	
}










