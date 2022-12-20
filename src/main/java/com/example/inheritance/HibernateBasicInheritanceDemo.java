package com.example.inheritance;

import com.example.BasicTypesEntity;
import com.example.DateExamplesEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.engine.jdbc.BlobProxy;
import org.hibernate.engine.jdbc.ClobProxy;

import javax.persistence.EntityManager;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class HibernateBasicInheritanceDemo {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate-inheritance.cfg.xml")
                .applySetting("hibernate.connection.username", System.getenv("DATABASE_USER"))
                .applySetting("hibernate.connection.password", System.getenv("DATABASE_PASSWORD"))
                .build();
        final SessionFactory sessionFactory;
        try {
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
            System.exit(1);
            return;//For the compiler not to complain
        }
        final EntityManager em = sessionFactory.openSession();
        em.getTransaction().begin();
        UserData userData = new UserData();
        userData.setFirstName("John");
        userData.setLastName("Doe");
        em.persist(userData);
        LogMessage logMessage = new LogMessage();
        logMessage.setMessage("Created John Doe");
        em.persist(logMessage);
        em.getTransaction().commit();
        em.getTransaction().begin();
        final var johnDoe = em.createQuery("FROM UserData WHERE firstName='John'", UserData.class)
                .getSingleResult();
        johnDoe.setLastName("Doe the second");
        final var initialLogs = em.createQuery("FROM LogMessage ").getResultList();
        System.out.println("John's version: " + johnDoe.getVersion());
        System.out.println("Log count: " + initialLogs.size());
        LogMessage changeMessage = new LogMessage();
        changeMessage.setMessage("John Doe updated");
        em.persist(johnDoe);
        em.persist(changeMessage);
        em.getTransaction().commit();
        em.getTransaction().begin();
        final var logs = em.createQuery("FROM LogMessage ").getResultList();
        final var johnDoeTheSecond = em.createQuery("FROM UserData WHERE firstName=:name", UserData.class)
                .setParameter("name", "John")
                .getSingleResult();
        System.out.println("John's version: " + johnDoeTheSecond.getVersion());
        System.out.println("Log count: " + logs.size());
        em.getTransaction().commit();
        sessionFactory.close();
    }
}
