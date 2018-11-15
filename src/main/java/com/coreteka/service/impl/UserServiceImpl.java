package com.coreteka.service.impl;

import com.coreteka.dao.UserDAO;
import com.coreteka.dao.impl.UserDAOImpl;
import com.coreteka.entities.User;
import com.coreteka.service.UserService;
import javax.persistence.EntityManager;
import java.util.List;

public class UserServiceImpl extends EntityService implements UserService {

    @Override
    public User create(User user, EntityManager entityManager) {
        UserDAO userDAO = new UserDAOImpl();
        if (entityManager == null) {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            User createdUser = userDAO.create(user, entityManager);
            entityManager.getTransaction().commit();
            entityManager.close();
            return createdUser;
        }
        User createdUser = userDAO.create(user, entityManager);
        return createdUser;
    }

    @Override
    public User getById(long id) {
        return new UserDAOImpl().getById(id);
    }

    @Override
    public List<User> getUsers() {
        return new UserDAOImpl().getAll();
    }

    @Override
    public void update(User user) {
        new UserDAOImpl().update(user);
    }

    @Override
    public void deleteUser(long id) {
        new UserDAOImpl().remove(id);
    }
}
