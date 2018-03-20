package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {

	@BeforeClass
	public static void setup() {
		
	}
	
	@Test
	public void test() {
		Staff s1 = new Staff(eTitle.MR);
		s1.setSalary(100.0);
		Staff s2 = new Staff(eTitle.MRS);
		s2.setSalary(200.0);
		Staff s3 = new Staff(eTitle.MS);
		s3.setSalary(300.0);
		Staff s4 = new Staff(eTitle.MR);
		s4.setSalary(700.0);
		Staff s5 = new Staff(eTitle.MS);
		s5.setSalary(11200.0);
		
		ArrayList<Staff> listOfStaff = new ArrayList<Staff>(5);
		
		listOfStaff.add(s1);
		listOfStaff.add(s2);
		listOfStaff.add(s3);
		listOfStaff.add(s4);
		listOfStaff.add(s5);
		
		double total = s1.getSalary() + s2.getSalary() + s3.getSalary() + s4.getSalary() + s5.getSalary();
		double average = total / 5;
		final double expected = (100.0 + 200.0 + 300.0 + 700.0 + 11200.0) / 5;
		assertEquals(average, expected, 0.1);
		
	//	System.out.println(average);
	//	System.out.println(expected);
		
	}	
	
	@Test
	public void test2() throws PersonException {
		try {
			DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			Date DOB = dateFormat1.parse("1800-11-24");
			Date hired = dateFormat1.parse("2001-11-24");
			Staff s1 = new Staff("First", "Middle", "Last", DOB, "Middle of nowhere",
					"12315", "myemail@gmail.com", "303 Walf Hall", 100.0, hired,
					eTitle.MR);
		}
		catch (PersonException pe) {
			System.out.println("Caught the PersonException");
		}
		catch (Exception e) {
			System.out.println("Failed to catch the PersonException");
		}
	}
	
	
	
}
