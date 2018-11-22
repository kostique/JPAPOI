package com.coreteka.service.impl;

import com.coreteka.dao.*;
import com.coreteka.dao.impl.*;
import com.coreteka.entities.*;
import com.coreteka.exceptions.DriverProfileExceptions.DriverProfileNotFoundException;
import com.coreteka.service.*;
import com.coreteka.util.PersistenceUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import javax.persistence.EntityManager;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DriverProfileServiceImpl implements DriverProfileService {

    @Override
    public DriverProfile create(DriverProfile driverProfile, EntityManager entityManager) {
        DriverProfileDAO driverProfileDAO = new DriverProfileDAOImpl();
        UserService userService = new UserServiceImpl();
        EntityManager newEntityManager;

        if (entityManager == null || !entityManager.getTransaction().isActive()) {
            newEntityManager = PersistenceUtil.getEntityManager();
            newEntityManager.getTransaction().begin();

        } else {

            newEntityManager = entityManager;
        }

        User createdUser = userService.create(driverProfile.getUser(), "ROLE_DRIVER", newEntityManager);
        driverProfile.setUser(createdUser);

        DriverProfile createdDriverProfile = driverProfileDAO.create(driverProfile, newEntityManager);

        if (entityManager == null) {
            newEntityManager.getTransaction().commit();
            newEntityManager.close();
        }

        return createdDriverProfile;

    }

    @Override
    public void create(File file, EntityManager entityManager) throws IOException, InvalidFormatException {
        ExcelParserService excelParserService = new ExcelParserServiceImpl();
        UserService userService = new UserServiceImpl();
        DriverProfileDAO driverProfileDAO = new DriverProfileDAOImpl();

        EntityManager newEntityManager;

        if (entityManager == null || !entityManager.getTransaction().isActive()) {
            newEntityManager = PersistenceUtil.getEntityManager();
            newEntityManager.getTransaction().begin();

        } else {

            newEntityManager = entityManager;
        }

        List<DriverProfile> driverProfiles = excelParserService.parse(file);
        Iterator<DriverProfile> iterator = driverProfiles.iterator();
        while (iterator.hasNext()) {
            DriverProfile driverProfile = iterator.next();
            User createdUser = userService.create(driverProfile.getUser(), "ROLE_DRIVER", newEntityManager);
            driverProfile.setUser(createdUser);
            driverProfileDAO.create(driverProfile, newEntityManager);
        }

        if (entityManager == null) {
            newEntityManager.getTransaction().commit();
            newEntityManager.close();
        }
    }

    @Override
    public DriverProfile getById(long id) {
        DriverProfileDAO driverProfileDAO = new DriverProfileDAOImpl();
        DriverProfile driverProfile = driverProfileDAO.getById(id);
        return driverProfile;
    }

    @Override
    public DriverProfile update(DriverProfile driverProfile) {
        UserDAO userDAO = new UserDAOImpl();
        String userName = driverProfile.getUser().getUsername();

        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();

        User existingUser = userDAO.getByUserName(userName, entityManager);

        if (null == existingUser) {
            throw new DriverProfileNotFoundException("Driver profile with user=" + userName + " not found.");
        }

        DriverProfileDAO driverProfileDAO = new DriverProfileDAOImpl();

        DriverProfile existingDriverProfile = driverProfileDAO.getById(existingUser.getDriverProfile().getId());

        existingDriverProfile.setPhone(driverProfile.getPhone());
        existingDriverProfile.setFullName(driverProfile.getFullName());

        DriverProfile updatedDriverProfile = driverProfileDAO.update(existingDriverProfile);

        entityManager.getTransaction().commit();
        entityManager.close();

        return updatedDriverProfile;
    }


    //To be deleted
    public void dummy() throws IOException, InvalidFormatException {
        File file = new File("/home/kostique/IdeaProjects/JPAPOI/user_report.xlsx");

        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();

        create(file, entityManager);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}