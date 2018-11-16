package com.coreteka.service;

import com.coreteka.entities.User;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;

public interface UserService {

    User create(User user, EntityManager entityManager);

    User getById(long id);

    User getByUsername(String name, EntityManager entityManager);

    List<User> getUsers();

    void update(User user);

    void deleteUser(long id);

}
