package com.coreteka.dao;

import com.coreteka.entities.User;

import javax.persistence.EntityManager;
import java.util.List;

public interface UserDAO {

    //create
    User create(User user);

    //read
    List<User> getUsers();

    User getById(long id);

    User getByUserName(String username);

    //update
    User update(User user);

}
