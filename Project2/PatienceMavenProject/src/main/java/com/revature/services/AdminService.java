package com.revature.services;

import com.revature.beans.Admin;

public class AdminService extends RoleService<Admin>{
	public AdminService() {
		super(new Admin());
	}
}
