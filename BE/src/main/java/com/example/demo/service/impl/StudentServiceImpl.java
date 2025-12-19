package com.example.demo.service.impl;

import com.example.demo.enity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentEntity> listStudents() {
        List<StudentEntity> listStudents = studentRepository.findAll();
        return listStudents;
    }
}
