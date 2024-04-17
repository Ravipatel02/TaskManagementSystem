package com.masai.taskmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.taskmanagement.Exception.EmailExitException;
import com.masai.taskmanagement.entity.User;
import com.masai.taskmanagement.servicess.Impl.UserImpl;


@RestController
@RequestMapping("api")
public class UserController {
	
	@Autowired
	private UserImpl service;
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user) throws EmailExitException{
	
		User user2 = this.service.createUser(user);
		return user2;
		
	}
	
	@DeleteMapping("/user/{id}")
	public User deleteUser(@PathVariable Integer id) throws EmailExitException {
		User deleteUser = this.service.deleteUser(id);
		return deleteUser;
		
	}
	//User updateUser(Integer userId);
	
	@GetMapping("/user")
	public List<User> getAllUsers(){
		List<User> allUsers = this.service.getAllUsers();
		return allUsers;
		
	}

}
