package com.masai.taskmanagement.servicess.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.taskmanagement.Exception.taskIsNotPresentException;
import com.masai.taskmanagement.entity.SubTask;
import com.masai.taskmanagement.entity.Task;
import com.masai.taskmanagement.repository.SubTaskRepository;
import com.masai.taskmanagement.repository.TaskRepository;
import com.masai.taskmanagement.servicess.SubTaskservice;

@Service
public class SubTaskImpl implements SubTaskservice {
	@Autowired
	private SubTaskRepository repo;
	
	@Autowired
	private TaskRepository taskRepo;

	@Override
	public SubTask crateTask(SubTask task ,Long task_id) throws taskIsNotPresentException {
		Optional<Task> optionlTask = this.taskRepo.findById(task_id);
		if(!optionlTask.isPresent()) {
			throw new taskIsNotPresentException("task is not present with "+task_id);
		}
		Task task2 = optionlTask.get();
		task.setTask(task2);
		SubTask save = this.repo.save(task);
		return save;
	}

	@Override
	public SubTask updateTask(Long s_task_id, SubTask subTask , Long task_id) throws taskIsNotPresentException {
		Optional<SubTask> optinalSubTask = this.repo.findById(s_task_id);
		if(!optinalSubTask.isPresent()) {
			throw new taskIsNotPresentException("task is not present with "+s_task_id);
		}
		SubTask subTask2 = optinalSubTask.get();
		Optional<Task> optinalTask = this.taskRepo.findById(task_id);
		if(!optinalTask.isPresent()) {
			throw new taskIsNotPresentException("task is not present with "+s_task_id);
		}
		Task task = optinalTask.get();
		
		subTask2.setName(task.getName());
		subTask2.setCompleted(task.isCompleted());
		subTask2.setTask(task);
		SubTask save = this.repo.save(subTask2);
		return save;
	}

	@Override
	public SubTask deleteTask(Long task_id) throws taskIsNotPresentException {
		Optional<SubTask> optinalSubTask = this.repo.findById(task_id);
		if(!optinalSubTask.isPresent()) {
			throw new taskIsNotPresentException("taks is not present with "+task_id);
		}
		SubTask subTask = optinalSubTask.get();
		this.repo.deleteById(task_id);
		return subTask;
	}

	@Override
	public SubTask complateTask(Long id) throws taskIsNotPresentException {
		Optional<SubTask> present = this.repo.findById(id);
		if(!present.isPresent()) {
			throw new taskIsNotPresentException("task is not present with "+id);
		}
	    SubTask subTask = present.get();
	    subTask.setCompleted(true);
	    SubTask save = this.repo.save(subTask);
	    return save;
	}

}