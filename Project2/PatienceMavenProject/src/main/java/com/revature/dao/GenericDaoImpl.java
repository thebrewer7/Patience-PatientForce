package com.revature.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import org.hibernate.FlushMode;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.util.HibernateUtil;

public class GenericDaoImpl<T> {
	private String tClass;
	// private static Session session = HibernateUtil.getSession();

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
		Session session = startTransaction();
		
		List<T> list = session.createQuery("FROM " + tClass).list();

		session.close();
		return (list.isEmpty()) ? null : list;
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
		Session session = startTransaction();

		Query q = session.createQuery("FROM " + tClass + " WHERE " + columnName + " = '" + value + "'");
		List<T> list = q.list();

		session.close();
		return (list.isEmpty()) ? null : list;
	}

	@SuppressWarnings("unchecked")
	public T getRoleByUserPass(Integer userpass_id) {
		Session session = startTransaction();

		T result = (T) session.createQuery("FROM " + tClass + " WHERE userpass_id = :id")
				.setParameter("id", userpass_id).uniqueResult();

		session.close();
		return result;
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
		Session session = startTransaction();

		T result = (T) session.createQuery("FROM " + tClass + " WHERE id = :id").setInteger("id", id).uniqueResult();

		session.close();
		return result;
	}

	public void init(List<?> collection) {
		Session session = startTransaction();
		Hibernate.initialize(collection);
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> load(Class<?> clazz, Integer id) {
		Session session = startTransaction();
		List<T> list = new ArrayList<>();
		try { list = (List<T>) session.get(clazz, id); }
		catch (ObjectNotFoundException e) {
			return null;
		}finally {
			session.close();
		}
		return list;
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
		Session session = startTransaction();
		try {

			item.forEach(t -> c.accept(t, session));
			session.getTransaction().commit();
			return true;
			// At this point, items is persistent
		} catch (HibernateException | ClassCastException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	private Session startTransaction() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.setFlushMode(FlushMode.COMMIT);
		return session;
	}
}
