package com.coreteka.service;

import com.coreteka.entities.Authorities;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;

public interface AuthoritiesService {

    Authorities create(Authorities authorities);

    Set<Authorities> getByName(String name, EntityManager entityManager);

    Authorities update(String name);

}
