package com.revature.util;

import com.revature.beans.SuperBean;
import com.revature.rnd.Generator;
import com.revature.services.AdminService;
import com.revature.services.PatientService;
import com.revature.services.UserService;
import com.revature.services.doctor.DoctorService;
import com.revature.services.nurse.NurseService;

public class FillDB {
	public static Boolean fill(int quantity) {
		SuperBean data = Generator.generateAll(quantity);
		
		try {
		data.getAdmins().forEach(new AdminService()::saveOrUpdate);
		data.getPatients().forEach(new PatientService()::saveOrUpdate);
		data.getUsers().forEach(new UserService()::saveOrUpdate);
		data.getNurses().forEach(new NurseService()::saveOrUpdate);
		data.getDoctors().forEach(new DoctorService()::saveOrUpdate);
		return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
