package com.coreteka.dao.impl;

import com.coreteka.dao.DriverProfileDAO;
import com.coreteka.entities.DriverProfile;
import com.coreteka.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DriverProfileDAOImpl implements DriverProfileDAO {

    @Override
    public DriverProfile create(DriverProfile driverProfile, EntityManager entityManager) {
        driverProfile = entityManager.merge(driverProfile);
        return driverProfile;
    }

    @Override
    public DriverProfile getById(long id) {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        DriverProfile driverProfile = entityManager.find(DriverProfile.class, id);
        return driverProfile;
    }

    @Override
    public DriverProfile update(DriverProfile driverProfile) {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        DriverProfile updatedDriverProfile = entityManager.merge(driverProfile);
        return updatedDriverProfile;

    }
}