package com.coreteka.service.impl;

import com.coreteka.dao.*;
import com.coreteka.dao.impl.*;
import com.coreteka.entities.*;
import com.coreteka.service.*;
import com.coreteka.exceptions.*;
//import com.coreteka.dao.UserDAO;
//import com.coreteka.dao.impl.DriverProfileDAOImpl;
//import com.coreteka.dao.impl.UserDAOImpl;
//import com.coreteka.entities.DriverProfile;
//import com.coreteka.entities.User;
//import com.coreteka.exceptions.DriverProfileNotFoundException;
//import com.coreteka.service.DriverProfileService;

import java.util.List;

public class DriverProfileServiceImpl implements DriverProfileService {

    @Override
    public DriverProfile createDriverProfile(DriverProfile driverProfile) {

        return new DriverProfileDAOImpl().add(driverProfile);
    }

    @Override
    public DriverProfile getDriverProfileById(long id) {
        return new DriverProfileDAOImpl().getById(id);
    }

    @Override
    public List<DriverProfile> getDriverProfileList() {
        return new DriverProfileDAOImpl().getAll();
    }

    @Override
    public DriverProfile updateDriverProfile(DriverProfile driverProfile) {
        UserDAO userDAO = new UserDAOImpl();
        Long userId = driverProfile.getUser().getId();

        User existedUser = userDAO.getById(userId);

        if (null == existedUser) {
            throw new DriverProfileNotFoundException("Driver profile with id=" + userId + " was not found.");
        }
        DriverProfileService driverProfileService = new DriverProfileServiceImpl();
        DriverProfile existingDriverProfile = driverProfileService.getDriverProfileById(driverProfile.getId());
        existingDriverProfile.setPhone(driverProfile.getPhone());
        existingDriverProfile.setFull_name(driverProfile.getFull_name());
        System.out.println(existedUser);
        existingDriverProfile.setUser(existedUser);
        return new DriverProfileDAOImpl().update(existingDriverProfile);
    }

    @Override
    public void deleteDriverProfile(long id) {
        new DriverProfileDAOImpl().remove(id);
    }
}
