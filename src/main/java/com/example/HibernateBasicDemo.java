package com.example;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.engine.jdbc.BlobProxy;
import org.hibernate.engine.jdbc.ClobProxy;

import javax.persistence.EntityManager;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class HibernateBasicDemo {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate-basic.cfg.xml")
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
        BasicTypesEntity basicTypesEntity = new BasicTypesEntity();
        basicTypesEntity.setACharacter('C');
        basicTypesEntity.setNationalizedCharacter('漢');
        basicTypesEntity.setBasicCharacterArray(new char[]{'J', 'U', 'S', 'T', ' ', 'D', 'O', ' ', 'I', 'T'});
        basicTypesEntity.setAnInteger(5);
        basicTypesEntity.setByteValue(Byte.valueOf("4"));
        basicTypesEntity.setShortValue(Short.valueOf("5"));
        basicTypesEntity.setSimpleString("Hibernate demo");
        basicTypesEntity.setNationalizedVarchar("形声字");
        basicTypesEntity.setUuidAsBinary(UUID.randomUUID());
        basicTypesEntity.setUuidAsCompactBinary(UUID.randomUUID());
        basicTypesEntity.setUuidAsString(UUID.randomUUID());
        basicTypesEntity.setBlobData(new byte[] { 0, 0, 1 });
        basicTypesEntity.setClobData(new char[] { 'a', 'a', 'a', 'h' });
        basicTypesEntity.setJavaSqlBlob(BlobProxy.generateProxy(new byte[] { 0, 0, 1 }));
        basicTypesEntity.setJavaSqlClob(ClobProxy.generateProxy("a" + 'a' + 'a' + 'h'));
        em.persist(basicTypesEntity);
        em.getTransaction().commit();
        if(!em.getTransaction().isActive()) {
            System.out.println("Transaction not active after commit");
        }
        em.getTransaction().begin();
        DateExamplesEntity dateExamplesEntity = new DateExamplesEntity();
        dateExamplesEntity.setaCalendar(Calendar.getInstance());
        dateExamplesEntity.setaLocalDate(LocalDate.now());
        dateExamplesEntity.setaLocalDateTime(LocalDateTime.now());
        dateExamplesEntity.setaZonedDateTime(ZonedDateTime.now());
        dateExamplesEntity.setAnOffsetDateTime(OffsetDateTime.now());
        dateExamplesEntity.setSimpleDate(new Date());
        dateExamplesEntity.setSimpleInstant(Instant.now());
        dateExamplesEntity.setaLocalTime(LocalTime.now());
        dateExamplesEntity.setaZoneOffset(ZoneOffset.UTC);
        em.persist(dateExamplesEntity);
        em.getTransaction().commit();
        final var found = em.find(DateExamplesEntity.class, 1L);
        System.out.println("Found zone offset saved: " + found.getaZoneOffset());
        sessionFactory.close();
    }
}
