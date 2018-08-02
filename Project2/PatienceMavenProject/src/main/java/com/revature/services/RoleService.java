package com.revature.services;

import java.util.List;

public class RoleService<T> extends GenericService<T> {
	public RoleService() {
		super();
	}
	public RoleService(T t) {
		super(t);
	}
	public  List<T> getByName(String name) {
		return getDao().get("name", name);
	}
	
	public T getByUserPass(Integer userpass_id) {
		return getDao().getRoleByUserPass(userpass_id);
	}
}
