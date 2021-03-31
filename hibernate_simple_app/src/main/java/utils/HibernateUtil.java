package utils;

import models.Developer;
import models.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static final String HIBERNATE_CFG_XML = "hibernate.cfg.xml";

    private static final SessionFactory sessionFactory;
//    private static final EntityManagerFactory entity;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Developer.class)
                    .addAnnotatedClass(Task.class)
                    .buildSessionFactory();

        } catch (Throwable ex) {
            System.out.println("error");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession(){
        return sessionFactory.openSession();
    }

}
