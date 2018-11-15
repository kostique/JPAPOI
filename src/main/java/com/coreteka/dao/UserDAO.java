package com.coreteka.dao;

import com.coreteka.entities.User;

import javax.persistence.EntityManager;
import java.util.List;

public interface UserDAO {

    //create
    User create(User user, EntityManager entityManager);

    //read
    List<User> getAll();

    User getById(long id);

    //update
    void update(User user);

    //delete
    void remove(long id);
}
