package com.revature.services;

import com.revature.beans.UserPass;

public class UserPassService extends GenericService<UserPass> {

	public UserPassService() {
		super();
	}

	public UserPassService(UserPass t) {
		super(t);
	}

	public UserPass getByUsername(String username) {
		return getDao().get("username", username).get(0);
	}
}
