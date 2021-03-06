package com.coreteka.dao.impl;

import com.coreteka.dao.UserDAO;
import com.coreteka.entities.Authorities;
import com.coreteka.entities.User;
import com.coreteka.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public User create(User user, EntityManager entityManager) {
        User createdUser = entityManager.merge(user);
        return createdUser;
    }

    @Override
    public User getById(long id) {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public User getByUsername(String username, EntityManager entityManager){
        TypedQuery<User> query = entityManager.
                createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
        return query.setParameter("username", username).getSingleResult();
    }

    @Override
    public User update(User user) {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        User updatedUser = entityManager.merge(user);
        return updatedUser;
    }
}
