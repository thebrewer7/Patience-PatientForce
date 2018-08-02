package com.revature.junit.unittests;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.beans.UserPass;
import com.revature.rnd.Generator;
import com.revature.services.UserPassService;

class UserPassServiceTest {
	UserPassService ups;
	List<UserPass> us = Arrays.asList((Generator.generateUserPass(50)));
	
	@BeforeEach
	void setUp() throws Exception {
		ups = new UserPassService();
	}

	@AfterEach
	void tearDown() throws Exception {
		ups = null;
	}

//	@Test
//	void _1_insertTest() {
//		System.out.println("=================STARTING INSERT TEST==============");
//		for(UserPass up : us) {
//			assertTrue(ups.saveOrUpdate(up));
//		}
//	}
	
	@Test
	void _2_getAllTest() {
		System.out.println("=================STARTING GET ALL TEST==============");
		assertNotNull("Get All Failed", ups.getAll());
	}
	
	@Test
	void _3_getByIdTest() {
		System.out.println("=================STARTING GET BY ID TEST==============");
		assertNotNull(ups.getById(50));
	}
	
	@Test
	void _4_getByUsernameTest(){
		System.out.println("================STARTING GET USERNAME TEST================");
		assertNotNull("Get by username failed", ups.getByUsername("zold"));
	}
	
//	@Test
//	void _5_deleteTest() {
//		System.out.println("=================STARTING DELETE TEST====================");
//		assertTrue(ups.delete(us));
//	}

}
