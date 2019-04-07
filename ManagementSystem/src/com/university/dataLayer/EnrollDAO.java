package com.university.datalayer;

import java.sql.ResultSet;

import com.university.model.Enroll;

public interface EnrollDAO {

	public void enrollToCourse(Enroll e);

	public void dropCourse(int value);

	public ResultSet getEnrolledCourses(int id);

}
