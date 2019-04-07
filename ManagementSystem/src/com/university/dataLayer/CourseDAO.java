package com.university.datalayer;

import java.sql.ResultSet;

import com.university.model.Course;

public interface CourseDAO {

	void insertCourse(Course c);

	void updateCourse(Course c, int id);

	void deleteCourse(int id);

	public int numberOfCourses();

	ResultSet readCourse();

}
