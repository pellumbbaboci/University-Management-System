package com.university.model;



public class Course {
	private Integer cID;
	private String courseName;
	private Integer hours;
	private Integer profUserID;

	public Course() {
	}

	public Course(Integer cID, String courseName, Integer hours, Integer profUserID) {
		super();
		this.cID = cID;
		this.courseName = courseName;
		this.hours = hours;
		this.profUserID = profUserID;
	}

	public Integer getProfUserID() {
		return profUserID;
	}

	public void setProfUserID(Integer profUserID) {
		this.profUserID = profUserID;
	}

	public Integer getcID() {
		return cID;
	}

	public void setcID(Integer cID) {
		this.cID = cID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cID == null) ? 0 : cID.hashCode());
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());

		result = prime * result + ((hours == null) ? 0 : hours.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (cID == null) {
			if (other.cID != null)
				return false;
		} else if (!cID.equals(other.cID)) {
			return false;
		}
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName)) {
			return false;
		}
		if (hours == null) {
			if (other.hours != null)
				return false;
		} else if (!hours.equals(other.hours)) {
			return false;
		}
		return true;
	}

}
