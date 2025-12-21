package com.example.demo.repository;

import com.example.demo.enity.User;
import com.example.demo.enity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // Tìm giảng viên theo username để phục vụ login hoặc kiểm tra tồn tại
    Optional<UserEntity> findByUsername(String username);

    User findByEmail(String email);
}