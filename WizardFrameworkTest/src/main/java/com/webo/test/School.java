package com.webo.test;

import com.webo.annotations.Scope;

@Scope
public class School {
	private String schoolName = "A.B.N";
	public  School() {
		System.out.println("School");
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

}
