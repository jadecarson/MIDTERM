package com.cisc181.core;

import java.util.Date;

public class PersonException extends Exception{
	private Date DOB;
	private String phone_number;
	
	public PersonException(Person DOB){
		this.DOB=p;
		System.out.println("Too old. Try a younger age. "+DOB);
	}
	
	public PersonException(String phone_number){
		this.phone_number=phone_number;
		System.out.println("YOur phone number is invalid. Please put in format (###)-###-####. "+phone_number);
	}

}
