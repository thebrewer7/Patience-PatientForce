package com.revature.services;

import java.util.List;

import com.revature.beans.UserPass;

public class UserPassService extends GenericService<UserPass> {

	public UserPassService() {
		super(new UserPass());
	}

	public UserPass getByUsername(String username) {
		List<UserPass> users = getDao().get("username", username);
		return (users == null) ? null : users.get(0);
	}
}
