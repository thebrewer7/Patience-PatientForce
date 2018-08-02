package com.revature.junit.unittests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.beans.nurse.Nurse;
import com.revature.services.nurse.NurseService;

class NurseServiceTest {
	NurseService service;
	@BeforeEach
	void setUp() throws Exception {
		service = new NurseService();
	}

	@AfterEach
	void tearDown() throws Exception {
		service = null;
	}

	@Test
	void testGetByName() {
		assertNotNull(service.getByName("Temeka Cornforth"));
	}

	@Test
	void testGetAll() {
		assertNotNull(service.getAll());
	}
	
	Nurse a = null;
	@Test
	void testGetById() {
		a = service.getById(50);
		assertNotNull(a);
	}

	@Test
	void testSaveOrUpdate() {
		assertTrue(service.saveOrUpdate(a));
	}

	@Test
	void testDelete() {
		assertTrue(service.saveOrUpdate(a));
	}
	
	@Test
	void testGetByUserPass() {
		assertNotNull(service.getByUserPass(56));
	}
}
