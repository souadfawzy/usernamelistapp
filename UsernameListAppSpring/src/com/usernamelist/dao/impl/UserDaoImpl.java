package com.usernamelist.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hsqldb.Server;

import com.usernamelist.dao.UserDao;


public class UserDaoImpl implements UserDao {

	// DataSource dataSource;
	//
	// public DataSource getDataSource()
	// {
	// return this.dataSource;
	// }
	//
	// public void setDataSource(DataSource dataSource)
	// {
	// this.dataSource = dataSource;
	// }
	Connection conn = null;

	public boolean checkIfUserExist(String username) throws SQLException {
		getconnection();
		PreparedStatement pstmt = null;
		String query = "Select * from user where username = ? ";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, username);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next()) {
			System.err.println("taken");
			return true;

		} else {
			addToUsers(username);
			return false;

		}
	}

	public boolean checkIfUserResricted(String username) throws SQLException {
		getconnection();
		PreparedStatement pstmt = null;
		String restricted = "Select * from restrictednames where name = ? ";
		pstmt = conn.prepareStatement(restricted);
		pstmt.setString(1, username);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next()) {
			System.err.println("restricted");
			return true;

		}
		return false;
	}

	@Override
	public void isValidUser(String username) throws SQLException {
		getconnection();

		addToUsers(username);

	}

	public boolean addToUsers(String name) throws SQLException {
		getconnection();
		return conn.prepareStatement("insert into user (username)" + "values ('" + name + "');").execute();
	}

	public boolean addToResticted(String name) throws SQLException {
		getconnection();
		return conn.prepareStatement("insert into restrictednames (name)" + "values ('" + name + "');").execute();
	}

	private void createTables() {

		try {
			getconnection();
			conn.prepareStatement("drop table user if exists;").execute();
			conn.prepareStatement("drop table restrictednames if exists;").execute();

			Statement stmt = conn.createStatement();
			String creatQuery = " CREATE TABLE  user (username varchar(100) NOT NULL," + "PRIMARY KEY (username))";
			stmt.executeUpdate(creatQuery);
			creatQuery = " CREATE TABLE  restrictednames (name varchar(100) NOT NULL," + "PRIMARY KEY (name))";
			stmt.executeUpdate(creatQuery);

			conn.prepareStatement("insert into user (username)" + "values ('souadf');").execute();
			conn.prepareStatement("insert into user (username)" + "values ('johnah');").execute();
			conn.prepareStatement("insert into user (username)" + "values ('ahmedg');").execute();

			conn.prepareStatement("insert into restrictednames (name)" + "values ('cannabis');").execute();
			conn.prepareStatement("insert into restrictednames (name)" + "values ('damnnn');").execute();

			conn.prepareStatement("insert into restrictednames (name)" + "values ('abusee');").execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Connection getconnection() {
		if (conn != null)
			return conn;
		Server server = new Server();
		server.setDatabaseName(0, "userDb");
		// server.setDatabasePath(0, "mem:mainDb");
		server.setDatabasePath(0, "userDb");
		// server.setDatabaseName(1, "standbyDb");
		server.setDatabasePath(1, "userDb");
		server.setPort(9001); // this is the default port
		server.start();
		try {
			Class.forName("org.hsqldb.jdbcDriver");

			String url = "jdbc:hsqldb:hsql://localhost/userDb";
			conn = DriverManager.getConnection(url, "SA", "");
			createTables();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public List<String> generateAlternatUserNames(final String username) {
		List<String> alternateUserNames = new ArrayList<>();
		alternateUserNames.add(username + username);
		alternateUserNames.add(username + username.substring(3).toUpperCase());
		Random randomGenerator = new Random();
		for (int i = 1; i <= 13; i++) {
			int randomInt = randomGenerator.nextInt(100);
			// if (!userLst.contains(username + i) &&
			// !restrictedWords.contains(username + i)) {
			alternateUserNames.add(username + randomInt);

			// }
		}

		return alternateUserNames;

	}
}