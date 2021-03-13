package ru.dstu.lab12.dao.entitiesDao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.dstu.lab12.dao.Dao;
import ru.dstu.lab12.entities.Exam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ExamDao implements Dao<Exam> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Exam> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Exam",Exam.class).getResultList();
    }

    @Override
    public Exam findById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Exam.class, id);
    }

    @Override
    public void save(Exam obj) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(obj);
    }

    @Override
    public void deleteById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Exam obj = findById(id);
        session.delete(obj);
    }
}
