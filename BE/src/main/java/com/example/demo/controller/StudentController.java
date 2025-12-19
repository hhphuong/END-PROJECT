package com.example.demo.controller;

import com.example.demo.dto.reponse.StudentDto;
import com.example.demo.enity.StudentEntity;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/get-all-students")
    public List<StudentDto> getAllStudents(){
        List<StudentEntity> studentEntityList = studentService.listStudents();
        List<StudentDto> studentDtoList = studentEntityList.stream().map( s -> StudentDto.fromEntity(s)).toList();
        return studentDtoList;
    }
}
