package com.revature.junit.unittests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.beans.Review;
import com.revature.services.ReviewService;

class ReviewServiceTest {
	ReviewService service;
	@BeforeEach
	void setUp() throws Exception {
		service = new ReviewService();
	}

	@AfterEach
	void tearDown() throws Exception {
		service = null;
	}

	@Test
	void testGetAll() {
		assertNotNull(service.getAll());
	}
	
	Review a = null;
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
}
