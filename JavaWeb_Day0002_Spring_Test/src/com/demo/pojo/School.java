package com.demo.pojo;

public class School {
	private String schoolname;
	private String classname;
	private String curriculum;
	
	public String getSchoolname() {
		return schoolname;
	}
	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getCurriculum() {
		return curriculum;
	}
	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}
	
	public School() {}
	public School(String schoolname, String classname, String curriculum) {
		super();
		this.schoolname = schoolname;
		this.classname = classname;
		this.curriculum = curriculum;
	}
	@Override
	public String toString() {
		return "School [schoolname=" + schoolname + ", classname=" + classname + ", curriculum=" + curriculum + "]";
	}

	
		
}
