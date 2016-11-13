package com.usernamelist.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * 
 * This interface will be used to communicate with the
 * Database
 */
public interface UserDao
{
		public void isValidUser(String username) throws SQLException;

		public boolean checkIfUserExist(String username) throws SQLException;

		public boolean checkIfUserResricted(String username) throws SQLException;
		public boolean addToResticted(String username) throws SQLException;

		public List<String> generateAlternatUserNames(String username);
}
