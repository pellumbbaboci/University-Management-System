package com.university.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.university.model.Course;

public class CourseDAOImpl implements CourseDAO {
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public void insertCourse(Course c) {

		try {
			preparedStatement = ConnectionFactory.getConnection()
					.prepareStatement(Queries.QUERYINSERTCOURSE.toString());
			preparedStatement.setString(1, c.getCourseName());
			preparedStatement.setInt(2, c.getHours());
			preparedStatement.setInt(3, c.getProfUserID());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void updateCourse(Course c, int id) {

		try {
			preparedStatement = ConnectionFactory.getConnection()
					.prepareStatement(Queries.QUERYUPDATECOURSE.toString());
			preparedStatement.setString(1, c.getCourseName());
			preparedStatement.setInt(2, c.getHours());
			preparedStatement.setInt(3, c.getProfUserID());
			preparedStatement.setInt(4, id);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deleteCourse(int id) {
		try {

			preparedStatement = ConnectionFactory.getConnection()
					.prepareStatement(Queries.QUERYDELETECOURSE.toString());
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ResultSet readCourse() {

		try {
			statement = ConnectionFactory.getConnection().createStatement();
			resultSet = statement.executeQuery(Queries.QUERYSELECTCOURSE.toString());
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return resultSet;
	}

	@Override
	public int numberOfCourses() {

		Connection conn = null;
		int total = 0;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConnection();
			preparedStatement = ConnectionFactory.getConnection()
					.prepareStatement(Queries.QUERYCOUNTCOURSES.toString());
			rs = preparedStatement.executeQuery();

			if (rs.next()) {
				total = Integer.parseInt(rs.getObject(1).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return total;
	}

}
