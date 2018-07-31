package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Patient;
import com.revature.beans.UserAccount;

public class UserService extends RoleService<UserAccount>{
	public  List<UserAccount> getUsersByPatientId(Integer id){
		List<UserAccount> users = new ArrayList<>();
		for (UserAccount user : getDao().get()) {
			for (Patient p : user.getPatients()) {
				if (p.getId() == id) {
					users.add(user);
				}
			}
		}

		return users;
	}
}
