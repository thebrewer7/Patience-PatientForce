package com.patience.dao;

import java.util.List;
import java.util.function.BiConsumer;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.patience.util.HibernateUtil;

public class GenericDaoImpl<T>{
	List<T> returnableItems = null; //At this point, we have a transient state.
	T t = null;
	
	@SuppressWarnings("unchecked")
	public List<T> getAll(){

		doSession((item, s )-> 
			item = (List<T>) s.createQuery("FROM " + getAbstractedClass(t)).list(), returnableItems);
		return returnableItems;
	}
	
	public Boolean saveItems(List<T> input) {
		return doSession((item, s) -> s.save(item), input);
	}
	
	private Boolean doSession(BiConsumer<List<T>, Session> c, List<T> item) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		
		try{
			tx = session.beginTransaction();
			c.accept(item, session);
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
	
	private <T2> String getAbstractedClass(T2 item){
		return item.getClass().getSimpleName();
	}
}
