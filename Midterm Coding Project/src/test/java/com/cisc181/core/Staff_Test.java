package com.cisc181.core;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;
import com.cisc181.exceptions.*;

public class Staff_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@Test
	public void TestAverageSalary() throws PersonException{
		ArrayList<Staff> StaffArray = new ArrayList<Staff>();
		StaffArray.add(new Staff("John", "M", "Smith", new Date(90, 12, 30), 
				"123 Victory Lane", "(302)-584-4101", "boring@gmail.com", "5-7 PM", 100, 
				35000, new Date(2016, 1, 1), eTitle.MR));
		StaffArray.add(new Staff("Julia", "N", "Smith", new Date(90, 12, 31), 
				"123 Victory Lane", "(302)-584-4102", "marriedboring@gmail.com", "4-6 PM", 99, 
				36000, new Date(2016, 1, 1), eTitle.MRS));
		StaffArray.add(new Staff("Isaac", "Newt", "Onh", new Date(43, 1, 4), 
				"981 Apple Road", "(302)-331-1727", "gravityman@gmail.com", "7-830 PM", 10, 
				46000, new Date(2016, 1, 1), eTitle.MR));
		StaffArray.add(new Staff("Bear", "Ack", "Obama", new Date(61, 8, 4), 
				"1600 Pennsylvania Avenue", "(302)-555-1234", "44thpresidentyo@gmail.com", "1-2 PM", 5, 
				60000, new Date(2016, 1, 1), eTitle.MR));
		StaffArray.add(new Staff("Hilary", "Rodham", "Clinton", new Date(47, 10, 26), 
				"14 Spruce Avenue", "(302)-123-5555", "betterthantrump@gmail.com", "3-4 PM", 7, 
				54000, new Date(2016, 1, 1), eTitle.MRS));
		double avgSalary = (StaffArray.get(0).getSalary() + StaffArray.get(1).getSalary() + 
				StaffArray.get(2).getSalary() + StaffArray.get(3).getSalary() + StaffArray.get(4).getSalary())/5;
		assertTrue(avgSalary == 46200.00);
	}
	
	@SuppressWarnings("deprecation")
	@Test(expected = PersonException.class)
	public void TestInvalidPhoneNumber() throws PersonException{
		Staff WrongNumber = new Staff("John", "M", "Smith", new Date(90, 12, 30), 
				"123 Victory Lane", "302-584-4101", "boring@gmail.com", "5-7 PM", 100, 
				35000, new Date(2016, 1, 1), eTitle.MR);
	}
	
	@SuppressWarnings("deprecation")
	@Test(expected = PersonException.class)
	public void TestInvalidDOB() throws PersonException{
		Staff TooOld = new Staff("John", "M", "Smith", new Date(5, 12, 30), // tests person born in 1905
				"123 Victory Lane", "(302)-584-4101", "boring@gmail.com", "5-7 PM", 100, 
				35000, new Date(2016, 1, 1), eTitle.MR);
	}
}




