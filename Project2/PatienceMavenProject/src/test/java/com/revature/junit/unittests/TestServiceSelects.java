package com.revature.junit.unittests;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import com.revature.services.AdminService;
import com.revature.services.HistoryService;
import com.revature.services.PatientService;
import com.revature.services.ReviewService;
import com.revature.services.UserPassService;
import com.revature.services.UserService;
import com.revature.services.doctor.DocBackgroundService;
import com.revature.services.doctor.DocCertsService;
import com.revature.services.doctor.DocDegreeService;
import com.revature.services.doctor.DocExperienceService;
import com.revature.services.doctor.DoctorService;
import com.revature.services.nurse.NurseCertsService;
import com.revature.services.nurse.NurseService;

class TestServiceSelects {

	@Test
	void adminGetAll() {
		assertNotNull(new AdminService().getAll());
	}

	@Test
	void historyGetAll() {
		assertNotNull(new HistoryService().getAll());
	}

	@Test
	void patientGetAll() {
		assertNotNull(new PatientService().getAll());
	}

	@Test
	void ReviewGetAll() {
		assertNotNull(new ReviewService().getAll());
	}

	@Test
	void UserPassGetAll() {
		assertNotNull(new UserPassService().getAll());
	}

	@Test
	void UserGetAll() {
		assertNotNull(new UserService().getAll());
	}

	@Test
	void docBackgroundGetAll() {
		assertNotNull(new DocBackgroundService().getAll());
	}

	@Test
	void docCertsGetAll() {
		assertNotNull(new DocCertsService().getAll());
	}

	@Test
	void docDegreeGetAll() {
		assertNotNull(new DocDegreeService().getAll());
	}

	@Test
	void docExperienceGetAll() {
		assertNotNull(new DocExperienceService().getAll());
	}

	@Test
	void doctorGetAll() {
		assertNotNull(new DoctorService().getAll());
	}

	@Test
	void nurseCertsGetAll() {
		assertNotNull(new NurseCertsService().getAll());
	}

	@Test
	void NurseGetAll() {
		assertNotNull(new NurseService().getAll());
	}

	@Test
	void adminGetById() {
		assertNotNull(new AdminService().getById(50));
	}

	@Test
	void historyGetById() {
		assertNotNull(new HistoryService().getById(50));
	}

	@Test
	void patientGetById() {
		assertNotNull(new PatientService().getById(50));
	}

	@Test
	void UserPassGetById() {
		assertNotNull(new UserPassService().getById(50));
	}

	@Test
	void UserGetById() {
		assertNotNull(new UserService().getById(50));
	}

	@Test
	void docBackgroundGetById() {
		assertNotNull(new DocBackgroundService().getById(50));
	}

	@Test
	void docCertsGetById() {
		assertNotNull(new DocCertsService().getById(50));
	}

	@Test
	void docDegreeGetById() {
		assertNotNull(new DocDegreeService().getById(50));
	}

	@Test
	void docExperienceGetById() {
		assertNotNull(new DocExperienceService().getById(50));
	}

	@Test
	void doctorGetById() {
		assertNotNull(new DoctorService().getById(50));
	}

	@Test
	void nurseCertsGetById() {
		assertNotNull(new NurseCertsService().getById(50));
	}

	@Test
	void NurseGetById() {
		assertNotNull(new NurseService().getById(50));
	}
	
	@Test
	void DoctorGetByName() {
		assertNotNull(new DoctorService().getByName("Frieda Summerford"));
	}	
	@Test
	void NurseGetByName() {
		assertNotNull(new NurseService().getByName("Britt Modisette"));
	}	
	@Test
	void PatientGetByName() {
		assertNotNull(new PatientService().getByName("Bernetta Ginsburg"));
	}	
	@Test
	void UserGetByName() {
		assertNotNull(new UserService().getByName("Myles Sharif"));
	}	
	@Test
	void AdminGetByName() {
		assertNotNull(new AdminService().getByName("Bobbye Fisk"));
	}

}
