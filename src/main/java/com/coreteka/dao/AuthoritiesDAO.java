package com.coreteka.dao;

import com.coreteka.entities.Authorities;

import java.util.List;

public interface AuthoritiesDAO {

    //create
    void add(Authorities authorities);

    //read
    List<Authorities> getAll();

    Authorities getById(long id);

    //update
    void update(long id, String name);

    //delete
    void remove(long id);

    Authorities getByName(String name);
}
