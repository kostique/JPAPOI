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
        entityManager.getTransaction().begin();
        Authorities createdAuthorities = entityManager.merge(authorities);
        entityManager.getTransaction().commit();
        entityManager.close();
        return createdAuthorities;
    }

    @Override
    public Authorities getByName(String name, EntityManager entityManager) {
        Authorities authorities = entityManager.find(Authorities.class, name);
        return authorities;
    }

    @Override
    public List<Authorities> getAuthoritiesList() {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Authorities> query = entityManager.createQuery("Select a FROM Authorities a", Authorities.class);
        List<Authorities> authoritiesList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return authoritiesList;
    }

    @Override
    public void update(String name) {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Authorities authorities = entityManager.find(Authorities.class, name);
        authorities.setName(name);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void remove(String name) {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Authorities authorities = entityManager.find(Authorities.class, name);
        entityManager.remove(authorities);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
