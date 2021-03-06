package com.revature.services.nurse;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Patient;
import com.revature.beans.nurse.Nurse;
import com.revature.services.RoleService;

public class NurseService extends RoleService<Nurse> {
	public NurseService() {
		super(new Nurse());
	}

	public List<Nurse> getByPatientId(Integer id) {
		List<Nurse> nurses = new ArrayList<>();
		for (Nurse n : getDao().get()) {
			for (Patient p : n.patients) {
				if (p.getId() == id) {
					nurses.add(n);
				}
			}
		}

		return nurses;
	}
}
