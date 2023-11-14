package com.GypseePvtLtd.GypseeDemo.Controllers;

import java.net.URI;
import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.GypseePvtLtd.GypseeDemo.Service.UserService.UserServiceImpl;
import com.GypseePvtLtd.GypseeDemo.Entity.User;
import com.GypseePvtLtd.GypseeDemo.Exception.User.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserController {
	 @Autowired
	 UserServiceImpl service;
	

	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable String userId) {
		User savedUser=service.getUser(userId);
		if(savedUser==null)throw new UserNotFoundException("UserId: ".concat(userId).concat(" is not Found"));
		return savedUser;
	}
	
	@PostMapping("/users")
	public  ResponseEntity<User> createUser(@Valid @RequestBody User user) throws Exception {
	    if(LocalDate.now().getYear()-user.getDateOfBirth().getYear()<18)throw new Exception("Age should be atleast 18");    
		User savedUser=service.createUser(user);
	        
	        URI location=ServletUriComponentsBuilder.fromCurrentRequest()
	        		.path("/{userId}")
	        		.buildAndExpand(savedUser.getUserId())
	        		.toUri();
			return ResponseEntity.created(location).build();
	}
	
	
	@DeleteMapping("/users/{userId}")
	public void deleteUser(@PathVariable String userId) {
		service.deleteUser(userId);
	}
	
	
	@PutMapping("/users")
	public ResponseEntity<Object> updateUser(@RequestHeader("userId")String userId,@Valid @RequestBody User user) throws Exception {
		if(LocalDate.now().getYear()-user.getDateOfBirth().getYear()<18)throw new Exception("Age should be atleast 18");    
		User savedUser=service.updateUser(user,userId);
		if(savedUser==null)throw new UserNotFoundException("UserId: "+userId+" is not present");
		String location=ServletUriComponentsBuilder.fromCurrentRequest()
        		.path("/{userId}")
        		.buildAndExpand(savedUser.getUserId())
        		.toUriString();
		return  ResponseEntity.status(HttpStatus.OK).header(HttpHeaders.LOCATION, location).build();
		
	}
}
