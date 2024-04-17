package com.masai.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.taskmanagement.entity.SubTask;

@Repository
public interface SubTaskRepository extends JpaRepository<SubTask, Long> {

}
