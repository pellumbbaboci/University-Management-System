package com.university.datalayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.university.model.Student;

public interface StudentDAO {

	void insertStudent(Student s);

	ResultSet readStudent();

	void deleteStudent(String id);

	void updateStudent(Student s, int id);

	int numberOfStudents();

	void close();

	void updateStudentNameSurname(Student s, int id);

	String getStudentNumber(int id);

}
