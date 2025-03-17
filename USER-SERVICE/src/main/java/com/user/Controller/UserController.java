package com.user.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.DTO.UserResponse;
import com.user.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user/auth")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	@PostMapping("/saved")
	public ResponseEntity<UserResponse>AddProduct(@Valid  @RequestBody UserResponse response ){
	       
		   UserResponse userR= this.userService.CreateUser(response);
		
		return new ResponseEntity<>(userR,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/list")
	public ResponseEntity<List<UserResponse>>ListOfUser(){
		     List<UserResponse>response= userService.list();
		     return new ResponseEntity<List<UserResponse>>(response,HttpStatus.OK);
		
	}
	
	@PutMapping("update/{userId}")
	public ResponseEntity<UserResponse> UpdateUser(@PathVariable("userId") Integer userId, @RequestBody UserResponse resp) {
		       UserResponse res= userService.updateUser(userId, resp);
		 
		return new ResponseEntity<UserResponse>(res,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserResponse>SingleUpdate(@PathVariable Integer userid ){
	       
		   UserResponse userR= this.userService.singleUser(userid);
		
		return new ResponseEntity<>(userR,HttpStatus.OK);
		
	}
	
	//Delete
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?>Delete(@PathVariable Integer userid ){
	       
		  this.userService.DeleteUser(userid);
		
		return new ResponseEntity<>("Delete Id Success!",HttpStatus.OK);
		
	}
	

}
