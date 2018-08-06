package com.revature.junit.unittests;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import com.revature.beans.Patient;
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
	DoctorService dService = new DoctorService();
	NurseService nService = new NurseService();
	AdminService aService = new AdminService();
	UserPassService upService = new UserPassService();
	HistoryService hService = new HistoryService();
	PatientService pService = new PatientService();
	ReviewService rService = new ReviewService();
	UserService uService = new UserService();
	DocBackgroundService dBackService = new DocBackgroundService();
	DocCertsService dCertService = new DocCertsService();
	DocDegreeService dDegService = new DocDegreeService();
	DocExperienceService dExpService = new DocExperienceService();
	NurseCertsService nCertService = new NurseCertsService();
	
	
	@Test
	void adminGetAll() {
		assertNotNull(aService.getAll());
	}

	@Test
	void historyGetAll() {
		assertNotNull(hService.getAll());
	}

	@Test
	void patientGetAll() {
		assertNotNull(pService.getAll());
	}

	@Test
	void ReviewGetAll() {
		assertNotNull(rService.getAll());
	}

	@Test
	void UserPassGetAll() {
		assertNotNull(upService.getAll());
	}

	@Test
	void UserGetAll() {
		assertNotNull(uService.getAll());
	}

	@Test
	void docBackgroundGetAll() {
		assertNotNull(dBackService.getAll());
	}

	@Test
	void docCertsGetAll() {
		assertNotNull(dCertService.getAll());
	}

	@Test
	void docDegreeGetAll() {
		assertNotNull(dDegService.getAll());
	}

	@Test
	void docExperienceGetAll() {
		assertNotNull(dExpService.getAll());
	}

	@Test
	void doctorGetAll() {
		assertNotNull(dService.getAll());
	}

	@Test
	void nurseCertsGetAll() {
		assertNotNull(nCertService.getAll());
	}

	@Test
	void NurseGetAll() {
		assertNotNull(nService.getAll());
	}

	@Test
	void adminGetById() {
		assertNotNull(aService.getById(50));
	}

	@Test
	void historyGetById() {
		assertNotNull(hService.getById(50));
	}

	@Test
	void patientGetById() {
		assertNotNull(pService.getById(50));
	}

	@Test
	void UserPassGetById() {
		assertNotNull(upService.getById(50));
	}

	@Test
	void UserGetById() {
		assertNotNull(uService.getById(50));
	}

	@Test
	void docBackgroundGetById() {
		assertNotNull(dBackService.getById(50));
	}

	@Test
	void docCertsGetById() {
		assertNotNull(dCertService.getById(50));
	}

	@Test
	void docDegreeGetById() {
		assertNotNull(dDegService.getById(50));
	}

	@Test
	void docExperienceGetById() {
		assertNotNull(dExpService.getById(50));
	}

	@Test
	void doctorGetById() {
		assertNotNull(dService.getById(50));
	}

	@Test
	void nurseCertsGetById() {
		assertNotNull(nCertService.getById(50));
	}

	@Test
	void NurseGetById() {
		assertNotNull(nService.getById(50));
	}
	
	@Test
	void DoctorGetByName() {
		assertNotNull(dService.getByName("Bernetta Ginsburg"));
	}	
	@Test
	void NurseGetByName() {
		assertNotNull(nService.getByName("Argentina Cowher"));
	}	
	@Test
	void PatientGetByName() {
		Patient p = new Patient();
		p = pService.getByName("Stacee Gerhart").get(0);
		System.out.println("PatientGetByName = " + p);
		assertNotNull(p);
	}	
	@Test
	void UserGetByName() {
		assertNotNull(uService.getByName("Brain Rubino"));
	}	
	@Test
	void AdminGetByName() {
		assertNotNull(aService.getByName("Modesto Orme"));
	}

}
