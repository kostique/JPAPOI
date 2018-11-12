package com.coreteka.service.impl;

import com.coreteka.dao.impl.AuthoritiesDAOImpl;
import com.coreteka.entities.Authorities;
import com.coreteka.service.AuthoritiesService;

import java.util.List;

public class AuthoritiesServiceImpl implements AuthoritiesService {
    @Override
    public void createAuthorities(Authorities authorities) {
        new AuthoritiesDAOImpl().add(authorities);
    }

    @Override
    public Authorities getAuthoritiesById(long id) {
        return new AuthoritiesDAOImpl().getById(id);
    }

    @Override
    public List<Authorities> getAuthoritiesList() {
        return new AuthoritiesDAOImpl().getAll();
    }

    @Override
    public void updateAuthorities(long id, String name) {
        new AuthoritiesDAOImpl().update(id, name);
    }

    @Override
    public void deleteAuthorities(long id) {
        new AuthoritiesDAOImpl().remove(id);
    }

    @Override
    public Authorities getById(String name) {
        return new AuthoritiesDAOImpl().getByName(name);
    }

    public void updateAuthorities(Authorities authorities) {
        new AuthoritiesDAOImpl().add(authorities);
    }
}
