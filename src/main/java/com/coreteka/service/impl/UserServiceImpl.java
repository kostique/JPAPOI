package com.coreteka.service.impl;

import com.coreteka.dao.UserDAO;
import com.coreteka.dao.impl.UserDAOImpl;
import com.coreteka.entities.User;
import com.coreteka.service.UserService;
import com.coreteka.util.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public User create(User user) {
        UserDAO userDAO = new UserDAOImpl();
        User createdUser;

        EntityManager entityManager = PersistenceUtil.getEntityManager();

        if (entityManager.getTransaction().isActive()){
            createdUser = userDAO.create(user);
        } else {
            entityManager.getTransaction().begin();
            createdUser = entityManager.merge(user);
            entityManager.getTransaction().commit();
            entityManager.close();
        }

        return createdUser;
    }

    @Override
    public User getById(long id) {
        UserDAO userDAO = new UserDAOImpl();

        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();

        User user = userDAO.getById(id);

        entityManager.getTransaction().commit();
        entityManager.close();

        return user;
    }

    @Override
    public User getByUsername(String username){
        UserDAO userDAO = new UserDAOImpl();
        User user;

        EntityManager entityManager = PersistenceUtil.getEntityManager();

        if (entityManager.getTransaction().isActive()){
            user = userDAO.getByUserName(username);
        } else {
            entityManager.getTransaction().begin();

            user = userDAO.getByUserName(username);

            entityManager.getTransaction().commit();
            entityManager.close();
        }

        return user;
    }

    @Override
    public List<User> getUsers() {
        UserDAO userDAO = new UserDAOImpl();

        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();

        List<User> userList = userDAO.getUsers();

        entityManager.getTransaction().commit();
        entityManager.close();

        return userList;
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
