package com.masai.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.taskmanagement.Exception.taskIsNotPresentException;
import com.masai.taskmanagement.entity.SubTask;
import com.masai.taskmanagement.servicess.Impl.SubTaskImpl;


@RestController
@RequestMapping("api/")
public class SubTaskController {
	
	@Autowired
	private SubTaskImpl sarvice;
	
	@PostMapping("/subtask")
	public SubTask crateTask(@RequestBody SubTask s_task ,@RequestParam Long task_id) throws taskIsNotPresentException{
		SubTask crateTask = this.sarvice.crateTask(s_task, task_id);
		return crateTask;
	}
	
	@PutMapping("/subtask")
	public SubTask updateTask(@RequestParam Long s_task_id ,@RequestBody SubTask subTask ,@RequestParam Long task_id) throws taskIsNotPresentException{
		SubTask updateTask = this.sarvice.updateTask(s_task_id, subTask, task_id);
		return updateTask;
	}
	@DeleteMapping("/subtask/{task_id}")
	public SubTask deleteTask(@PathVariable Long task_id) throws taskIsNotPresentException{
		SubTask deleteTask = this.sarvice.deleteTask(task_id);
		return deleteTask;
	}
	
	@PutMapping("/complatesubtask/{task_id}")
	public SubTask complateTask(@PathVariable Long task_id) throws taskIsNotPresentException{
		SubTask complateTask = this.sarvice.complateTask(task_id);
		return complateTask;
	}

}