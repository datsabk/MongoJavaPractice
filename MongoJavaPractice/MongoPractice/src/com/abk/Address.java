package com.abk;

public class Address {
	String street;
	Integer pincode;
	String State;
	String City;
	String Country;
	
	Address(String street,String city,String state,String Country,Integer pincode){
		this.street = street;
		this.City= city;
		this.State=state;
		this.Country= Country;
		this.pincode = pincode;
	}
}
