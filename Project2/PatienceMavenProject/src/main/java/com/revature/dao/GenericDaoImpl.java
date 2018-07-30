package com.revature.dao;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.util.HibernateUtil;

public  class GenericDaoImpl<T>{
	private List<T> returnableItems = null; //At this point, we have a transient state.
	private Object returnableItem = null;
	private T t = null;
	private String tClass;
	
	public GenericDaoImpl(Class<?> clazz) {
		tClass = clazz.getSimpleName();
	}
	/**
	 * Gets all records associated to the derived T type
	 * @return All records associated to this class type.
	 */
	@SuppressWarnings("unchecked")
	public List<T> get(){
		boolean success =
		doTransaction((item, s )-> 
			item = (List<T>) s.createQuery("FROM " + tClass).list(), returnableItems);
		System.out.println("Get w/ no params: " + success);
		return returnableItems;
	}
	
	/**
	 * Allows for retrieval with a specific criteria from any 
	 * @param columnName
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> get(String columnName, String value) {
		boolean success =
		doTransaction((item, s) -> returnableItems = (List<T>) s.createQuery(
				"FROM" + tClass + "WHERE " + tClass + "_" + columnName + " = " + value).list(), 
				Arrays.asList(t)
				);
		System.out.println("Get w/ Column Name and Value: " + success);
		return returnableItems;
	}
	
	/**
	 * Gets a specific record from class of the derived T type via ID. 
	 * @param id ID for specific record
	 * @return requested record
	 */
	@SuppressWarnings("unchecked")
	public T get(Integer id) {
		boolean success =
		doTransaction((item, s) -> returnableItem = s.createQuery(
				"FROM" + tClass + "WHERE " + tClass + "_id = " + id.toString()).uniqueResult(), 
				Arrays.asList(t)
				);
		System.out.println("Get w/ Integer: " + success);
		return (T)returnableItem;
	}
	
	/**
	 * Save or update persistent or detached entities.
	 * @param input
	 * @return success or failure; true and false respectively
	 */
	public Boolean saveOrUpdate(List<T> input) {
		return doTransaction((item, s) -> s.saveOrUpdate(item), input);
	}
	
	private Boolean doTransaction(BiConsumer<List<T>, Session> c, List<T> item) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try{
			tx = session.beginTransaction();
			c.accept(item, session);
			tx.commit();
			return true;
			 //At this point, items is persistent			
		}catch(HibernateException | ClassCastException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close(); 
		}
		return false;
	}
}
