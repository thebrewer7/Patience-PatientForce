package com.revature.dao;

import java.util.List;
import java.util.function.BiConsumer;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.util.HibernateUtil;

public class GenericDaoImpl<T> {
	private String tClass;

	public GenericDaoImpl(Class<?> clazz) {
		tClass = clazz.getSimpleName();
	}

	/**
	 * Gets all records associated to the derived T type
	 * 
	 * @return All records associated to this class type.
	 */
	@SuppressWarnings("unchecked")
	public List<T> get() {
		Query q = HibernateUtil.getSession().createQuery("FROM " + tClass);
		if(q.list().isEmpty()) return null;
		else return (List<T>) q.list();
	}

	/**
	 * Allows for retrieval with a specific criteria from any
	 * 
	 * @param columnName
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> get(String columnName, String value) {
		Query q = HibernateUtil.getSession().createQuery("FROM " + tClass + " WHERE " + columnName + " = '" + value + "'");
		
		if(q.list().isEmpty()) return null;
		else return (List<T>) q.list();
	}

	@SuppressWarnings("unchecked")
	public T getRoleByUserPass(Integer userpass_id) {
		Query q = HibernateUtil.getSession()
				.createQuery("FROM " + tClass + " WHERE userpass_id = '" + userpass_id + "'");
		
		return (T) q.uniqueResult();
	}

	/**
	 * Gets a specific record from class of the derived T type via ID.
	 * 
	 * @param id
	 *            ID for specific record
	 * @return requested record
	 */
	@SuppressWarnings("unchecked")
	public T get(Integer id) {
		Query q = HibernateUtil.getSession().createQuery("FROM " + tClass + " WHERE id = " + id.toString());
		
		return (T) q.uniqueResult();
	}

	/**
	 * Save or update persistent or detached entities.
	 * 
	 * @param input
	 * @return success or failure; true and false respectively
	 */
	public Boolean saveOrUpdate(List<T> input) {
		return doTransaction((item, s) -> s.saveOrUpdate(item), input);
	}

	public Boolean delete(List<T> input) {
		return doTransaction((item, s) -> s.delete(item), input);
	}

	private Boolean doTransaction(BiConsumer<T, Session> c, List<T> item) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			item.forEach(t -> c.accept(t, session));
			tx.commit();
			return true;
			// At this point, items is persistent
		} catch (HibernateException | ClassCastException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}
}
