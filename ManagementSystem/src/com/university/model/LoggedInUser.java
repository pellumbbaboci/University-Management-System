package com.university.model;

public class LoggedInUser {

	private static LoggedInUser instance;
	private String language;
	private Users user;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	private LoggedInUser() {
	}

	public static LoggedInUser getInstance() {
		if (instance == null) {
			instance = new LoggedInUser();
		}
		return instance;
	}

	public void logOut() {
		user.setuID(0);
	}

}
