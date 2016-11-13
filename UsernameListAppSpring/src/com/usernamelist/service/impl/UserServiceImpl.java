package com.usernamelist.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.usernamelist.dao.UserDao;
import com.usernamelist.service.UserService;

public class UserServiceImpl implements UserService
{

		private UserDao userDao;

		public UserDao getUserDao()
		{
				return this.userDao;
		}

		public void setUserDao(UserDao userDao)
		{
				this.userDao = userDao;
		}

		@Override
		public void isValidUser(String username) throws SQLException
		{
				
			userDao.isValidUser(username);
		}
		@Override
		public boolean checkIfUserExist(String username) throws SQLException{
			return userDao.checkIfUserExist(username);
			
		}
		@Override
		public boolean checkIfUserResricted(String username) throws SQLException{
			return userDao.checkIfUserResricted(username);
			
		}
		@Override
		public List<String> generateAlternatUserNames(String username){
			return userDao.generateAlternatUserNames(username);
			
		}

		@Override
		public boolean addToResticted(String username) throws SQLException {
			return userDao.addToResticted(username);
			
		}
}
