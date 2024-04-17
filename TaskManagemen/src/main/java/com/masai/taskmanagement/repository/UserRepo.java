package com.masai.taskmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.taskmanagement.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	public Optional<User> findByEmail(String email);


}
