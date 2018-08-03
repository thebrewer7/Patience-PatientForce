package com.revature.services;

import java.util.Arrays;
import java.util.List;

import com.revature.dao.GenericDaoImpl;

public class GenericService<T> {
	static Object type = null;
	public GenericService() {
		super();
	}
	
	public GenericService(T t) {
		type = t;
	}
	
	public  List<T> getAll() {
		
		return getDao().get();
	}

	public  T getById(Integer id) {
		return getDao().get(id);
	}

	public  Boolean saveOrUpdate(T item) {
		return getDao().saveOrUpdate(Arrays.asList(item));
	}
	
	public Boolean delete(List<T> input) {
		return getDao().delete(input);
	}
	
	protected GenericDaoImpl<T> getDao() {
		GenericDaoImpl<T> gdi = new GenericDaoImpl<>(type.getClass());
		return gdi;
	}
}
