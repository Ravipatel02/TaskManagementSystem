package com.masai.taskmanagement.servicess;

import java.util.List;

import com.masai.taskmanagement.Exception.EmailExitException;
import com.masai.taskmanagement.entity.User;

public interface UserService {
	
	User createUser(User user) throws EmailExitException;
	User deleteUser(Integer userId) throws EmailExitException;
	User updateUser(Integer userId);
	
	List<User> getAllUsers();

}
