package com.coreteka.service;

import com.coreteka.entities.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    User getUserById(long id);

    List<User> getUserList();

    void updateUser(User user);

    void deleteUser(long id);

    void parseUser(String path);

}
