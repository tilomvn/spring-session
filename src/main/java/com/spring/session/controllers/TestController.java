package com.spring.session.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.session.services.TestService;

@RestController
@RequestMapping("/api")
public class TestController {

	@Autowired
	TestService service;
	
	@GetMapping("/test")
    ResponseEntity<?> test(HttpSession session) {
        return ResponseEntity.ok().body(service.get(session.getId()));
    }
}