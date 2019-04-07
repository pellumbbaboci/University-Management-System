package com.university.datalayer;

import java.sql.ResultSet;

import com.university.model.Users;

public interface UserDAO {

	void addNewUser(Users u);

	ResultSet readUser();

	void deleteUser(String id);

	void updateUser(Users u, int id);

	void closeConnection();

	String loginControl(Users u);

}
