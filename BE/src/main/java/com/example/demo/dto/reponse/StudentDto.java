package com.example.demo.dto.reponse;

import com.example.demo.enity.StudentEntity;

public class StudentDto {
    private Long id;
    private String studentCode;
    private String name;
    private String studentClass;
    private String faculty;
    private String status;

    public Long getId() {
        return id;
    }

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

    public StudentDto(Long id, String studentCode, String name, String studentClass, String faculty, String status) {
        this.id = id;
        this.studentCode = studentCode;
        this.name = name;
        this.studentClass = studentClass;
        this.faculty = faculty;
        this.status = status;
    }

    public StudentDto() {
    }

    public static StudentDto fromEntity(StudentEntity studentEntity){
        StudentDto studentDto = new StudentDto(
                studentEntity.getId(),
                studentEntity.getStudentCode(),
                studentEntity.getName(),
                studentEntity.getStudentClass(),
                studentEntity.getFaculty(),
                studentEntity.getStatus()
        );
        return studentDto ;
    }
}
