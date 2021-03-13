package ru.dstu.lab12.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dstu.lab12.dao.entitiesDao.*;
import ru.dstu.lab12.entities.*;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    StudentDao studentDao;

    @Autowired
    ExamDao examDao;

    @Autowired
    CreditDao creditDao;

    @Autowired
    SubjectDao subjectDao;

//    StudentDao

    @Transactional
    @Override
    public List<Student> studentFindAll() {
        return studentDao.findAll();
    }

    @Transactional
    @Override
    public Student studentFindById(Long id) {
        return studentDao.findById(id);
    }

    @Transactional
    @Override
    public boolean studentSave(Student obj){
        if(obj.getId() == null){
            generateNumberOfRecordBook(obj);
        }else{
            Student studentFromDB = studentDao.getStudentNumber(obj);
            if(studentFromDB != null){
                long idFromDB = studentFromDB.getId();
                long idFromForm = obj.getId();
                if(idFromDB != idFromForm){
                    return false;
                }else{
                    studentFromDB.setStudentName(obj.getStudentName());
                    studentFromDB.setStudentSurname(obj.getStudentSurname());
                    studentFromDB.setNumberOfRecordBook(obj.getNumberOfRecordBook());
                    studentDao.save(studentFromDB);
                    return true;
                }
            }
        }
        studentDao.save(obj);
        return true;
    }

    private void generateNumberOfRecordBook(Student obj) {
        Long lastNumber = studentDao.getLastNumber();
        if (lastNumber != null){
            obj.setNumberOfRecordBook(lastNumber+1);
        }else {
            obj.setNumberOfRecordBook(10000000L);
        }
    }


    @Transactional
    @Override
    public void studentDeleteById(Long id) {
        studentDao.deleteById(id);
    }

    public Long studentGetLast(){
        return studentDao.getLastNumber();
    }

//    CreditDao

    @Transactional
    @Override
    public List<Credit> creditFindAll() {
        return creditDao.findAll();
    }

    @Transactional
    @Override
    public Credit creditFindById(Long id) {
        return creditDao.findById(id);
    }

    @Transactional
    @Override
    public void creditSave(Credit obj) {
        creditDao.save(obj);
    }

    @Transactional
    @Override
    public void creditDeleteById(Long id) {
        creditDao.deleteById(id);
    }

//    ExamDao

    @Transactional
    @Override
    public List<Exam> examFindAll() {
        return examDao.findAll();
    }

    @Transactional
    @Override
    public Exam examFindById(Long id) {
        return examDao.findById(id);
    }

    @Transactional
    @Override
    public void examSave(Exam obj) {
        examDao.save(obj);
    }

    @Transactional
    @Override
    public void examDeleteById(Long id) {
        examDao.deleteById(id);
    }

//    SubjectDao

    @Transactional
    @Override
    public List<Subject> subjectFindAll() {
        return subjectDao.findAll();
    }

    @Transactional
    @Override
    public Subject subjectFindById(Long id) {
        return subjectDao.findById(id);
    }

    @Transactional
    @Override
    public void subjectSave(Subject obj) {
        subjectDao.save(obj);
    }

    @Transactional
    @Override
    public void subjectDeleteById(Long id) {
        subjectDao.deleteById(id);
    }
}
