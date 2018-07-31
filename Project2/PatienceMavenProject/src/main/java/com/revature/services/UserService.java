package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Patient;
import com.revature.beans.User;

public class UserService extends RoleService<User>{
	public  List<User> getUsersByPatientId(Integer id){
		List<User> users = new ArrayList<>();
		for (User user : getDao().get()) {
			for (Patient p : user.getPatients()) {
				if (p.getId() == id) {
					users.add(user);
				}
			}
		}

		return users;
	}
}
