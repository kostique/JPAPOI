package com.coreteka.dao;

import com.coreteka.entities.DriverProfile;

import javax.persistence.EntityManager;
import java.util.List;

public interface DriverProfileDAO {

    //create
    DriverProfile create(DriverProfile driverProfile, EntityManager entityManager);


    DriverProfile getById(long id);

    //update
    DriverProfile update(DriverProfile driverProfile);

}
