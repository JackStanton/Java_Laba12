package ru.dstu.lab12.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_surname")
    private String studentSurname;

    @Column(name = "number_of_record_book")
    private Long numberOfRecordBook;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student",cascade = CascadeType.ALL)
    private List<Credit> credit;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student",cascade = CascadeType.ALL)
    private List<Exam> exam;


    public Student(String studentName, String studentSurname, Long numberOfRecordBook) {
//        this.id = id;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.numberOfRecordBook = numberOfRecordBook;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public Long getNumberOfRecordBook() {
        return numberOfRecordBook;
    }

    public void setNumberOfRecordBook(Long numberOfRecordBook) {
        this.numberOfRecordBook = numberOfRecordBook;
    }


    public String toView() {
        return studentSurname + " " + studentName +" ("+ numberOfRecordBook+")";
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentSurname='" + studentSurname + '\'' +
                ", numberOfRecordBook='" + numberOfRecordBook + '\'' +
                '}';
    }
}
