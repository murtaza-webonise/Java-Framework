package com.webo.test;

import com.webo.annotations.Autoinit;

public class Employee {

	private String name;
	private long mobileNumber;
	@Autoinit
	private Address add;
	@Autoinit
	private School sc;

	public Employee() {
		name = "Murtaza";
		mobileNumber = 12345678;
		System.out.println(name + " " + mobileNumber);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getmobileNumber() {
		return mobileNumber;
	}

	public void setmobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Address getAddress() {
		return add;
	}

	public void setAddress(Address add) {
		this.add = add;
		System.out.println("Address is initialised");
		System.out.println("City: " + add.getCity());
		System.out.println("State: " + add.getState());
		System.out.println("Pincode: " + add.getPinCode());

	}
	public School getSchool() {
		return sc;
	}

	public void setSchool(School sc) {
		this.sc = sc;
		System.out.println("School is initialised");
		System.out.println("School Name: " + sc.getSchoolName());
		

	}
	
	
}