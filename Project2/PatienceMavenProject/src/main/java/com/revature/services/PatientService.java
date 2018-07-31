package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Patient;
import com.revature.beans.User;
import com.revature.beans.doctor.Doctor;
import com.revature.beans.nurse.Nurse;

public class PatientService extends RoleService<Patient> {
	public List<Patient> getByUser(Integer id) {
		List<Patient> patients = new ArrayList<>();
		for (Patient patient : getDao().get()) {
			for (User user : patient.getUsers()) {
				if (user.getId() == id) {
					patients.add(patient);
				}
			}
		}

		return patients;
	}

	public List<Patient> getByNurse(Integer id) {
		List<Patient> patients = new ArrayList<>();
		for (Patient patient : getDao().get()) {
			for (Nurse nurse : patient.getNurses()) {
				if (nurse.getId() == id) {
					patients.add(patient);
				}
			}
		}

		return patients;
	}

	public List<Patient> getByDoctor(Integer id) {
		List<Patient> patients = new ArrayList<>();
		for (Patient patient : getDao().get()) {
			for (Doctor doctor : patient.getDoctors()) {
				if (doctor.getId() == id) {
					patients.add(patient);
				}
			}
		}

		return patients;
	}
}
