package com.example.fotowoltaika.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@PreAuthorize("hasRole('USER')")
public class HelloUserController {
    @GetMapping("/hello_user")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("This endpoint should be available if you are login and has user role", HttpStatus.OK);
    }
}
