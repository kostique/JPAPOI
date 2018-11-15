package com.coreteka.service;

import com.coreteka.entities.DriverProfile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.IOException;
import java.util.List;

public interface DriverProfileService {

        DriverProfile create(DriverProfile driverProfile, EntityManager entityManager);

        void create(List<DriverProfile> driverProfile, EntityManager entityManager);

        DriverProfile getById(long id);

        List<DriverProfile> getDriverProfiles();

        DriverProfile update(DriverProfile driverProfile);

        List<DriverProfile> create(File file) throws IOException, InvalidFormatException;
}
