package com.example.demo.controller;

import com.example.demo.dto.reponse.StudentDto;
import com.example.demo.enity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/get-all-students")
    public List<StudentDto> getAllStudents() {
        List<StudentEntity> studentEntityList = studentService.listStudents();
        List<StudentDto> studentDtoList = studentEntityList.stream().map(s -> StudentDto.fromEntity(s)).toList();
        return studentDtoList;
    }

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/add-student")
    public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity student) {
        // studentRepository sẽ tự động ánh xạ các trường vào bảng students trong Supabase
        StudentEntity savedStudent = studentRepository.save(student);
        return ResponseEntity.ok(savedStudent);
    }

    // 2. API PUT: Cập nhật thông tin sinh viên
    @PutMapping("/update-student/{id}")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable Long id, @RequestBody StudentEntity studentDetails) {
        // Tìm sinh viên cũ trong Database qua ID
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sinh viên với ID: " + id));

        // Cập nhật các trường thông tin
        student.setName(studentDetails.getName());
        student.setStudentCode(studentDetails.getStudentCode());
        student.setStudentClass(studentDetails.getStudentClass());
        student.setFaculty(studentDetails.getFaculty());
        student.setStatus(studentDetails.getStatus());
        // update_at thường được xử lý tự động bởi JPA hoặc Database

        StudentEntity updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }


    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sinh viên với ID: " + id));

        studentRepository.delete(student);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);


    }
}
