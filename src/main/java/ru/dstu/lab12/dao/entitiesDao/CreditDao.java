package ru.dstu.lab12.dao.entitiesDao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.dstu.lab12.dao.Dao;
import ru.dstu.lab12.entities.Credit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CreditDao implements Dao<Credit> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Credit> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Credit", Credit.class).getResultList();
    }

    @Override
    public Credit findById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Credit.class, id);
    }

    @Override
    public void save(Credit obj) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(obj);
    }

    @Override
    public void deleteById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Credit obj = findById(id);
        session.delete(obj);
    }
}
