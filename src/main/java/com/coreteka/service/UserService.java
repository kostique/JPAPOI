package com.coreteka.service;

import com.coreteka.entities.User;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;

public interface UserService {

    User create(User user, String role, EntityManager entityManager);

    User getByUsername(String name, EntityManager entityManager);

    User update(User user);

}
