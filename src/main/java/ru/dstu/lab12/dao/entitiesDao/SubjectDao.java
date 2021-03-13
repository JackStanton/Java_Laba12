package ru.dstu.lab12.dao.entitiesDao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dstu.lab12.dao.Dao;
import ru.dstu.lab12.entities.Subject;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SubjectDao implements Dao<Subject> {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Subject> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Subject", Subject.class).getResultList();
    }

    @Override
    public Subject findById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Subject.class, id);
    }

    @Override
    public void save(Subject obj) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(obj);
    }

    @Override
    public void deleteById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Subject obj = findById(id);
        session.delete(obj);
    }
}
