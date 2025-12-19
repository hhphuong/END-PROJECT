package com.example.demo.controller;

import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/product")
public class UserProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> products() {
        return productService.getAllProducts();
    }
}
