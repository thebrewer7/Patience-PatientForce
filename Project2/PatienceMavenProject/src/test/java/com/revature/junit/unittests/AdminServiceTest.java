package com.revature.junit.unittests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.services.AdminService;

class AdminServiceTest {
	AdminService service;
	@BeforeEach
	void setUp() throws Exception {
		service = new AdminService();
	}

	@AfterEach
	void tearDown() throws Exception {
		service = null;
	}

	@Test
	void testGetByName() {
	}

	@Test
	void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveOrUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDao() {
		fail("Not yet implemented");
	}

}
