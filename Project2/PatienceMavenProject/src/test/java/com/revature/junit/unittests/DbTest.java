package com.revature.junit.unittests;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import com.revature.util.HibernateUtil;

class DbTest {

	@Test
	void testSessionFactory() {
		assertNotNull("Connection to DB failed: Couldn't make session factory", HibernateUtil.getSessionFactory());
	}

	@Test
	void testSession() {
		assertNotNull("Connection to DB failed: Couldn't make session", HibernateUtil.getSession());
	}

}
