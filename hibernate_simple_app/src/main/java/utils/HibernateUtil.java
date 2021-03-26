package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;


public class HibernateUtil {

    private static final String PERSISTENT_UNIT_NAME = "hibernate.cfg.xml";

    private static final SessionFactory sessionFactory;
//    private static final EntityManagerFactory entity;

    static {
        try {
            sessionFactory = new Configuration().configure(PERSISTENT_UNIT_NAME).buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession(){
        return sessionFactory.openSession();
    }

}
