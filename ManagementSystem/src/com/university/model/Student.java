package com.university.model;


import java.util.List;

public class Student extends Users {

	private Integer sID;
	private Integer studentNumber;
	private List<Course> courseList;
	
	public Student() {}
	
	public Student(String userName, String password, String division, String name, String surname, String dateOfRegistration,
			Integer studentNumber) {
		super(userName, password, division, name, surname, dateOfRegistration);
		this.studentNumber = studentNumber;
		
	}
	
	
	public Integer getsID() {
		return sID;
	}
	public void setsID(Integer sID) {
		this.sID = sID;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public Integer getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(Integer studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((courseList == null) ? 0 : courseList.hashCode());
		result = prime * result + ((sID == null) ? 0 : sID.hashCode());
		result = prime * result + ((studentNumber == null) ? 0 : studentNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (courseList == null) {
			if (other.courseList != null)
				return false;
		} else if (!courseList.equals(other.courseList)) {
			return false;
		}
		if (sID == null) {
			if (other.sID != null)
				return false;
		} else if (!sID.equals(other.sID)) {
			return false;
		}
		if (studentNumber == null) {
			if (other.studentNumber != null)
				return false;
		} else if (!studentNumber.equals(other.studentNumber)) {
			return false;
		}
		return true;
	}


	


  
	
}
