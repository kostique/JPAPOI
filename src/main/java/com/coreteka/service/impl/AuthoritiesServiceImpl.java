package com.coreteka.service.impl;

import com.coreteka.dao.AuthoritiesDAO;
import com.coreteka.dao.impl.AuthoritiesDAOImpl;
import com.coreteka.entities.Authorities;
import com.coreteka.service.AuthoritiesService;
import com.coreteka.service.EntityService;

import javax.persistence.EntityManager;
import java.util.List;

public class AuthoritiesServiceImpl extends EntityService implements AuthoritiesService {
    @Override
    public Authorities create(Authorities authorities) {
        AuthoritiesDAO authoritiesDAO = new AuthoritiesDAOImpl();
        return authoritiesDAO.create(authorities);
    }

    @Override
    public Authorities getByName(String name, EntityManager entityManager) {
        AuthoritiesDAO authoritiesDAO = new AuthoritiesDAOImpl();

        if (entityManager == null){
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();

            Authorities authorities = authoritiesDAO.getByName(name, entityManager);

            entityManager.getTransaction().commit();
            entityManager.close();
            return authorities;
        }
        Authorities authorities = authoritiesDAO.getByName(name, entityManager);
        return authorities;
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
