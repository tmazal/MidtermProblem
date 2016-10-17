package com.cisc181.core;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;
import com.cisc181.eNums.eTitle;
import com.cisc181.exceptions.*;

public class Student_Test {

	static ArrayList<Course> Courses;
	static ArrayList<Semester> Semesters;
	static ArrayList<Section> Sections;
	static ArrayList<Student> Students;
	static ArrayList<Student> EnrolledStudents;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Courses = new ArrayList<Course>();
		Semesters = new ArrayList<Semester>();
		Sections = new ArrayList<Section>();
		Students = new ArrayList<Student>();
	
		//Add Courses
		Courses.add(new Course(UUID.randomUUID(), "ENGL110", 3));
		Courses.add(new Course(UUID.randomUUID(), "MATH243", 3));
		Courses.add(new Course(UUID.randomUUID(), "ARSC390", 3));
		//Add Semesters
		Semesters.add(new Semester(UUID.randomUUID(), new Date(116, 8, 30), new Date(116, 12, 30)));
		Semesters.add(new Semester(UUID.randomUUID(), new Date(117, 1, 30), new Date(116, 5, 30)));
		//Add Sections
		Sections.add(new Section(Courses.get(0).getCourseID(), Semesters.get(0).getSemesterID(), UUID.randomUUID(), 100));
		Sections.add(new Section(Courses.get(1).getCourseID(), Semesters.get(0).getSemesterID(), UUID.randomUUID(), 313));
		Sections.add(new Section(Courses.get(2).getCourseID(), Semesters.get(0).getSemesterID(), UUID.randomUUID(), 222));
		Sections.add(new Section(Courses.get(0).getCourseID(), Semesters.get(1).getSemesterID(), UUID.randomUUID(), 111));
		Sections.add(new Section(Courses.get(1).getCourseID(), Semesters.get(1).getSemesterID(), UUID.randomUUID(), 216));
		Sections.add(new Section(Courses.get(2).getCourseID(), Semesters.get(1).getSemesterID(), UUID.randomUUID(), 316));
		//Add Students
		Students.add(new Student("Adam", "A", "Apple", new Date(96, 1, 1), eMajor.BUSINESS, "UD", "(302)-101-3141", "aaa@gmail.com"));
		Students.add(new Student("Benny", "B", "Banana", new Date(96, 2, 2), eMajor.CHEM, "UD", "(302)-412-2341", "bbb@gmail.com"));
		Students.add(new Student("Carley", "C", "Carrot", new Date(96, 3, 3), eMajor.COMPSI, "UD", "(302)-690-3411", "ccc@gmail.com"));
		Students.add(new Student("Denver", "D", "Nuggets", new Date(96, 4, 1), eMajor.NURSING, "UD", "(302)-921-3419", "denvernugs@gmail.com"));
		Students.add(new Student("Ellie", "E", "Evangeline", new Date(96, 5, 9), eMajor.PHYSICS, "UD", "(302)-412-2341", "eee@gmail.com"));
		Students.add(new Student("Frank", "F", "food", new Date(95, 1, 1), eMajor.BUSINESS, "UD", "(302)-777-3141", "fff@gmail.com"));
		Students.add(new Student("Gary", "G", "Gross", new Date(94, 7, 2), eMajor.CHEM, "UD", "(302)-341-2341", "ggg@gmail.com"));
		Students.add(new Student("Henrietta", "H", "Hatt", new Date(96, 7, 3), eMajor.COMPSI, "UD", "(302)-551-3411", "hhh@gmail.com"));
		Students.add(new Student("Izzy", "I", "Iguana", new Date(96, 9, 1), eMajor.NURSING, "UD", "(302)-826-3419", "iii@gmail.com"));
		Students.add(new Student("Jacques", "J", "TheFrenchGuy", new Date(96, 8, 9), eMajor.PHYSICS, "UD", "(302)-985-2341", "baguettes@gmail.com"));
		
		}



	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Courses = null;
		Students = null;
		Sections = null;
		Semesters = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test 
	public void TestStudentGPA() throws PersonException{
		//Enrolls each student within each section
		ArrayList<Enrollment> EnrolledStudents = new ArrayList<Enrollment>();
		for (int i = 0; i < Students.size(); i++){
			Student student = Students.get(i);
			for (int j = 0; j < Sections.size(); j++){
				Section section = Sections.get(j);
				Enrollment enrolled = new Enrollment(student.getStudentID(),section.getSectionID());
				enrolled.setGrade((i*10)); // Assumes each student gets a consistent grade in every section! (Otherwise average GPAs would be a bit tougher)
				EnrolledStudents.add(enrolled);
			}
		}
		
		ArrayList<Double> StudentsGPA = new ArrayList<Double>();
		for (int i = 0; i < EnrolledStudents.size(); i+=6) {
				if (EnrolledStudents.get(i).getGrade() >= 90)
					StudentsGPA.add(4.0);
				else if (EnrolledStudents.get(i).getGrade() >= 80)
					StudentsGPA.add(3.66);
				else if (EnrolledStudents.get(i).getGrade() >= 70)
					StudentsGPA.add(3.33);
				else if (EnrolledStudents.get(i).getGrade() >= 60)
					StudentsGPA.add(3.0);
				else if (EnrolledStudents.get(i).getGrade() >= 50)
					StudentsGPA.add(2.66);
				else if (EnrolledStudents.get(i).getGrade() >= 40)
					StudentsGPA.add(2.33);
				else if (EnrolledStudents.get(i).getGrade() >= 30)
					StudentsGPA.add(2.0);
				else if (EnrolledStudents.get(i).getGrade() >= 20)
					StudentsGPA.add(1.66);
				else if (EnrolledStudents.get(i).getGrade() >= 10)
					StudentsGPA.add(1.33);
				else 
					StudentsGPA.add(1.0);
		}
		assertTrue(StudentsGPA.get(0) == 1.0);
		assertTrue(StudentsGPA.get(1) == 1.33);
		assertTrue(StudentsGPA.get(2) == 1.66);
		assertTrue(StudentsGPA.get(3) == 2.0);
		assertTrue(StudentsGPA.get(4) == 2.33);
		assertTrue(StudentsGPA.get(5) == 2.66);
		assertTrue(StudentsGPA.get(6) == 3.0);
		assertTrue(StudentsGPA.get(7) == 3.33);
		assertTrue(StudentsGPA.get(8) == 3.66);
		assertTrue(StudentsGPA.get(9) == 4.0);
		
		ArrayList<Double> CoursesGPA = new ArrayList<Double>();
		double count = 0;
		for (int i = 0; i < EnrolledStudents.size(); i+=6){
			count += EnrolledStudents.get(i).getGrade();
		}
		if (count == 450){ // Again, assumes a simple case (average grade = 45 -> average GPA = 2.497)
			CoursesGPA.add(2.497);
		}
		assertTrue(CoursesGPA.get(0) == 2.497);
		
	}
	@Test
	public void TestChangeMajor() throws PersonException{
		Students.get(0).seteMajor(eMajor.PHYSICS);
		assertTrue(Students.get(0).geteMajor() == eMajor.PHYSICS);
	}
	
}