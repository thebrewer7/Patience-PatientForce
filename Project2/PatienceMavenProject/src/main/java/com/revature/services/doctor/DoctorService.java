package com.revature.services.doctor;

import java.util.ArrayList;
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
}
