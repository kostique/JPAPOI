package com.coreteka.dao;

import com.coreteka.entities.Authorities;

import java.util.List;

public interface AuthoritiesDAO {

    //create
    Authorities create(Authorities authorities);

    //read
    List<Authorities> getAuthoritiesList();

    Authorities getByName(String name);

    //update
    void update(String name);

    //delete
    void remove(String name);

}
