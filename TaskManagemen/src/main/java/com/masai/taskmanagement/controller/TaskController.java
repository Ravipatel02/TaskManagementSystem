package com.masai.taskmanagement.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.taskmanagement.Exception.EmailExitException;
import com.masai.taskmanagement.Exception.SubTaskNotCompleatedException;
import com.masai.taskmanagement.Exception.TaskException;
import com.masai.taskmanagement.Exception.taskIsNotPresentException;
import com.masai.taskmanagement.entity.Task;
import com.masai.taskmanagement.servicess.Impl.TaskImpl;




@RestController
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	private TaskImpl service;
	
	@PostMapping("/task")
	public Task crateTask(@RequestBody Task task , @RequestParam Integer userId) throws TaskException, EmailExitException{
		Task crateTask = this.service.crateTask(task , userId);
		return crateTask;
	}
	
	@PutMapping("/task/{task_id}")
	public Task updateTask(@PathVariable Long task_id , @RequestBody Task task) throws taskIsNotPresentException{
		Task updateTask = this.service.updateTask(task_id, task);
		return updateTask;
	}
	
	@DeleteMapping("/task/{task_id}")
	public Task deleteTask(@PathVariable Long task_id) throws taskIsNotPresentException{
		Task deleteTask = this.service.deleteTask(task_id);
		return deleteTask;
		
	}
	
	
	@GetMapping("/task")
	public ArrayList<Task> showAllTask(){
		ArrayList<Task> showAllTask = this.service.showAllTask();
		return showAllTask;
	}
	
	@GetMapping("/task/{taskId}")
	public Task getTaskById(@PathVariable Long taskId) throws taskIsNotPresentException{
		Task taskById = this.service.getTaskById(taskId);
		return taskById;
	}
	@PutMapping("/compatetask/{taskId}")
	public Task compleateTask(Long task_id) throws taskIsNotPresentException, SubTaskNotCompleatedException{
		Task compleateTask = this.service.compleateTask(task_id);
		return compleateTask;
		
	}

}