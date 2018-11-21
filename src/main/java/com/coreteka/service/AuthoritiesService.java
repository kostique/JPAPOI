package com.coreteka.service;

import com.coreteka.entities.Authorities;

import javax.persistence.EntityManager;
import java.util.List;

public interface AuthoritiesService {

    Authorities create(Authorities authorities);

    Authorities getByName(String name);

    List<Authorities> getAuthoritiesList();

    Authorities update(String name);

}
