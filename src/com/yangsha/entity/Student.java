package com.yangsha.entity;

import java.util.Set;

public class Student {
     String name;
     String birthDay;
     
     Set<Subject> subjects;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	/**
	 * 
	 */
	public Student() {
		super();
	}
     
     
}
