package com.coreteka.dao.impl;

import com.coreteka.dao.DriverProfileDAO;
import com.coreteka.entities.DriverProfile;
import com.coreteka.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DriverProfileDAOImpl implements DriverProfileDAO {

    @Override
    public DriverProfile add(DriverProfile driverProfile) {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();
        driverProfile = entityManager.merge(driverProfile);
        entityManager.getTransaction().commit();
        entityManager.close();
        return driverProfile;
    }

    @Override
    public List<DriverProfile> getAll() {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        TypedQuery<DriverProfile> query =
                entityManager.createQuery("SELECT d FROM DriverProfile d", DriverProfile.class);
        List<DriverProfile> driverProfileList = query.getResultList();
        entityManager.close();
        return driverProfileList;
    }

    @Override
    public DriverProfile getById(long id) {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        DriverProfile driverProfile = entityManager.find(DriverProfile.class, id);
        entityManager.close();
        return driverProfile;
    }

    @Override
    public DriverProfile update(DriverProfile driverProfile) {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();
        DriverProfile updatedDriverProfile = entityManager.merge(driverProfile);
        entityManager.getTransaction().commit();
        entityManager.close();
        return updatedDriverProfile;

    }
    @Override
    public void remove(long id) {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();
        DriverProfile driverProfile = entityManager.find(DriverProfile.class, id);
        entityManager.remove(driverProfile);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}