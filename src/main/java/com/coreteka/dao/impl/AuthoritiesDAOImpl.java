package com.coreteka.dao.impl;

import com.coreteka.dao.AuthoritiesDAO;
import com.coreteka.entities.Authorities;
import com.coreteka.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AuthoritiesDAOImpl implements AuthoritiesDAO {

    @Override
    public Authorities create(Authorities authorities) {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Authorities createdAuthorities = entityManager.merge(authorities);
        return createdAuthorities;
    }

    @Override
    public Authorities getByName(String name) {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Authorities authorities = entityManager.find(Authorities.class, name);
        return authorities;
    }

    @Override
    public List<Authorities> getAuthoritiesList() {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        TypedQuery<Authorities> query = entityManager.createQuery("Select a FROM Authorities a", Authorities.class);
        List<Authorities> authoritiesList = query.getResultList();
        return authoritiesList;
    }

    @Override
    public Authorities update(String name) {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Authorities authorities = entityManager.find(Authorities.class, name);
        authorities.setName(name);
        Authorities updatedAuthorities = entityManager.merge(authorities);
        return updatedAuthorities;
    }
}
