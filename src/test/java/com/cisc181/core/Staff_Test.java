package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {
	private static ArrayList<Staff> staffList=new ArrayList<Staff>();

	@BeforeClass
	public static void setup() throws PersonException{
		Calendar hiredon11=Calendar.getInstance();
		hiredon11.set(2007, 01, 11);
		
		Calendar hiredon22=Calendar.getInstance();
		hiredon22.set(2010, 02, 22);
		
		Calendar birthDate1=Calendar.getInstance();
		birthDate1.set(1976, 03, 26);
		
		Calendar birthDate2=Calendar.getInstance();
		birthDate2.set(1954, 04, 03);
		
		Calendar birthDate3=Calendar.getInstance();
		birthDate3.set(1988, 05, 15);
		
		Calendar birthDate4=Calendar.getInstance();
		birthDate4.set(1972, 06, 17);
		
		Calendar birthDate5=Calendar.getInstance();
		birthDate5.set(1999, 07, 29);
		
		Staff sf1=new Staff("Jake","A.","Dalton",birthDate1.getTime(),"1 College Ave","(555)-123-4561","staff1@udel.edu","M/W 5-6PM",5,90000.00,hiredon11.getTime(),eTitle.MR);
		Staff sf2=new Staff("Jackie","B.","Matthews",birthDate2.getTime(),"2 College Ave","(555)123-4562","staff2@udel.edu","T/H 7-8PM",1,39000.00,hiredon22.getTime(),eTitle.MRS);
		Staff sf3=new Staff("Joseph","C.","Edwards",birthDate3.getTime(),"3 College Ave","(555)-1234563","staff3@udel.edu","M/W/F 10-11AM",2,178900.00,hiredon11.getTime(),eTitle.MR);
		Staff sf4=new Staff("Jillian","D.","Frankford",birthDate4.getTime(),"4 College Ave","(555)1234564","staff4@udel.edu","M/T 7-11PM",4,11700.00,hiredon22.getTime(),eTitle.MS);
		Staff sf5=new Staff("Jennifer","E.","Nachos",birthDate5.getTime(),"5 College Ave","5551234565","staff5@udel.edu","T/W/H 9-10AM",3,98700.00,hiredon11.getTime(),eTitle.MRS);
		
		staffList.add(sf1);
		staffList.add(sf2);
		staffList.add(sf3);
		staffList.add(sf4);
		staffList.add(sf5);

	}
	
	@Test
	public final void salary_Test(){
		double avgSalary=0;
		for(Staff instance:staffList){
			avgSalary+=instance.getSalary();
		}
		avgSalary=avgSalary/5;
		assertTrue(Math.abs(avgSalary-155500.00)<.01);
	}	
	
	@Test (expected=PersonException.class)
	
	public final void DOBexception_Test() throws PersonException{
		Calendar birthDate1=Calendar.getInstance();
		birthDate1.set(1909,03,15);
		Calendar hiredon11=Calendar.getInstance();
		hiredon11.set(2007,10,17);
		Staff sf1=new Staff("Jake","A.","Dalton",birthDate1.getTime(),"1 College Ave","(555)-123-4561","staff1@udel.edu","M/W 5-6PM",5,90000.00,hiredon11.getTime(),eTitle.MR);
		staffList.add(1,sf1);
	}
	
	@Test(expected=PersonException.class)
	
	public final void phoneNumberException_Test()throws PersonException{
		Calendar birthDate5=Calendar.getInstance();
		birthDate5.set(1967, 12, 31);
		Calendar hiredon11=Calendar.getInstance();
		hiredon11.set(2010, 9, 6);
		Staff sf5=new Staff("Jennifer","E.","Nachos",birthDate5.getTime(),"5 College Ave","5551234565","staff5@udel.edu","T/W/H 9-10AM",3,98700.00,hiredon11.getTime(),eTitle.MRS);
		staffList.add(5,sf5);
	}
	

}
