package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

public class DeleteDemo {
    public static void main(String[] args) {
        // creating EntityManagerFactory which is similar to Hibernate's SessionFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA_DEMO");
        // creating EntityManager which is similar to Hibernate's Session
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // creating EntityTransaction which is similar to Hibernate's Transaction
        EntityTransaction transaction = entityManager.getTransaction();

        // starting the transaction
        transaction.begin();

        // finding the student with id
        Student student = entityManager.find(Student.class, 1);

        // deleting the student by providing the student object
        entityManager.remove(student);

        // committing the transaction
        transaction.commit();

        //closing the EntityManager
        entityManager.close();

        // closing the EntityMangerFactory
        entityManagerFactory.close();



    }
}
