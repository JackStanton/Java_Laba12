package ru.dstu.lab12.entities;

import javax.persistence.*;

@Entity
@Table(name = "credit")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "mark")
    private String mark;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @Transient
    private String subject_tmp;

    @Transient
    private String student_tmp;

    public Credit(long id, Subject subject, String mark, Student student, String subject_tmp, String student_tmp) {
        this.id = id;
        this.subject = subject;
        this.mark = mark;
        this.student = student;
        this.subject_tmp = subject_tmp;
        this.student_tmp = student_tmp;
    }

    public Credit() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject_id) {
        this.subject = subject_id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSubject_tmp() {
        return subject_tmp;
    }

    public void setSubject_tmp(String subject_tmp) {
        this.subject_tmp = subject_tmp;
    }

    public String getStudent_tmp() {
        return student_tmp;
    }

    public void setStudent_tmp(String student_tmp) {
        this.student_tmp = student_tmp;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id=" + id +
                ", subject=" + subject +
                ", mark='" + mark + '\'' +
                ", student=" + student +
                ", subject_tmp='" + subject_tmp + '\'' +
                ", student_tmp='" + student_tmp + '\'' +
                '}';
    }
}
