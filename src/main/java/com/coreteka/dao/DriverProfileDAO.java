package com.coreteka.dao;

import com.coreteka.entities.DriverProfile;

import java.util.List;

public interface DriverProfileDAO {

    //create
    DriverProfile add(DriverProfile driverProfile);

    //read
    List<DriverProfile> getAll();

    DriverProfile getById(long id);

    //update
    DriverProfile update(DriverProfile driverProfile);

    //delete
    void remove(long id);
}
