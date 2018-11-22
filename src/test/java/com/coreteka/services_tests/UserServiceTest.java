package com.coreteka.services_tests;

import com.coreteka.entities.Authorities;
import com.coreteka.entities.User;
import com.coreteka.service.AuthoritiesService;
import com.coreteka.service.UserService;
import com.coreteka.service.impl.AuthoritiesServiceImpl;
import com.coreteka.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class UserServiceTest {
    
    @Test
    public void createUser(){

        String token = String.valueOf(System.currentTimeMillis());
        User user = new User();
        user.setUsername("Fooks" + token);
        user.setPassword("12345" + token);

        UserService userService = new UserServiceImpl();
        userService.create(user, "ROLE_USER", null);
    }
}
