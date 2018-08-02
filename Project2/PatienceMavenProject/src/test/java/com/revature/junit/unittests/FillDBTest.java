package com.revature.junit.unittests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.revature.util.FillDB;

class FillDBTest {

	@Test
	void fillTest() {
		assertTrue(FillDB.fill(4));
	}

}
