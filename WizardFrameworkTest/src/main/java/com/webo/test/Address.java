package com.webo.test;

public class Address {

	private String city;
	private String state;
	private String pinCode;

	public Address() {

	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
		System.out.println("set");
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		System.out.println("set");
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
		System.out.println("set");
	}

	@Override
	public String toString() {

		return city + " " + state + pinCode;

	}

}