package com.university.datalayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.university.model.Enroll;

public class EnrollDAOImpl implements EnrollDAO {

	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public void enrollToCourse(Enroll e) {
		try {

			preparedStatement = ConnectionFactory.getConnection()
					.prepareStatement(Queries.QUERYINSERTENROLL.toString());
			preparedStatement.setInt(1, e.getCourseId());
			preparedStatement.setInt(2, e.getStudentId());
			preparedStatement.setString(3, e.getCourseName());
			preparedStatement.setInt(4, e.getHours());
			preparedStatement.setString(5, e.getDateOfRegistration());
			preparedStatement.executeUpdate();

		} catch (Exception evt) {
			evt.printStackTrace();
		}

	}

	@Override
	public void dropCourse(int value) {
		try {
			preparedStatement = ConnectionFactory.getConnection()
					.prepareStatement(Queries.QUERYDELETEENROLLSELECTED.toString());
			preparedStatement.setInt(1, value);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ResultSet getEnrolledCourses(int id) {
		try {
			preparedStatement = ConnectionFactory.getConnection()
					.prepareStatement(Queries.QUERYSELECTENROLL.toString());
			preparedStatement.setInt(1, id);
			preparedStatement.executeQuery();

			resultSet = preparedStatement.getResultSet();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;

	}

}
