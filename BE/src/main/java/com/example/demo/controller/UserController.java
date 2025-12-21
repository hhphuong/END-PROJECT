package com.example.demo.controller;


import com.example.demo.enity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*") // Cho phép Frontend (Live Server 5500) truy cập
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 1. GET: Lấy danh sách tất cả giảng viên
    @GetMapping("/get-all")
    public ResponseEntity<List<UserEntity>> getAllTeachers() {
        List<UserEntity> teachers = userRepository.findAll();
        return ResponseEntity.ok(teachers);
    }

    // 2. POST: Thêm mới giảng viên
    @PostMapping("/add")
    public ResponseEntity<UserEntity> addTeacher(@RequestBody UserEntity user) {
        // Mã hóa mật khẩu trước khi lưu (Mặc định nếu FE không gửi mật khẩu thì đặt là '123')
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode("123"));
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        // Đảm bảo Role mặc định là TEACHER nếu không được chỉ định
        if (user.getRole() == null) {
            user.setRole("ROLE_TEACHER");
        }

        UserEntity savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    // 3. PUT: Cập nhật thông tin giảng viên (Theo ID)
    @PutMapping("/update/{id}")
    public ResponseEntity<UserEntity> updateTeacher(@PathVariable Long id, @RequestBody UserEntity userDetails) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giảng viên ID: " + id));

        // Cập nhật các trường khớp với bảng bạn đã gửi trong ảnh
        user.setTeacherCode(userDetails.getTeacherCode()); // Mã GV
        user.setFullName(userDetails.getFullName());       // Họ Tên
        user.setTitle(userDetails.getTitle());             // Chức danh
        user.setFaculty(userDetails.getFaculty());         // Khoa
        user.setEmail(userDetails.getEmail());             // Email

        // Chỉ cập nhật username/role nếu cần thiết
        user.setUsername(userDetails.getUsername());
        if (userDetails.getRole() != null) {
            user.setRole(userDetails.getRole());
        }

        UserEntity updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    // 4. DELETE: Xóa giảng viên (Xóa cứng)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTeacher(@PathVariable Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giảng viên ID: " + id));

        userRepository.delete(user);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
