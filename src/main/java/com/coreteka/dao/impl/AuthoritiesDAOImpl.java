package com.coreteka.dao.impl;

import com.coreteka.dao.AuthoritiesDAO;
import com.coreteka.entities.Authorities;
import com.coreteka.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AuthoritiesDAOImpl implements AuthoritiesDAO {

    @Override
    public void add(Authorities authorities) {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(authorities);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Authorities> getAll() {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Authorities> query = entityManager.createQuery("Select a FROM Authorities a", Authorities.class);
        List<Authorities> authoritiesList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return authoritiesList;
    }

    @Override
    public Authorities getById(long id) {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Authorities authorities = entityManager.find(Authorities.class, id);
        entityManager.close();
        return authorities;
    }

    @Override
    public void update(long id, String name) {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Authorities authorities = entityManager.find(Authorities.class, id);
        authorities.setName(name);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    @Override
    public void remove(long id) {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Authorities authorities = entityManager.find(Authorities.class, id);
        entityManager.remove(authorities);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Authorities getByName(String name) {
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Authorities authorities = entityManager.find(Authorities.class, name);
        entityManager.close();
        return authorities;
    }
}
