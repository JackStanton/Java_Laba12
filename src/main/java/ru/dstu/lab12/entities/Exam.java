package ru.dstu.lab12.entities;

import javax.persistence.*;

@Entity(name = "Exam")
@Table(name = "exam")
public class Exam {

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

    public Exam(Subject subject, String mark, Student student) {
        this.subject = subject;
        this.mark = mark;
        this.student = student;
    }

    public Exam() {
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

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", subject_id=" + subject +
                ", mark='" + mark + '\'' +
                ", student=" + student +
                '}';
    }
}
