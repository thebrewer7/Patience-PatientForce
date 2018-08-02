package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.doctor.Doctor;
import com.revature.beans.nurse.Nurse;

/**
 * This is an object to move an entire database worth of information. Contains all Bean Modules
 * @author Austin
 *
 */
public class SuperBean {
	private List<Admin> admins = new ArrayList<>();
	private List<Patient> patients = new ArrayList<>();
	private List<UserAccount> users = new ArrayList<>();
	private List<Nurse> nurses = new ArrayList<>();
	private List<Doctor> doctors = new ArrayList<>();

	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public List<UserAccount> getUsers() {
		return users;
	}

	public void setUsers(List<UserAccount> users) {
		this.users = users;
	}

	public List<Nurse> getNurses() {
		return nurses;
	}

	public void setNurses(List<Nurse> nurses) {
		this.nurses = nurses;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

}
