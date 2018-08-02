package com.revature.junit.unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.rnd.Generator;

class DataGeneratorTest {

	@Test
	void testGenerateAdmins() {
		assertNotNull(Generator.generateAdmins(10));
	}

	@Test
	void testGeneratePatients() {
		assertNotNull(Generator.generatePatients(10));
	}

	@Test
	void testGenerateUsers() {
		assertNotNull(Generator.generateUsers(10));
	}

	@Test
	void testGenerateNurses() {
		assertNotNull(Generator.generateNurses(10));
	}
	
	@Test
	void testGenerateAll() {
		assertNotNull(Generator.generateAll(10));
	}

}
