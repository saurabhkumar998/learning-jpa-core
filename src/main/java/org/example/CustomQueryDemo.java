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

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
