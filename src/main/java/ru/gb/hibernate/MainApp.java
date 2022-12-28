package ru.gb.hibernate;

import org.hibernate.cfg.Configuration;
import ru.gb.hibernate.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class MainApp {
    public static void main(String[] args) {

//        SessionFactory sessionFactory = new Configuration()
//                .addAnnotatedClass(Item.class)
//                .buildSessionFactory();
//
//        Session session = null;
//
//        // === CREATE ===
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Item item = new Item("Milk", 80);
//        System.out.println(item);
//        session.save(item);
//        System.out.println(item);
//        session.getTransaction().commit();
//
//        sessionFactory.close();

        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = emFactory.createEntityManager();

        // INSERT
        em.getTransaction().begin();

        Item user = new Item("Milk", 80);
        Item user1 = new Item("Orange", 100);
        em.persist(user);
        em.persist(user1);

        em.getTransaction().commit();

        em.close();
    }
}
