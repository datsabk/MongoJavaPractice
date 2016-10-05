package com.abk;

public class ProfileDetails {

	String name;
	Address address;
	String mobileNo;
	Integer age; 
	ProfileDetails(String name,String street,String city,String state,String country,Integer pincode,String mobile,Integer age){
		this.name= name;
		address = new Address(street,city,state,country,pincode);
		this.mobileNo = mobile;
		this.age = age;
		
	}
}
