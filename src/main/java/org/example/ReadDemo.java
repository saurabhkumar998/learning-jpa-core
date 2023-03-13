package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ReadDemo {
    public static void main(String[] args) {

        // creating EntityManagerFactory which is similar to Hibernate's SessionFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA_DEMO");
        // creating EntityManager which is similar to Hibernate's Session
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // creating EntityTransaction which is similar to Hibernate's Transaction
        EntityTransaction transaction = entityManager.getTransaction();

        // starting the transaction
        transaction.begin();

        Student student = entityManager.find(Student.class, 1);
        System.out.println(student);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
