package com.revature.junit.unittests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.beans.User;
import com.revature.services.UserService;

class UserServicetest {
	UserService service;
	
	@BeforeEach
	void setUp() throws Exception {
		service = new UserService();
	}

	@AfterEach
	void tearDown() throws Exception {
		service = null;
	}

	@Test
	void testGetAllUsers() {
		assertNotNull(service.getAllUsers());
	}

	@Test
	void testGetUserById_positive() {
		assertNotNull(service.getUserById(1));
	}
	
	@Test
	void testGetUserById_zero() {
		assertNull(service.getUserById(0));
	}
	
	@Test
	void testGetUseById_negative(){
		assertNull(service.getUserById(-1));
	}

	@Test
	void testGetUsersByName_notNull() {
		assertNotNull(service.getUsersByName("test"));
	}
	
	@Test
	void testGetUsersByName_null() {
		assertNull(service.getUsersByName("null"));
	}

	@Test
	void testGetUsersByPatient_positive() {
		assertNotNull(service.getUsersByPatient(1));
	}
	
	@Test
	void testGetUsersByPatient_zero() {
		assertNotNull(service.getUsersByPatient(0));
	}
	@Test
	void testGetUsersByPatient_negative() {
		assertNotNull(service.getUsersByPatient(-1));
	}

	@Test
	void testInsertNewUser() {
		assertTrue(service.insertNewUser(new User()));
	}

	@Test
	void testUpdateUser() {
		fail("Not yet implemented");
	}

}
