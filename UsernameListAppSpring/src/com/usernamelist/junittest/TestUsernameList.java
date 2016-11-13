package com.usernamelist.junittest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.usernamelist.dao.impl.UserDaoImpl;

public class TestUsernameList {
	private String username;
	private UserDaoImpl userDaoImpl = new UserDaoImpl();

	@Before
	public void setUp() throws Exception {
		this.username = "johnnn";

	}

	@Test
	public void testUsernameLength() {
		assertTrue(username.length() >= 6);
	}

	@Test
	public void testUserExist() {
		try {
			boolean exist = userDaoImpl.checkIfUserExist(username);
			assertFalse(exist);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testIfUserResricted() {
		try {
//			username = "abusee";
			boolean exist = userDaoImpl.checkIfUserResricted(username);
			assertFalse(exist);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddRestictedUser() {
		try {
			boolean test = userDaoImpl.addToResticted(username);
			assertTrue(test);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testAddUser() {
		try {
			boolean test = userDaoImpl.addToUsers(username);
			System.err.println("testAddUser "+test);
			assertTrue(test);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
