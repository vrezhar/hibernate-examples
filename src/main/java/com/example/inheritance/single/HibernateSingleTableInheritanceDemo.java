package com.example.inheritance.single;

import com.example.inheritance.LogMessage;
import com.example.inheritance.UserData;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;

public class HibernateSingleTableInheritanceDemo {
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
        Pokemon unknown = new Pokemon();
        unknown.setName("Unknown");
        unknown.setHealth(100);
        Pokemon squirtle = new WaterTypePokemon();
        squirtle.setName("Squirtle");
        squirtle.setHealth(50);
        Pokemon trapinch = new EarthTypePokemon();
        trapinch.setName("Trapinch");
        trapinch.setHealth(75);
        em.persist(unknown);
        em.persist(squirtle);
        em.persist(trapinch);
        em.getTransaction().commit();
        em.getTransaction().begin();
        final var allPokemons = em.createQuery("FROM Pokemon", Pokemon.class).getResultList();
        allPokemons.forEach(pokemon -> System.out.printf("Type of %s: %s\n", pokemon.getName(),
                pokemon.getClass().getSimpleName()));
        final var onlyWaterTypes = em.createQuery("FROM WaterTypePokemon", WaterTypePokemon.class)
                .getResultList();
        System.out.println("Amount of water type pokemons: " + onlyWaterTypes.size());
        em.getTransaction().commit();
        sessionFactory.close();
    }
}
