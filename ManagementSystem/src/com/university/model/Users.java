package com.university.model;

import java.util.List;

public class Users {

	private Integer uID;
	private String userName;
	private String password;
	private String division;
	private String name;
	private String surname;
	private String dateOfRegistration;
	private List<Student> studentList;
	private List<Professor> professorList;

	public Users() {

	}

	public Users(String userName, String password, String division, String name, String surname,
			String dateOfRegistration) {
		super();
		this.userName = userName;
		this.password = password;
		this.division = division;
		this.name = name;
		this.surname = surname;
		this.dateOfRegistration = dateOfRegistration;
	}

	public Integer getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List<Professor> getProfessorList() {
		return professorList;
	}

	public void setProfessorList(List<Professor> professorList) {
		this.professorList = professorList;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String string) {
		this.password = string;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfRegistration == null) ? 0 : dateOfRegistration.hashCode());
		result = prime * result + ((division == null) ? 0 : division.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((professorList == null) ? 0 : professorList.hashCode());
		result = prime * result + ((studentList == null) ? 0 : studentList.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((uID == null) ? 0 : uID.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		Users other = (Users) obj;
		if (dateOfRegistration == null) {
			if (other.dateOfRegistration != null)
				return false;
		} else if (!dateOfRegistration.equals(other.dateOfRegistration)) {
			return false;}
		if (division == null) {
			if (other.division != null)
				return false;
		} else if (!division.equals(other.division)) {
			return false;}
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name)) {
			return false;}
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password)) {
			return false;}
		if (professorList == null) {
			if (other.professorList != null)
				return false;
		} else if (!professorList.equals(other.professorList)) {
			return false;}
		if (studentList == null) {
			if (other.studentList != null)
				return false;
		} else if (!studentList.equals(other.studentList)) {
			return false;}
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname)) {
			return false;}
		if (uID == null) {
			if (other.uID != null)
				return false;
		} else if (!uID.equals(other.uID)) {
			return false;}
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName)) {
			return false;
		}
		return true;
	}

}
