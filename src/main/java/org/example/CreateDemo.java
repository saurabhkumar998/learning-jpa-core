package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class CreateDemo
{
    public static void main( String[] args )
    {
        System.out.println( "App Started!" );

        Student student1 = new Student(3, "Gaurav", 20);
        Student student2 = new Student(4, "Kishan", 21);
        Student student3 = new Student(5, "Aditya", 17);

        // creating EntityManagerFactory which is similar to Hibernate's SessionFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA_DEMO");
        // creating EntityManager which is similar to Hibernate's Session
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // creating EntityTransaction which is similar to Hibernate's Transaction
        EntityTransaction transaction = entityManager.getTransaction();

        // starting the transaction
        transaction.begin();
        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);


        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
