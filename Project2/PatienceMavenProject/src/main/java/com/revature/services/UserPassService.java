package com.revature.services;

import java.util.Arrays;
import java.util.List;

import com.revature.beans.Patient;
import com.revature.beans.UserAccount;
import com.revature.beans.UserPass;
import com.revature.beans.doctor.Doctor;
import com.revature.beans.nurse.Nurse;
import com.revature.dao.GenericDaoImpl;

public class UserPassService extends GenericService<UserPass> {

	public List<?> getAccountFromUserPass(UserPass up) {
		switch (up.getType()) {
		case "user":
			GenericDaoImpl<UserAccount> gdi = new GenericDaoImpl<>(UserAccount.class);
			return Arrays.asList(gdi.getAccountFromType("string", up.getRoleId(), new UserAccount()));
		case "patient":
			GenericDaoImpl<Patient> gdi2 = new GenericDaoImpl<>(Patient.class);
			return Arrays.asList(gdi2.getAccountFromType("string", up.getRoleId(), new Patient()));
		case "nurse":
			GenericDaoImpl<Nurse> gdi3 = new GenericDaoImpl<>(Nurse.class);
			return Arrays.asList(gdi3.getAccountFromType("string", up.getRoleId(), new Nurse()));
		case "doctor":
			GenericDaoImpl<Doctor> gdi4 = new GenericDaoImpl<>(Doctor.class);
			return Arrays.asList(gdi4.getAccountFromType("string", up.getRoleId(), new Doctor()));
		default:
			System.out.println("UserPassService:getAccountFromUserPass: Type Get Failed!!!!");
			return null;
		}
	}

	public UserPass getUserPassByUsername(String username) {
		UserPassService ups = new UserPassService();
		for (UserPass up : ups.getAll()) {
			if (up.getUsername().equals(username)) {
				return up;
			}
		}
		return null;
	}

}
