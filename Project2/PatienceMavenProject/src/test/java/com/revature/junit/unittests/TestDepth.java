package com.revature.junit.unittests;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.beans.Patient;
import com.revature.beans.UserAccount;
import com.revature.beans.UserPass;
import com.revature.beans.doctor.Doctor;
import com.revature.beans.history.History;
import com.revature.services.HistoryService;
import com.revature.services.PatientService;
import com.revature.services.UserPassService;
import com.revature.services.UserService;
import com.revature.services.doctor.DoctorService;

class TestDepth {

	@Test
	void test1() {
		UserAccount user = new UserService().getById(50);
		List<Patient> patients = user.patients;
		System.out.println("List of Patients:" + patients.toString());
		assertNotNull(patients);
	}

	@Test
	void test2() {
		History history = new History();
		UserPass userPass = new UserPass();
		Patient patient = new Patient();

		userPass = new UserPassService().getByUsername("cellulating");
		System.out.println("TestDepth: Test2: UserPass: " + ((userPass == null) ? "null" : userPass.toString()));
		patient = new PatientService().getByUserPass(userPass.getId());
		System.out.println("TestDepth: Test2: Patient: " + ((patient == null) ? "null" : patient.toString()));
		history = new HistoryService().getById(patient.getId());
		System.out.println("TestDepth: Test2: History: " + ((history == null) ? "null" : history.toString()));
	}

	@Test
	void test3() {
		Patient editPatient = new PatientService().getById(50);
		editPatient.setLocation("TESTLOCATION");
		editPatient.setStatus("TESTSTATUS");
		new PatientService().saveOrUpdate(editPatient);
	}
	
	@Test
	void test4() {
		UserPass userPass = new UserPass();
		UserAccount user = new UserAccount();
		List<Patient> patients = new ArrayList<>();
		
		userPass = new UserPassService().getByUsername("ackintosh");
		System.out.println("TestDepth: Test4: UserPass: " + ((userPass == null) ? "null" : userPass.toString()));
		user = new UserService().getByUserPass(userPass.getId());
		System.out.println("TestDepth: Test4: user: " + ((user == null) ? "null" : user.toString()));
		patients = user.patients;
		System.out.println("TestDepth: Test4: Patients: " + ((patients == null) ? "null" : patients.toString()));
		System.out.println(patients);
	}
	
	@Test
	void test5() {
	        List<Doctor> doctors = new ArrayList<>();
	        
	        doctors = new DoctorService().getAll();
	        System.out.println("TestDepth: Test5: doctors: " + doctors.get(0));
	        System.out.println("TestDepth: Test5: doctors JSON Format: " + new DoctorService().toJSON(doctors));
	}

}
