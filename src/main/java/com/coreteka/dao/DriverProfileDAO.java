package com.coreteka.dao;

import com.coreteka.entities.DriverProfile;

import javax.persistence.EntityManager;
import java.util.List;

public interface DriverProfileDAO {

    //create
    DriverProfile create(DriverProfile driverProfile, EntityManager entityManager);

    //read
    List<DriverProfile> getDriverProfiles(EntityManager entityManager);

    DriverProfile getById(long id, EntityManager entityManager);

    //update
    DriverProfile update(DriverProfile driverProfile, EntityManager entityManager);

}
