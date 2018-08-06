package com.revature.dao;

import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.util.HibernateUtil;

public class GenericDaoImpl<T> {
	private String tClass;
	private static Session session = HibernateUtil.getSession();

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
		startTransaction();

		List<T> list = session.createQuery("FROM " + tClass).list();

		finishTransaction();
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
		startTransaction();

		Query q = session.createQuery("FROM " + tClass + " WHERE " + columnName + " = '" + value + "'");
		List<T> list = q.list();

		finishTransaction();
		return (list.isEmpty()) ? null : list;
	}

	@SuppressWarnings("unchecked")
	public T getRoleByUserPass(Integer userpass_id) {
		startTransaction();

		T result = (T) session.createQuery("FROM " + tClass + " WHERE userpass_id = :id")
				.setParameter("id", userpass_id).uniqueResult();

		finishTransaction();
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
		startTransaction();

		T result = (T) session.createQuery("FROM " + tClass + " WHERE id = :id").setInteger("id", id).uniqueResult();

		finishTransaction();
		return result;
	}

	public <C> void init(Collection<C> collection) {
		startTransaction();
		Hibernate.initialize(collection);
		finishTransaction();
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
		try {
			startTransaction();
			item.forEach(t -> c.accept(t, session));
			finishTransaction();
			return true;
			// At this point, items is persistent
		} catch (HibernateException | ClassCastException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return false;
	}

	private void finishTransaction() {
		session.getTransaction().commit();
		if (session.isOpen())
			session.close();
	}

	private Session startTransaction() {
		if (!session.isOpen()) {
			session = HibernateUtil.getSession();
		} else {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
		}
		session.beginTransaction();
		return session;
	}
}
