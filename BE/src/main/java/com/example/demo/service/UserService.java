package com.example.demo.service;

import com.example.demo.enity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUsers();
    UserEntity saveUser(UserEntity user);
}
