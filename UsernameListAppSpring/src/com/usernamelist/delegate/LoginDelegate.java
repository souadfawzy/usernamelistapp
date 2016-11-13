package com.usernamelist.delegate;

import java.sql.SQLException;
import java.util.List;

import com.usernamelist.service.UserService;

public class LoginDelegate {
	private UserService userService;

	public UserService getUserService() {
		return this.userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void isValidUser(String username) throws SQLException {
		userService.isValidUser(username);
	}

	public boolean checkIfUserExist(String username) throws SQLException {
		return userService.checkIfUserExist(username);

	}
	public boolean addToResticted(String username) throws SQLException {
		 return userService.addToResticted(username);
		
	}

	public boolean checkIfUserResricted(String username) throws SQLException {
		return userService.checkIfUserResricted(username);

	}

	public List<String> generateAlternatUserNames(String username) throws SQLException {
		return userService.generateAlternatUserNames(username);

	}
}
