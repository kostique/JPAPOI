package com.coreteka.service.impl;

import com.coreteka.dao.*;
import com.coreteka.dao.impl.*;
import com.coreteka.entities.*;
import com.coreteka.exceptions.DriverProfileExceptions.DriverProfileNotFoundException;
import com.coreteka.service.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import javax.persistence.EntityManager;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DriverProfileServiceImpl extends EntityService implements DriverProfileService {

    @Override
    public DriverProfile create(DriverProfile driverProfile, EntityManager entityManager) {
        DriverProfileDAO driverProfileDAO = new DriverProfileDAOImpl();
        UserDAO userDAO = new UserDAOImpl();
        //Checking if entityManager is needed to be initialized as well as closed
        if (entityManager == null) {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();

            User createdUser = userDAO.create(driverProfile.getUser(), entityManager);
            driverProfile.setUser(createdUser);

            DriverProfile createdDriverProfile = driverProfileDAO.create(driverProfile, entityManager);
            entityManager.getTransaction().commit();
            entityManager.close();
            return createdDriverProfile;
        }
        //If entityManager was passed as parameter it will be closed within the invoking method
        entityManager.getTransaction().begin();

        User createdUser = userDAO.create(driverProfile.getUser(), entityManager);
        driverProfile.setUser(createdUser);

        DriverProfile createdDriverProfile = driverProfileDAO.create(driverProfile, entityManager);
        return createdDriverProfile;
    }

    @Override
    public void create(List<DriverProfile> driverProfiles, EntityManager entityManager) {
        if (entityManager == null) {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();

            iterateList(driverProfiles, entityManager);

            entityManager.getTransaction().commit();
            entityManager.close();
        }
        iterateList(driverProfiles, entityManager);
    }

    @Override
    public List<DriverProfile> create(File file, EntityManager entityManager) throws IOException, InvalidFormatException {
        ExcelParserService excelParserService = new ExcelParserServiceImpl();

        List<DriverProfile> driverProfiles = excelParserService.parse(file);

        if (entityManager == null) {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();

            create(driverProfiles, entityManager);

            entityManager.getTransaction().commit();
            entityManager.close();

            return driverProfiles;
        }
        entityManager.getTransaction().begin();

        create(driverProfiles, entityManager);

        return driverProfiles;
    }

    @Override
    public DriverProfile getById(long id) {
        DriverProfileDAO driverProfileDAO = new DriverProfileDAOImpl();
        DriverProfile driverProfile = driverProfileDAO.getById(id, getEntityManager());
        return driverProfile;
    }

    @Override
    public List<DriverProfile> getDriverProfiles() {
        DriverProfileDAO driverProfileDAO = new DriverProfileDAOImpl();
        return driverProfileDAO.getDriverProfiles(getEntityManager());
    }

    @Override
    public DriverProfile update(DriverProfile driverProfile) {
        UserDAO userDAO = new UserDAOImpl();
        Long userId = driverProfile.getUser().getId();

        User existedUser = userDAO.getById(userId);

        if (null == existedUser) {
            throw new DriverProfileNotFoundException("Driver profile with id=" + userId + " was not found.");
        }

        DriverProfileService driverProfileService = new DriverProfileServiceImpl();
        DriverProfile existingDriverProfile = driverProfileService.getById(driverProfile.getId());
        existingDriverProfile.setPhone(driverProfile.getPhone());
        existingDriverProfile.setFullName(driverProfile.getFullName());
        existingDriverProfile.setUser(existedUser);

        DriverProfileDAO driverProfileDAO = new DriverProfileDAOImpl();
        return driverProfileDAO.update(existingDriverProfile, getEntityManager());
    }

    public void iterateList(List<DriverProfile> driverProfiles, EntityManager entityManager) {
        AuthoritiesService authoritiesService = new AuthoritiesServiceImpl();
        DriverProfileDAO driverProfileDAO = new DriverProfileDAOImpl();
        UserService userService = new UserServiceImpl();
        Iterator<DriverProfile> iterator = driverProfiles.iterator();

        while (iterator.hasNext()) {
            DriverProfile driverProfile = iterator.next();

            Authorities authority = authoritiesService.getByName("ROLE_DRIVER", null);
            Set<Authorities> authoritiesSet = new HashSet<>();
            authoritiesSet.add(authority);

            User user = driverProfile.getUser();
            user.setAuthorities(authoritiesSet);
            User createdUser = userService.create(user, entityManager);

            driverProfile.setUser(createdUser);
            driverProfileDAO.create(driverProfile, entityManager);
        }
    }
}
























//        List<> excelParserService.parse(file);
//        userService.create
//        create