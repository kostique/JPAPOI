package com.coreteka.service.impl;

import com.coreteka.dao.AuthoritiesDAO;
import com.coreteka.dao.impl.AuthoritiesDAOImpl;
import com.coreteka.entities.Authorities;
import com.coreteka.service.AuthoritiesService;
import com.coreteka.util.PersistenceUtil;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;

public class AuthoritiesServiceImpl implements AuthoritiesService {
    @Override
    public Authorities create(Authorities authorities) {
        AuthoritiesDAO authoritiesDAO = new AuthoritiesDAOImpl();

        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();

        Authorities createdAuthorities = authoritiesDAO.create(authorities);

        entityManager.getTransaction().commit();
        entityManager.close();

        return createdAuthorities;
    }

    @Override
    public Authorities getByName(String name) {
        AuthoritiesDAO authoritiesDAO = new AuthoritiesDAOImpl();
        Authorities authorities;
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        if (entityManager.getTransaction().isActive()) {
            authorities = authoritiesDAO.getByName(name);
        } else {
            entityManager.getTransaction().begin();
            authorities = authoritiesDAO.getByName(name);
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        return authorities;

    }


    @Override
    public List<Authorities> getAuthoritiesList() {
        AuthoritiesDAO authoritiesDAO = new AuthoritiesDAOImpl();

        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();

        List<Authorities> authoritiesList = authoritiesDAO.getAuthoritiesList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return authoritiesList;
    }

    @Override
    public Authorities update(String name) {
        AuthoritiesDAO authoritiesDAO = new AuthoritiesDAOImpl();

        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();

        Authorities updatedAuthorities = authoritiesDAO.update(name);

        entityManager.getTransaction().commit();
        entityManager.close();

        return updatedAuthorities;
    }
}
