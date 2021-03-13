package ru.dstu.lab12.dao.entitiesDao;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.support.JstlUtils;
import ru.dstu.lab12.dao.Dao;
import ru.dstu.lab12.entities.Student;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDao implements Dao<Student> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Student", Student.class).getResultList();
    }

    @Override
    public Student findById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Student.class, id);
    }

    @Override
    public void save(Student obj) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(obj);
    }


    @Override
    public void deleteById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Student obj = findById(id);
        session.delete(obj);
    }

    public Long getLastNumber(){
        Session session = entityManager.unwrap(Session.class);
        List<Student> resultSet = session.createQuery("FROM Student ORDER BY number_of_record_book DESC", Student.class).getResultList();
        System.out.println(resultSet);
        if (resultSet.size()>0){
            return resultSet.get(0).getNumberOfRecordBook();
        }else {
            return null;
        }
    }

    public Student getStudentNumber(Student student){
        Session session = entityManager.unwrap(Session.class);
        Long num = student.getNumberOfRecordBook();
        Query query = session.createQuery("FROM Student WHERE number_of_record_book = :param", Student.class);
        query.setParameter("param", num);
        List students = query.getResultList();
        if (students.size()>0){
            return (Student) students.get(0);
        }else {
            return null;
        }
    }
}
