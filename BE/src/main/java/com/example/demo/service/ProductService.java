package com.example.demo.service;

import com.example.demo.dto.request.CreateProductRequest;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    public ResponseEntity<?> getAllProducts();

    ResponseEntity<?> createProduct(CreateProductRequest request);
}
