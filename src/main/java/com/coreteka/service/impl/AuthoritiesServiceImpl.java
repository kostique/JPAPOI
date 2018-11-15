package com.coreteka.service.impl;

import com.coreteka.dao.AuthoritiesDAO;
import com.coreteka.dao.impl.AuthoritiesDAOImpl;
import com.coreteka.entities.Authorities;
import com.coreteka.service.AuthoritiesService;

import java.util.List;

public class AuthoritiesServiceImpl implements AuthoritiesService {
    @Override
    public Authorities create(Authorities authorities) {
        AuthoritiesDAO authoritiesDAO = new AuthoritiesDAOImpl();
        return authoritiesDAO.create(authorities);
    }

    @Override
    public Authorities getByName(String name) {
        AuthoritiesDAO authoritiesDAO = new AuthoritiesDAOImpl();
        return authoritiesDAO.getByName(name);
    }

    @Override
    public List<Authorities> getAuthoritiesList() {
        AuthoritiesDAO authoritiesDAO = new AuthoritiesDAOImpl();
        return authoritiesDAO.getAuthoritiesList();
    }

    @Override
    public void update(String name) {
        AuthoritiesDAO authoritiesDAO = new AuthoritiesDAOImpl();
        authoritiesDAO.update(name);
    }

    @Override
    public void delete(String name) {
        AuthoritiesDAO authoritiesDAO = new AuthoritiesDAOImpl();
        authoritiesDAO.remove(name);
    }
}
