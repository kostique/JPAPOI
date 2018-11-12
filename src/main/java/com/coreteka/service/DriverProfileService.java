package com.coreteka.service;

import com.coreteka.entities.DriverProfile;

import java.util.List;

public interface DriverProfileService {

        DriverProfile createDriverProfile(DriverProfile driverProfile);

        DriverProfile getDriverProfileById(long id);

        List<DriverProfile> getDriverProfileList();

        DriverProfile updateDriverProfile(DriverProfile driverProfile);

        void deleteDriverProfile(long id);
}
