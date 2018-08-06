package com.revature.junit.unittests;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import com.revature.beans.doctor.Doctor;
import com.revature.services.doctor.DoctorService;
import com.revature.services.nurse.NurseService;

class TestLazyLoading {
	DoctorService dService = new DoctorService();
	NurseService nService = new NurseService();
	
	@Test
	void doctorReviewInit() {
		Doctor doctor = dService.getWithReviews(66);
		assertNotNull(doctor.getReviews());
	}

}
