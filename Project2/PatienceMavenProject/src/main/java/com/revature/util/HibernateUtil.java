package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {	
	public static SessionFactory sFactory = getNewSessionFactory();
	public static SessionFactory getNewSessionFactory() {
		SessionFactory sessionFactory = null;
		if (sessionFactory == null) {
			// loads configuration and mappings
			Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			// builds a session factory from the service registry
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory() {
		return sFactory;
	}
	public static Session getSession() {
		
		return sFactory.openSession();
	}
}
