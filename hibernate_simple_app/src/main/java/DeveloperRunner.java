import models.Developer;
import utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class DeveloperRunner {

//    private static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory();
    public static void main(String[] args) {

        DeveloperRunner developerRunner = new DeveloperRunner();

        System.out.println("Adding developer's records to the DB");

        /**
         * adding developer's records to the DB
         */
        developerRunner.addDeveloper("Dmitry", "Kartashov", "CoolMan", 22);
//        developerRunner.deleteDeveloper(1);
//        developerRunner.deleteDeveloper(2);
//        developerRunner.deleteDeveloper(3);

//        System.out.println("List of developers:");
//        List<Developer> developers = developerRunner.printListDevelopers();
//        for (Developer developer : developers) {
//            System.out.println(developer);
//        }
    }

    public void addDeveloper(String firstName, String lastName, String specialty, int experience) {

//// If I had used the EntityManager, the code would have looked like this:
//        EntityManager entityManager = managerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        Developer developer = new Developer(firstName, lastName, specialty, experience);
//        entityManager.persist(developer);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        System.out.println("Good");

        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Developer developer = new Developer(firstName, lastName, specialty, experience);
        session.save(developer);
        transaction.commit();
        session.close();
    }

    public void deleteDeveloper(int developerId) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Developer developer = session.get(Developer.class, developerId);
        session.delete(developer);
        transaction.commit();
        session.close();
    }


    public List<Developer> printListDevelopers() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        List<Developer> developers = session.createQuery("FROM Developer ").list();
        if (developers.isEmpty()) {
            System.out.println("list is empty!");
        }
        transaction.commit();
        session.close();
        return developers;
    }
}

