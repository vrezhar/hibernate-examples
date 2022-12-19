package com.example.multi.schema;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;

public class HibernateMultiSchemaDemo {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate-multi-schema.cfg.xml")
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
        final var transaction = em.getTransaction();
        transaction.begin();
        Example example = new Example();
        example.setName("Test");
        em.persist(example);
        transaction.commit();
        final var found = em.find(Example.class, 1L);
        assert "Test".equals(found.getName());
        final var anotherTransaction = em.getTransaction();
        anotherTransaction.begin();
        AnotherExample anotherExample = new AnotherExample();
        anotherExample.setName("TestAnother");
        em.persist(anotherExample);
        anotherTransaction.commit();
        final var anotherExampleFound = em.find(Example.class, 1L);
        assert "TestAnother".equals(anotherExampleFound.getName());
    }
}
