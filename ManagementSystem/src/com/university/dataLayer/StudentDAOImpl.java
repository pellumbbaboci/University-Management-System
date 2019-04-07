package com.university.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.university.model.LoggedInUser;
import com.university.model.Student;

public class StudentDAOImpl implements StudentDAO {

	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public void insertStudent(Student s) {

		try {
			preparedStatement = ConnectionFactory.getConnection()
					.prepareStatement(Queries.QUERYINSERTSTUDENT.toString());
			preparedStatement.setInt(2, s.getStudentNumber());
			preparedStatement.setInt(1, s.getuID());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void updateStudent(Student s, int id) {

		try {
			preparedStatement = ConnectionFactory.getConnection()
					.prepareStatement(Queries.QUERYUPDATESTUDENTINNER.toString());
			preparedStatement.setString(1, s.getName());
			preparedStatement.setString(2, s.getSurname());
			preparedStatement.setInt(3, s.getStudentNumber());
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void updateStudentNameSurname(Student s, int id) {
		LoggedInUser.getInstance().getUser().setName(s.getName());
		LoggedInUser.getInstance().getUser().setSurname(s.getSurname());

		try {
			preparedStatement = ConnectionFactory.getConnection()
					.prepareStatement(Queries.QUERYUPDATESTUDENTNAMESURNAME.toString());
			preparedStatement.setString(1, s.getName());
			preparedStatement.setString(2, s.getSurname());
			preparedStatement.setInt(3, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deleteStudent(String id) {
		try {
			preparedStatement = ConnectionFactory.getConnection()
					.prepareStatement(Queries.QUERYDELETESTUDENTSELECTED.toString());
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ResultSet readStudent() {

		try {
			statement = ConnectionFactory.getConnection().createStatement();
			resultSet = statement.executeQuery(Queries.QUERYSELECTSTUDENTJOIN.toString());
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return resultSet;
	}

	@Override
	public int numberOfStudents() {
		Connection conn = null;
		int total = 0;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConnection();
			preparedStatement = ConnectionFactory.getConnection()
					.prepareStatement(Queries.QUERYCOUNTSTUDENTS.toString());
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

	@Override
	public String getStudentNumber(int id) {
		String number = "";

		try {
			preparedStatement = ConnectionFactory.getConnection()
					.prepareStatement(Queries.QUERYGETSTUDENTNUMBER.toString());
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				number = resultSet.getString("studentNumber");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return number;

	}

	@Override
	public void close() {

		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (ConnectionFactory.getConnection() != null) {
				ConnectionFactory.getConnection().createStatement().close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
