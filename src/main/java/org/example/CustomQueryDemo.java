package org.example;

import javax.persistence.*;
import java.util.List;

public class CustomQueryDemo {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA_DEMO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String query = "from Student";

        Query generatedQuery = entityManager.createQuery(query);

        List<Student> studentList = generatedQuery.getResultList();
        System.out.println(studentList);

        // running dynamic query
        String query2 = "from Student where id=:id";
        Query generatedQuery2 = entityManager.createQuery(query2);

        generatedQuery2.setParameter("id", 2);
        List<Student> studentList2 = generatedQuery2.getResultList();

        System.out.println(studentList2);

        Query updateQuery = entityManager.createQuery("update Student set age=:age where age<23");

        updateQuery.setParameter("age",40);
        updateQuery.executeUpdate();

        Query betweenQuery = entityManager.createQuery("select s from Student s where s.age between 24 and 60");
        List<Student> studentsBetween24and60 =  betweenQuery.getResultList();
        System.out.println(studentsBetween24and60);

        Query countQuery = entityManager.createQuery("Select count(s) from Student s");

        System.out.println(countQuery.getSingleResult());



        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
