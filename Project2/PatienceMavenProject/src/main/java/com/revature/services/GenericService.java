package com.revature.services;

import java.util.Arrays;
import java.util.List;

import com.revature.dao.GenericDaoImpl;

public abstract class GenericService<T> {
	T t;
	
	public  List<T> getAll() {
		
		return getDao().get();
	}

	public  T getById(Integer id) {
		return getDao().get(id);
	}

	public  Boolean saveOrUpdate(T doctor) {
		return getDao().saveOrUpdate(Arrays.asList(doctor));
	}
	
	protected GenericDaoImpl<T> getDao() {
		GenericDaoImpl<T> gdi = new GenericDaoImpl<>(t.getClass());
		return gdi;
	}
}
