package com.coreteka.service;

import com.coreteka.entities.Authorities;

import javax.persistence.EntityManager;
import java.util.List;

public interface AuthoritiesService {

    Authorities create(Authorities authorities);

    Authorities getByName(String name, EntityManager entityManager);

    List<Authorities> getAuthoritiesList();

    void update(String name);

    void delete(String name);

}
