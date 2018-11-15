package com.coreteka.services_tests;

import com.coreteka.entities.Authorities;
import com.coreteka.entities.DriverProfile;
import com.coreteka.entities.User;
import com.coreteka.service.DriverProfileService;
import com.coreteka.service.UserService;
import com.coreteka.service.impl.AuthoritiesServiceImpl;
import com.coreteka.service.impl.DriverProfileServiceImpl;
import com.coreteka.service.impl.UserServiceImpl;
import com.coreteka.util.PersistenceUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;


public class DriverProfileServiceTest {

    @Test
    public void createDriverProfile() {
        UserService userService = new UserServiceImpl();
        DriverProfileService driverProfileService = new DriverProfileServiceImpl();

        User user = new User();
        user.setPassword("****asdf");
        user.setUsername("asdfq");
        user.setUserStatus(true);
        user = userService.create(user);

        DriverProfile driverProfile = new DriverProfile();
        driverProfile.setFullName("asdf_dp");
        driverProfile.setPhone("555-55-55");
        driverProfile.setUser(user);


        DriverProfile createdDriverProfile = driverProfileService.create(driverProfile);
        assertThat(createdDriverProfile.getId(), notNullValue());
    }

    @Test
    public void getDriverProfileById() {
        long driverProfileId = 16L;
        DriverProfileService driverProfileService = new DriverProfileServiceImpl();
        DriverProfile driverProfile = driverProfileService.getById(driverProfileId);
        assertThat(driverProfile.getId(), equalTo(16L));
    }

    @Test
    public void getDriverProfileList() {
        DriverProfileService driverProfileService = new DriverProfileServiceImpl();
        List<DriverProfile> driverProfiles = driverProfileService.getDriverProfiles();
        assertThat(driverProfiles.isEmpty(), is(false));
    }


    @Test
    public void updateDriverProfile() {
        User user = new User();
        user.setId(9L);

        DriverProfile driverProfile = new DriverProfile();
        driverProfile.setFullName("Lee GuanDong");
        driverProfile.setPhone("+874625487458");
        driverProfile.setUser(user);
        driverProfile.setId(16L);

        DriverProfileService driverProfileService = new DriverProfileServiceImpl();
        driverProfile = driverProfileService.update(driverProfile);
        assertThat(driverProfile.getId(), equalTo(16L));
    }


    @Test
    public void createDriverProfilesFromFile() throws IOException, InvalidFormatException {
        File file = new File("/home/kostique/IdeaProjects/JPAPOI/user_report.xlsx");

        DriverProfileService driverProfileService = new DriverProfileServiceImpl();

        List<DriverProfile> driverProfiles = driverProfileService.create(file);

        /*//Taking the last parsed DriverProfile
        String fullName = driverProfiles.get(driverProfiles.size() - 1).getFullName();

        //Trying to find this DriverProfile by its fullName in database
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery
                ("SELECT d FROM DriverProfile d WHERE d.fullName = '" + fullName + "'");
        DriverProfile driverProfile = (DriverProfile) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();

        //Checking if database contains this DriverProfile
        assertThat(driverProfile, notNullValue());*/
    }

    @Test
    public void name() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        Authorities authority = em.find(Authorities.class, "ROLE_DRIVER");

        Set<Authorities> authoritiesSet = new HashSet<>();
        authoritiesSet.add(authority);

        User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        user.setAuthorities(authoritiesSet);
        user.setUserStatus(true);

        user = em.merge(user);

        DriverProfile driverProfile = new DriverProfile();
        driverProfile.setPhone("phone");
        driverProfile.setFullName("fullName");
        driverProfile.setUser(user);
        em.merge(driverProfile);
        em.getTransaction().commit();
        em.close();
        emFactory.close();
    }
}
