package com.revature.junit.unittests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.beans.Patient;
import com.revature.services.PatientService;

class PatientServiceTest {
	PatientService service;

	@BeforeEach
	void setUp() throws Exception {
		service = new PatientService();
	}

	@AfterEach
	void tearDown() throws Exception {
		service = null;
	}

	@Test
	void testGetByName() {
		assertNotNull(service.getByName("Herman Begaye"));
	}

	@Test
	void testGetAll() {
		assertNotNull(service.getAll());
	}

	Patient a = null;

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
		assertNotNull(service.getByUserPass(52));
	}
}
