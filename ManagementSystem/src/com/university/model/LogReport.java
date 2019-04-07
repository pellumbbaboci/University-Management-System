package com.university.model;

public class LogReport {
	private Integer userId;
	private String name;
	private String logInDate;
	private String logoutDate;

	public LogReport() {
	}

	public LogReport(Integer userId, String name, String logInDate, String logoutDate) {
		super();
		this.userId = userId;
		this.name = name;
		this.logInDate = logInDate;
		this.logoutDate = logoutDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogInDate() {
		return logInDate;
	}

	public void setLogInDate(String logInDate) {
		this.logInDate = logInDate;
	}

	public String getLogoutDate() {
		return logoutDate;
	}

	public void setLogoutDate(String logoutDate) {
		this.logoutDate = logoutDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((logInDate == null) ? 0 : logInDate.hashCode());
		result = prime * result + ((logoutDate == null) ? 0 : logoutDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogReport other = (LogReport) obj;
		if (logInDate == null) {
			if (other.logInDate != null)
				return false;
		} else if (!logInDate.equals(other.logInDate)) {
			return false;
		}
		if (logoutDate == null) {
			if (other.logoutDate != null)
				return false;
		} else if (!logoutDate.equals(other.logoutDate)) {
			return false;
		}
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		return true;
	}

}
