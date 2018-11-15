package com.coreteka.service;

import com.coreteka.entities.Authorities;

import java.util.List;

public interface AuthoritiesService {

    Authorities create(Authorities authorities);

    Authorities getByName(String name);

    List<Authorities> getAuthoritiesList();

    void update(String name);

    void delete(String name);

}
