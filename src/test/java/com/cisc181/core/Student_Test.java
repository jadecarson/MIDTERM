package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {
	
	private static ArrayList<Student> studentList=new ArrayList<Student>();
	private static ArrayList<Course> courseList=new ArrayList<Course>();
	private static ArrayList<Semester> semesterList=new ArrayList<Semester>();
	private static ArrayList<Section> sectionList=new ArrayList<Section>();


	@BeforeClass
	public static void setup() throws PersonException{
		Calendar Start1=Calendar.getInstance();
		Calendar Start2=Calendar.getInstance();
		Calendar End1=Calendar.getInstance();
		Calendar End2=Calendar.getInstance();
		
		Start1.set(2016, 01, 16);
		Start2.set(1997,03,07);
		End1.set(2016, 10, 16);
		End2.set(1999, 06, 06);
		
		Semester Fall=new Semester(Start1.getTime(),End1.getTime());
		Semester Spring=new Semester(Start2.getTime(),End2.getTime());
		semesterList.add(Fall);
		semesterList.add(Spring);
		
		Course Math=new Course("Math class",4);
		Course Geog=new Course("Geography class",3);
		Course Econ=new Course("Economics class",3);
		courseList.add(Math);
		courseList.add(Geog);
		courseList.add(Econ);
		
		int[]Room=new int[]{101,181,302,350,203,011};
		Section f001=new Section(Fall.getSemesterID(),Math.getCourseID(),Room[1]);
		Section f002=new Section(Spring.getSemesterID(),Math.getCourseID(),Room[2]);
		Section f003=new Section(Fall.getSemesterID(),Geog.getCourseID(),Room[3]);
		Section f004=new Section(Spring.getSemesterID(),Geog.getCourseID(),Room[4]);
		Section f005=new Section(Fall.getSemesterID(),Econ.getCourseID(),Room[5]);
		Section f006=new Section(Spring.getSemesterID(),Econ.getCourseID(),Room[6]);
		sectionList.add(f001);
		sectionList.add(f002);
		sectionList.add(f003);
		sectionList.add(f004);
		sectionList.add(f005);
		sectionList.add(f006);

		Calendar birth1=Calendar.getInstance();
		birth1.set(1997, 03, 07);
		
		Calendar birth2=Calendar.getInstance();
		birth1.set(1961, 11, 30);
		
		Calendar birth3=Calendar.getInstance();
		birth1.set(1926, 05, 21);
		
		Calendar birth4=Calendar.getInstance();
		birth1.set(2004, 10, 07);
		
		Calendar birth5=Calendar.getInstance();
		birth1.set(2008, 04, 03);
		
		Calendar birth6=Calendar.getInstance();
		birth1.set(1997, 06, 20);
		
		Calendar birth7=Calendar.getInstance();
		birth1.set(1982, 12, 25);
		
		Calendar birth8=Calendar.getInstance();
		birth1.set(2001, 9, 19);
		
		Calendar birth9=Calendar.getInstance();
		birth1.set(1945, 8, 04);
		
		Calendar birth10=Calendar.getInstance();
		birth1.set(1965, 02, 14);

		Student s1=new Student("Luke", "R.","Bryan", birth1.getTime(),eMajor.CHEM,"1 Country Lane","(555)-123-1234","teacher1@udel.edu");
		Student s2=new Student("Zac", "Brown","Band", birth2.getTime(),eMajor.BUSINESS,"2 Country Lane","(555)123-1234","teacher2@udel.edu");
		Student s3=new Student("Tim", "T.","McGraw", birth3.getTime(),eMajor.NURSING,"3 Country Lane","(555)-1231234","teacher3@udel.edu");
		Student s4=new Student("Florida", "Georgia","Line", birth4.getTime(),eMajor.PHYSICS,"4 Country Lane","(555)1231234","teacher4@udel.edu");
		Student s5=new Student("Little", "Big","Town", birth5.getTime(),eMajor.CHEM,"5 Country Lane","555-123-1234","teacher5@udel.edu");
		Student s6=new Student("Keith", "D.","Urban", birth1.getTime(),eMajor.BUSINESS,"6 Country Lane","5551231234","teacher1@udel.edu");
		Student s7=new Student("Dierks", "S.","Bentley", birth2.getTime(),eMajor.NURSING,"7 Country Lane","(555-123-1234","teacher2@udel.edu");
		Student s8=new Student("Eric", "C.","Church", birth3.getTime(),eMajor.PHYSICS,"8 Country Lane","(555123-1234","teacher3@udel.edu");
		Student s9=new Student("Kenny", "P.","Chesney", birth4.getTime(),eMajor.CHEM,"9 Country Lane","(555-1231234","teacher4@udel.edu");
		Student s10=new Student("Thomas", "W.","Rhett", birth5.getTime(),eMajor.BUSINESS,"10 Country Lane","555)-123-1234","teacher5@udel.edu");
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		studentList.add(s5);
		studentList.add(s6);
		studentList.add(s7);
		studentList.add(s8);
		studentList.add(s9);
		studentList.add(s10);

	}

	@Test
	public void testgrade() throws PersonException{
		double[][]gradePerson=new double[][]{
			{4.0,4.0,4.0,4.0,4.0,4.0},
			{3.0,3.0,3.0,3.0,3.0,3.0},
			{2.0,2.0,2.0,2.0,2.0,2.0},
			{1.0,1.0,1.0,1.0,1.0,1.0},
			{4.0,3.8,3.6,3.4,3.2,3.0},
			{2.9,3.9,4.0,3.5,2.5,1.5}};
			
			ArrayList<Double>gpaList=new ArrayList<Double>();
			ArrayList<Double>courseAvgList=new ArrayList<Double>();
			courseAvgList.add(0.0);
			courseAvgList.add(0.0);
			courseAvgList.add(0.0);

			int count=0;
			double credits=0;
			double totalGrade=0;
			for(Student s:student){
				for(Section section:section){
					int courseTotal=0;
					for(Course c:course){
						Enrollment enrollment=new Enrollment(s.getStudentID(),section.getSectionID());
						enrollment.setGrade(totalGrade[count][courseTotal]);
						totalGrade+=enrollment.getGrade()*c.getGradePoint();
						count++;
						courseTotal++;
					}
				}
				gpaList.add(totalGrade/credits);
			}
			
			assertTrue(Math.abs(gpaList.get(0)-4.00)<.01);
			assertTrue(Math.abs(gpaList.get(1)-3.00)<.01);
			assertTrue(Math.abs(gpaList.get(2)-2.00)<.01);
			assertTrue(Math.abs(gpaList.get(3)-3.17)<.01);
			assertTrue(Math.abs(gpaList.get(4)-3.07)<.01);
			assertTrue(Math.abs(gpaList.get(5)-3.27)<.01);
			assertTrue(Math.abs(gpaList.get(6)-3.37)<.01);
			assertTrue(Math.abs(gpaList.get(7)-2.17)<.01);
			assertTrue(Math.abs(gpaList.get(8)-2.27)<.01);
			assertTrue(Math.abs(gpaList.get(9)-2.37)<.01);
			
			assertTrue(Math.abs(courseAvgList.get(0)/20-2.81)<.01);
			assertTrue(Math.abs(courseAvgList.get(1)/20-2.74)<.01);
			assertTrue(Math.abs(courseAvgList.get(2)/20-2.96)<.01);
			
		}
	@Test
	public void TesteMajor(){
		Student s1=student.get(1);
		
		s1.seteMajor(eMajor.BUSINESS);
		
		assertEquals(s1.geteMajor(),eMajor.BUSINESS);


	}
}
