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

        AuthoritiesService authoritiesService = new AuthoritiesServiceImpl();
        Authorities authority = authoritiesService.getByName(role);
        Set<Authorities> authoritiesSet = new HashSet<>();
        authoritiesSet.add(authority);

        user.setAuthorities(authoritiesSet);

        if (entityManager == null || !entityManager.getTransaction().isActive()) {
            newEntityManager = PersistenceUtil.getEntityManager();
            newEntityManager.getTransaction().begin();

        } else {

            newEntityManager = entityManager;
        }

        user = userDAO.create(user, newEntityManager);

        if (entityManager == null) {
            newEntityManager.getTransaction().commit();
            newEntityManager.close();
        }

        return user;
    }


    @Override
    public User getById(long id) {
        UserDAO userDAO = new UserDAOImpl();
        return userDAO.getById(id);
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

        user = userDAO.getByUserName(username, newEntityManager);

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
