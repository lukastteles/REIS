package conexaoBD;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static StandardServiceRegistryBuilder serviceRegistry;
	private static SessionFactory sessionFactory;

	static {

		try {

			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
			StandardServiceRegistry standardServiceRegistry = serviceRegistry.build();
			sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);

		} catch (HibernateException he) {
			throw new ExceptionInInitializerError(he);
		}
	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;

	}

	public static void shutdown() {

		getSessionFactory().close();

	}
}