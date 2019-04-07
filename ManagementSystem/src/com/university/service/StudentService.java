package com.university.service;

import java.util.List;

import com.university.model.Enroll;
import com.university.model.Student;

public interface StudentService {

	public void registerToCourse(Enroll e);

	public void dropCourse(int value);

	public List<Enroll> getEnrolledCourses(int id);

	public void updateStudent(Student s, int id);

	public String getStudentNumber(int id);

}
