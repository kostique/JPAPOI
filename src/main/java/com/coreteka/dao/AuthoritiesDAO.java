package com.coreteka.dao;

import com.coreteka.entities.Authorities;

import javax.persistence.EntityManager;
import java.util.List;

public interface AuthoritiesDAO {

    //create
    Authorities create(Authorities authorities);


    Authorities getByName(String name, EntityManager entityManager);

    //update
    Authorities update(String name);

}
