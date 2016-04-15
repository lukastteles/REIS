package com.br.uepb.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


@SuppressWarnings("deprecation")
public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private HibernateUtil() {
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				// Create the SessionFactory from standard (hibernate.cfg.xml)
				// config file.
				/*AnnotationConfiguration ac = new AnnotationConfiguration();
				ac.addAnnotatedClass(Usuario.class);
				sessionFactory = ac.configure().buildSessionFactory();*/
				sessionFactory = new AnnotationConfiguration()
				//TODO depreceateded
                .configure().buildSessionFactory();
			} catch (Throwable ex) {
				// Log the exception.
				System.err.println("Initial SessionFactory creation failed." + ex);
				throw new ExceptionInInitializerError(ex);
			}
			return sessionFactory;
		} else {
			return sessionFactory;
		}
	}
	
	public static void closedSession(){
		sessionFactory.close();
	}
}
