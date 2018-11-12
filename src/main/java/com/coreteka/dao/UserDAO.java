package com.coreteka.dao;

import com.coreteka.entities.User;

import java.util.List;

public interface UserDAO {

    //create
    void add(User user);

    //read
    List<User> getAll();

    User getById(long id);

    //update
    void update(User user);

    //delete
    void remove(long id);
}
