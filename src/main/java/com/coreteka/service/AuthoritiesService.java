package com.coreteka.service;

import com.coreteka.entities.Authorities;

import java.util.List;

public interface AuthoritiesService {

    void createAuthorities(Authorities authorities);

    Authorities getAuthoritiesById(long id);

    List<Authorities> getAuthoritiesList();

    void updateAuthorities(long id, String name);

    void updateAuthorities(Authorities authorities);

    void deleteAuthorities(long id);

    Authorities getById(String name);
}
