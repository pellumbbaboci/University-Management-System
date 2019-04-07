package com.university.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.university.model.Professor;

public class ProfessorDAOImpl implements ProfessorDAO {
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public void insertProfessor(Professor p) {

		try {
			preparedStatement = ConnectionFactory.getConnection()
					.prepareStatement(Queries.QUERYINSERTPROFESSOR.toString());
			preparedStatement.setString(1, p.getuID().toString());
			preparedStatement.setString(2, p.getSalary());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void updateProfessor(Professor p, int id) {

		try {
			preparedStatement = ConnectionFactory.getConnection()
					.prepareStatement(Queries.QUERYUPDATEPROFESSORINNER.toString());

			preparedStatement.setString(1, p.getName());
			preparedStatement.setString(2, p.getSurname());
			preparedStatement.setString(3, p.getSalary());
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteProfessor(String id) {
		try {

			preparedStatement = ConnectionFactory.getConnection()
					.prepareStatement(Queries.QUERYDELETEPROFESSORSELECTED.toString());
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ResultSet readProfessors() {

		try {
			statement = ConnectionFactory.getConnection().createStatement();
			resultSet = statement.executeQuery(Queries.QUERYSELECTPROFESSORJOIN.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultSet;
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

	@Override
	public int numberOfProfessors() {
		Connection conn = null;
		ResultSet rs = null;
		int total = 0;
		try {
			conn = ConnectionFactory.getConnection();
			preparedStatement = ConnectionFactory.getConnection()
					.prepareStatement(Queries.QUERYCOUNTPROFESSORS.toString());
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
