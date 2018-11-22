package com.coreteka.services_tests;

import com.coreteka.entities.DriverProfile;
import com.coreteka.entities.User;
import com.coreteka.service.DriverProfileService;
import com.coreteka.service.impl.DriverProfileServiceImpl;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;


public class DriverProfileServiceTest {

    @Test
    public void createDriverProfile() {
        DriverProfileService driverProfileService = new DriverProfileServiceImpl();

        //Get token for all new driverProfile properties to have unique properties
        long token = System.currentTimeMillis();

        //Create user for new driverProfile
        User user = new User();
        user.setPassword("qwerty");
        user.setUsername("userName" + token);

        //Create new driverProfile entity
        DriverProfile driverProfile = new DriverProfile();
        driverProfile.setFullName("Single");
        driverProfile.setPhone(String.valueOf(token));
        driverProfile.setUser(user);
        DriverProfile createdDriverProfile = driverProfileService.create(driverProfile, null);

        assertThat(createdDriverProfile.getId(), notNullValue());
    }



    @Test
    public void createDriverProfilesFromFile() throws IOException, InvalidFormatException {

        File file = new File("/home/kostique/IdeaProjects/JPAPOI/user_report.xlsx");

        DriverProfileService driverProfileService = new DriverProfileServiceImpl();

        driverProfileService.create(file);

    }


    @Test
    public void getDriverProfileById() {

        long driverProfileId = 1L;

        DriverProfileService driverProfileService = new DriverProfileServiceImpl();
        DriverProfile driverProfile = driverProfileService.getById(driverProfileId);

        assertThat(driverProfile.getId(), equalTo(1L));
    }


    @Test
    public void updateDriverProfile() {
        User user = new User();
        user.setUsername("Slavik");

        String newDriverProfileFullName = "FUHRER";
        String newDriverProfilePhone = "107";

        DriverProfile driverProfile = new DriverProfile();
        driverProfile.setFullName(newDriverProfileFullName);
        driverProfile.setPhone(newDriverProfilePhone);
        driverProfile.setUser(user);

        DriverProfileService driverProfileService = new DriverProfileServiceImpl();
        driverProfile = driverProfileService.update(driverProfile);
        assertThat(driverProfile.getFullName(), equalTo(newDriverProfileFullName));
        assertThat(driverProfile.getPhone(), equalTo(newDriverProfilePhone));
    }
}
