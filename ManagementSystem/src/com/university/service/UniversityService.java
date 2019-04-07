package com.university.service;

import java.util.List;

import com.university.model.*;

public interface UniversityService {

	public void addStudent(Student s);

	public void addProfessor(Professor p);

	public void addUser(Users u);

	public void addCourse(Course c);

	public void deleteCourse(int id);

	public void deleteProfessor(String id);

	public void deleteStudent(String id);

	public void deleteUser(String id);

	public void updateProfessor(Professor p, int id);

	public void updateStudent(Student s, int id);

	public void updateCourse(Course c, int id);

	public void updateUser(Users u, int id);

	public int countStudents();

	public int countProfessors();

	public int countCourses();

	public List<Users> readUsers();

	public List<Course> getAllCourses();

	public List<Student> getAllStudents();

	public List<Professor> getAllProfessors();

	public String loginControl(Users u);

}
