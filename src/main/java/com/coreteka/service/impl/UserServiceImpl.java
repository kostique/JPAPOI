package com.coreteka.service.impl;

import com.coreteka.dao.impl.UserDAOImpl;
import com.coreteka.entities.User;
import com.coreteka.service.UserService;
import com.coreteka.services.impl.UserPOIParserImpl;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public void createUser(User user) {
        new UserDAOImpl().add(user);
    }

    @Override
    public User getUserById(long id) {
        return new UserDAOImpl().getById(id);
    }

    @Override
    public List<User> getUserList() {
        return new UserDAOImpl().getAll();
    }

    @Override
    public void updateUser(User user) {
        new UserDAOImpl().update(user);
    }

    @Override
    public void deleteUser(long id) {
        new UserDAOImpl().remove(id);
    }

    @Override
    public void parseUser(String path) {
        new UserPOIParserImpl().parse(path);
    }
}
