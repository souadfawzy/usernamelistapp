package com.usernamelist.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hsqldb.Server;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server();
		server.setDatabaseName(0, "userDb");
		// server.setDatabasePath(0, "mem:mainDb");
		server.setDatabasePath(0, "userDb");
//		server.setDatabaseName(1, "standbyDb");
		server.setDatabasePath(1, "userDb");
		server.setPort(9003); // this is the default port
		server.start();

		String url = "jdbc:hsqldb:hsql://localhost/userDb";
		ResultSet rs = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection conn = DriverManager.getConnection(url, "SA", "");
			conn.prepareStatement("drop table user if exists;").execute();
			conn.prepareStatement("drop table restrictednames if exists;").execute();
			Statement stmt = conn.createStatement();
			String creatQuery = " CREATE TABLE  user (username varchar(100) NOT NULL,"
					+ "PRIMARY KEY (username))";
			stmt.executeUpdate(creatQuery);
			creatQuery = " CREATE TABLE  restrictednames (name varchar(100) NOT NULL,"
					+ "PRIMARY KEY (name))";
			stmt.executeUpdate(creatQuery);
			
			conn.prepareStatement("insert into user (username)" 
					+ "values ('souadf');").execute();
			conn.prepareStatement("insert into user (username)" 
					+ "values ('johnah');").execute();
			conn.prepareStatement("insert into user (username)" 
					+ "values ('ahmedg');").execute();
			
			
			conn.prepareStatement("insert into restrictednames (name)" 
					+ "values ('cannabis');").execute();
			conn.prepareStatement("insert into restrictednames (name)" 
					+ "values ('damnnn');").execute();
		
			conn.prepareStatement("insert into restrictednames (name)" 
					+ "values ('abusee');").execute();
		
			
			// query from the db
			rs = conn.prepareStatement("select *  from restrictednames;").executeQuery();
			rs.next();
			System.err.println(String.format(" Name: %1s", rs.getInt(1)));
			rs = conn.prepareStatement("select *  from user;").executeQuery();
			rs.next();
			System.err.println(String.format(" Name: %1s", rs.getInt(1)));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		server.stop();
		server = null;
	}

}
