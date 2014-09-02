package com.webo.beans;

import com.webo.annotations.Autoinit;

public class Employee {

	private String name;
	private long mbNo;
	@Autoinit(state = "MH", city = "Mumbai", pinCode = "452011")
	private Address add;
	
	public Employee() {
		name="Murtaza";
		mbNo=12345678;
		System.out.println(name+" "+mbNo);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMbNo() {
		return mbNo;
	}

	public void setMbNo(long mbNo) {
		this.mbNo = mbNo;
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
