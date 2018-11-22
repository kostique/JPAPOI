package com.coreteka.dao;

import com.coreteka.entities.User;

import javax.persistence.EntityManager;
import java.util.List;

public interface UserDAO {

    //create
    User create(User user, EntityManager entityManager);

    User getById(long id);

    User getByUserName(String username, EntityManager entityManager);

    //update
    User update(User user);

}
