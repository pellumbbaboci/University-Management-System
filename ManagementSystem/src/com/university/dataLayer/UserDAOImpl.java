package com.university.datalayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.university.model.LoggedInUser;
import com.university.model.Users;

public class UserDAOImpl implements UserDAO {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();

	Users u = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public String loginControl(Users u) {

		String division = null;
		try {

			preparedStatement = ConnectionFactory.getConnection()
					.prepareStatement(Queries.QUERYLOGINCONTROL.toString());
			preparedStatement.setString(1, u.getUserName());
			preparedStatement.setString(2, u.getPassword());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				u.setuID(Integer.parseInt(resultSet.getString("idUser")));
				u.setName(resultSet.getString("name"));
				u.setSurname(resultSet.getString("surname"));
				u.setDivision(resultSet.getString("division"));
				u.setUserName(resultSet.getString("userName"));
				u.setPassword(resultSet.getString("password"));
				u.setDateOfRegistration(resultSet.getString("dateOfRegistration"));

				LoggedInUser.getInstance().setUser(u);

				division = resultSet.getString("division");

			}

			return division;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return division;

	}

	@Override
	public void addNewUser(Users u) {

		try {

			preparedStatement = ConnectionFactory.getConnection().prepareStatement(Queries.QUERYINSERTUSER.toString());
			preparedStatement.setString(1, u.getUserName());
			preparedStatement.setString(2, u.getPassword());
			preparedStatement.setString(3, u.getDivision());
			preparedStatement.setString(4, u.getName());
			preparedStatement.setString(5, u.getSurname());
			preparedStatement.setString(6, u.getDateOfRegistration());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ResultSet readUser() {
		try {
			statement = ConnectionFactory.getConnection().createStatement();
			resultSet = statement.executeQuery(Queries.QUERYSELECTUSER.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override
	public void deleteUser(String id) {
		try {

			preparedStatement = ConnectionFactory.getConnection()
					.prepareStatement(Queries.QUERYDELETEUSERSELECTED.toString());
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateUser(Users u, int id) {
		try {
			preparedStatement = ConnectionFactory.getConnection().prepareStatement(Queries.QUERYUPDATEUSER.toString());
			preparedStatement.setString(1, u.getUserName());
			preparedStatement.setString(2, u.getPassword());
			preparedStatement.setString(3, u.getDivision());
			preparedStatement.setString(4, u.getName());
			preparedStatement.setString(5, u.getSurname());
			preparedStatement.setInt(6, id);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void closeConnection() {

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
