package com.university.model;

public class Enroll {
	private Integer courseId;
	private Integer studentId;
	private Integer hours;
	private String dateOfRegistration;
	private String courseName;

	public Enroll() {
	}

	public Enroll(Integer courseId, Integer studentId, Integer hours, String dateOfRegistration, String courseName) {
		super();
		this.courseId = courseId;
		this.studentId = studentId;
		this.hours = hours;
		this.dateOfRegistration = dateOfRegistration;
		this.courseName = courseName;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public String getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
