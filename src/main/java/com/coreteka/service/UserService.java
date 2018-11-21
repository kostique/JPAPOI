package com.coreteka.service;

import com.coreteka.entities.User;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;

public interface UserService {

    User create(User user);

    User getById(long id);

    User getByUsername(String name);

    List<User> getUsers();

    User update(User user);

}
