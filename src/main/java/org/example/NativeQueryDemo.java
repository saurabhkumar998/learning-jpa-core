package org.example;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NativeQueryDemo {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA_DEMO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String query = "select * from student";

        Query generatedQuery = entityManager.createNativeQuery(query);

        List<Objects[]> studentList = generatedQuery.getResultList();

        for(Object[] s : studentList) {
            System.out.println(Arrays.toString(s));
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}
