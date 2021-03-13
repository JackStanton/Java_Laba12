package ru.dstu.lab12.services;

import ru.dstu.lab12.entities.*;

import java.util.List;

public interface ApplicationService {

    //    Student
    public List<Student> studentFindAll();
    public Student studentFindById(Long id);
    public boolean studentSave(Student obj);
    public void studentDeleteById(Long id);

    //    Credit
    public List<Credit> creditFindAll();
    public Credit creditFindById(Long id);
    public void creditSave(Credit obj);
    public void creditDeleteById(Long id);

    //    Exam
    public List<Exam> examFindAll();
    public Exam examFindById(Long id);
    public void examSave(Exam obj);
    public void examDeleteById(Long id);

    //    Subject
    public List<Subject> subjectFindAll();
    public Subject subjectFindById(Long id);
    public void subjectSave(Subject obj);
    public void subjectDeleteById(Long id);
}
