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

    private static EntityManagerFactory getEntityManagerFactory() {
        if (emFactory == null) {
            emFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        }
            return emFactory;
    }

    public static void close() {
        emFactory.close();
    }

//    public static void beginTransaction(){
//        if (!getEntityManager().getTransaction().isActive())
//            entityManager.getTransaction().begin();
//    }
//
//    public static void commitTransaction(){
//        if(getEntityManager().getTransaction().isActive()){
//           entityManager.getTransaction().commit();
//        }
//    }
}