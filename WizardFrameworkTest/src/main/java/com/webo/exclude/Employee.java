package com.webo.exclude;

import com.webo.annotations.Autoinit;


public class Employee {

	private String name;
	private long mobileNumber;
	@Autoinit
	private Address add;

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
}