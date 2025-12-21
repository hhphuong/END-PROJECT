package com.example.demo.enity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class StudentEntity extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(nullable = false)
    private String studentCode;

    @Column(nullable = false)
    private String name;

    private String studentClass;
    private String faculty;

    private String status;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StudentEntity(Long id, String studentCode, String name, String studentClass, String faculty, String status) {
        this.id = id;
        this.studentCode = studentCode;
        this.name = name;
        this.studentClass = studentClass;
        this.faculty = faculty;
        this.status = status;
    }

    public StudentEntity() {
    }
}
