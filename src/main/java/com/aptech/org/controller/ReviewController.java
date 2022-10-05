package com.aptech.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class ReviewController {
	
	
	@GetMapping
	public String getStudent() {
		return "GET Request was sent";
	}
	

	@PostMapping
	public String addStudent() {
		return "POST Request was sent";
	}
	
	
	@PutMapping("/update")
	public String updateStudent() {
		return "UPDATE Request was sent";
	}
	
	
	@DeleteMapping("/delete")
	public String deleteStudent() {
		return "DELETE Request was sent";
	}

}