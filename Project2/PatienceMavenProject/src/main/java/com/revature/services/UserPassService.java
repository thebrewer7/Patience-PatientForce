package com.revature.services;

import com.revature.beans.UserPass;

public class UserPassService extends GenericService<UserPass> {

	public UserPassService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserPassService(UserPass t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	public UserPass getByUsername(String username) {
		return getDao().get("username", username).get(0);
	}
}
