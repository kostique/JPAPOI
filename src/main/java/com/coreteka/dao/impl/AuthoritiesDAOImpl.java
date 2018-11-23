package com.coreteka.dao.impl;

import com.coreteka.dao.AuthoritiesDAO;
import com.coreteka.entities.Authorities;
import com.coreteka.util.PersistenceUtil;
import javax.persistence.EntityManager;


public class AuthoritiesDAOImpl implements AuthoritiesDAO {

    @Override
    public Authorities create(Authorities authorities) {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        return entityManager.merge(authorities);
    }

    @Override
    public Authorities getByName(String name, EntityManager entityManager) {
        return entityManager.find(Authorities.class, name);
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
