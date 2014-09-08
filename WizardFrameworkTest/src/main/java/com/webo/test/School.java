package com.webo.test;

import com.webo.annotations.Scope;
@Scope
public class School {
	private String schoolName;

	public School() {
		System.out.println("School");
	}

	public void printSchoolName() {
		System.out.println(schoolName);
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolName() {
		// TODO Auto-generated method stub
		return schoolName;
	}

}
