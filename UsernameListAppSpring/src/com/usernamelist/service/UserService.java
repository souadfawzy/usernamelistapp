/**
 *
 */
package com.usernamelist.service;

import java.sql.SQLException;
import java.util.List;


public interface UserService
{
		public void isValidUser(String username) throws SQLException;
		public boolean checkIfUserExist(String username)throws SQLException;
		public boolean checkIfUserResricted(String username)throws SQLException;
		public List<String> generateAlternatUserNames(String username);
		public boolean addToResticted(String username) throws SQLException;
}
