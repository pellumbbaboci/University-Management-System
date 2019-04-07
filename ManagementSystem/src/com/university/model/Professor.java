package com.university.model;


import java.util.List;

public class Professor extends Users{

	private Integer idProfessor;
	private String salary;
	private List<Course> courseList;
	
	public Professor() {
		
	}

	public Professor(String userName, String password, String division, String name, String surname,
			String dateOfRegistration, String salary) {
		super(userName, password, division, name, surname, dateOfRegistration);
		this.salary = salary;
	}

	public Integer getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}
	
	public String getSalary() {
		return salary;
	}

	
	public List<Course> getCourseList() {
		return courseList;
	}


	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}


	public void setSalary(String salary) {
		this.salary = salary;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((courseList == null) ? 0 : courseList.hashCode());
		result = prime * result + ((idProfessor == null) ? 0 : idProfessor.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
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
		Professor other = (Professor) obj;
		if (courseList == null) {
			if (other.courseList != null)
				return false;
		} else if (!courseList.equals(other.courseList)) {
			return false;
		}
		if (idProfessor == null) {
			if (other.idProfessor != null)
				return false;
		} else if (!idProfessor.equals(other.idProfessor)) {
			return false;
		}
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary)) {
			return false;
		}
		return true;
	}
	



}
