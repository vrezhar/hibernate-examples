package com.example.inheritance.joined;

import com.example.inheritance.LogMessage;
import com.example.inheritance.UserData;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class HibernateJoinedInheritanceDemo {
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
        Minister anthonyFauci = new Minister();
        anthonyFauci.setFirstName("Anthony");
        anthonyFauci.setLastName("Fauci");
        anthonyFauci.setSwornInOffice(LocalDate.of(2020, 3, 1));
        anthonyFauci.setMinistry("CDC");
        Judge clarenceThomas = new Judge();
        clarenceThomas.setFirstName("Clarence");
        clarenceThomas.setLastName("Thomas");
        clarenceThomas.setSwornInOffice(LocalDate.of(1991, 7, 12));
        clarenceThomas.setCasesJudged(10000);
        clarenceThomas.setCircuit("Supreme Court");
        em.persist(anthonyFauci);
        em.persist(clarenceThomas);
        em.getTransaction().commit();
        em.getTransaction().begin();
        final var officials = em.createQuery("FROM GovernmentOfficial", GovernmentOfficial.class)
                        .getResultList();
        officials.forEach(official -> System.out.printf("Official %s, %s\n", official.getFirstName() + official.getLastName(),
                official.getClass().getSimpleName()));
        em.getTransaction().commit();
        sessionFactory.close();
    }
}
