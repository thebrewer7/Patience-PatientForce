package com.revature.services.doctor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.revature.beans.Patient;
import com.revature.beans.doctor.Doctor;
import com.revature.services.RoleService;

public class DoctorService extends RoleService<Doctor> {
	public DoctorService() {
		super(new Doctor());
	}

	public List<Doctor> getByPatientId(Integer id) {
		List<Doctor> doctors = new ArrayList<>();
		for (Doctor d : getDao().get()) {
			for (Patient p : d.patients) {
				if (p.getId() == id) {
					doctors.add(d);
				}
			}
		}

		return doctors;
	}
	
	public List<Doctor> getWithReviews(String name){
		return initializeReviews(getDao().get("name", name));
	}
	
	public Doctor getWithReviews(Integer userpass_id) {
		return initializeReviews(Arrays.asList(getDao().getRoleByUserPass(userpass_id))).get(0);
	}
	
	private List<Doctor> initializeReviews(List<Doctor> doctors){
		doctors.forEach(doc -> getDao().init(doc.getReviews()));
		return doctors;
	}
}
