package com.employee.pojo;

import com.address.pojo.Address;
import com.webo.annotations.Autoinit;
import com.webo.annotations.Scope;

@Scope
public class Employee {
	private int id;
	private String name;
	private long mobileNumber;
	@Autoinit
	private Address address;

	public Employee() {
		/*
		name = "Murtaza";
		mobileNumber = 12345678;
		System.out.println(name + " " + mobileNumber);
		*/
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
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
		System.out.println("Address is initialised");
		/*
		 * System.out.println("City: " + add.getCity());
		 * System.out.println("State: " + add.getState());
		 * System.out.println("Pincode: " + add.getPinCode());
		 */

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
