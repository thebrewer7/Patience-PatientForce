package com.revature.dao;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.util.HibernateUtil;

public class GenericDaoImpl<T> {
	private List<T> returnableItems = null; // At this point, we have a transient state.
	private Object returnableItem = null;
	private T t = null;
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
		returnableItems = q.list();
		return returnableItems;
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
		Query q = HibernateUtil.getSession().getNamedQuery("where");
		q.setParameter("cr1", columnName);
		q.setParameter("v1", value);
		boolean success = doTransaction(
				(item, s) -> returnableItems = (List<T>) s.createQuery("FROM :tName WHERE :cr1 = :v1")
						.setParameter("tName", tClass).setParameter("cr1", columnName).setParameter("v1", value).list(),
				Arrays.asList(t));

		System.out.println("Get w/ Column Name and Value: " + success);
		return returnableItems;
	}

	@SuppressWarnings("unchecked")
	public <R> R getAccountFromType(String type, Integer id, R role) {
		doTransaction((item,
				s) -> returnableItem = s.createQuery("FROM :tName WHERE :cr1 = :v1 AND :cr2 = v2")
						.setParameter("tName", tClass).setParameter("cr1", "type").setParameter("v1", type)
						.setParameter("cr2", "id").setParameter("v2", id).uniqueResult(),
				Arrays.asList(t));
		return (R) returnableItem;
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
		boolean success = doTransaction((item,
				s) -> returnableItem = s.createQuery("FROM " + tClass + " WHERE id = " + id.toString()).uniqueResult(),
				Arrays.asList(t));
		System.out.println("Get w/ Integer: " + success);
		return (T) returnableItem;
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
