package com.coreteka.util;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class PersistenceUtil {

    private static EntityManagerFactory emFactory = null;
    private static EntityManager entityManager = null;

    public static EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()){
            entityManager = getEntityManagerFactory().createEntityManager();
        }
        return entityManager;
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emFactory == null) {
            emFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
            return emFactory;
        } else
            return emFactory;
    }

    public static void close() {
        emFactory.close();
    }
}