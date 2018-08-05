package com.revature.dao;

import java.util.List;
import java.util.function.BiConsumer;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

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
		Session session = getCurrentOrNewSession();
		
		List<T> list = session.createQuery("FROM " + tClass).list();

		finishTransaction(session);
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
		Session session = getCurrentOrNewSession();
		
		Query q = HibernateUtil.getSession().createQuery("FROM " + tClass + " WHERE " + columnName + " = '" + value + "'");
		List<T> list = q.list();

		finishTransaction(session);
		return (list.isEmpty()) ? null : list;
	}

	@SuppressWarnings("unchecked")
	public T getRoleByUserPass(Integer userpass_id) {
		Session session = getCurrentOrNewSession();

		T result = (T) session.createQuery("FROM " + tClass + " WHERE userpass_id = :id")
				.setParameter("id", userpass_id).uniqueResult();

		finishTransaction(session);
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
		Session session = getCurrentOrNewSession();

		T result = (T) session.createQuery("FROM " + tClass + " WHERE id = :id").setInteger("id", id).uniqueResult();

		finishTransaction(session);
		return result;
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
		Session session = getCurrentOrNewSession();

		try {
			item.forEach(t -> c.accept(t, session));
			finishTransaction(session);
			return true;
			// At this point, items is persistent
		} catch (HibernateException | ClassCastException e) {

			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return false;
	}

	private Session finishTransaction(Session session) {
		session.getTransaction().commit();
		if (session.isOpen())
			session.close();
		return session;
	}

	private Session getCurrentOrNewSession() {
		Session session = null;

		if (HibernateUtil.getSessionFactory().getCurrentSession() != null) {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
		} else {
			session = HibernateUtil.getSession();
		}
		session.beginTransaction();
		return session;
	}
}
