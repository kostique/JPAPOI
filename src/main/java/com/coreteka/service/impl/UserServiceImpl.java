package com.coreteka.service.impl;

import com.coreteka.dao.UserDAO;
import com.coreteka.dao.impl.UserDAOImpl;
import com.coreteka.entities.Authorities;
import com.coreteka.entities.User;
import com.coreteka.service.AuthoritiesService;
import com.coreteka.service.UserService;
import com.coreteka.util.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserServiceImpl implements UserService {

    @Override
    public User create(User user, String role, EntityManager entityManager) {
        UserDAO userDAO = new UserDAOImpl();
        EntityManager newEntityManager;

        if (entityManager == null || !entityManager.getTransaction().isActive()) {
            newEntityManager = PersistenceUtil.getEntityManager();
            newEntityManager.getTransaction().begin();

        } else {

            newEntityManager = entityManager;
        }

        AuthoritiesService authoritiesService = new AuthoritiesServiceImpl();

        Set<Authorities> authoritiesSet = authoritiesService.getByName(role, newEntityManager);

        user.setAuthorities(authoritiesSet);

        user = userDAO.create(user, newEntityManager);

        if (entityManager == null) {
            newEntityManager.getTransaction().commit();
            newEntityManager.close();
        }

        return user;
    }

    @Override
    public User getByUsername(String username, EntityManager entityManager){
        UserDAO userDAO = new UserDAOImpl();
        User user;

        EntityManager newEntityManager;

        if (entityManager == null || !entityManager.getTransaction().isActive()) {
            newEntityManager = PersistenceUtil.getEntityManager();
            newEntityManager.getTransaction().begin();

        } else {

            newEntityManager = entityManager;
        }

        user = userDAO.getByUsername(username, newEntityManager);

        if (entityManager == null) {
            newEntityManager.getTransaction().commit();
            newEntityManager.close();
        }

        return user;
    }

    @Override
    public User update(User user) {
        UserDAO userDAO = new UserDAOImpl();

        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();

        User updatedUser = userDAO.update(user);

        entityManager.getTransaction().commit();
        entityManager.close();

        return updatedUser;
    }
}
