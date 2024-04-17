package com.masai.taskmanagement.servicess.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.taskmanagement.Exception.EmailExitException;
import com.masai.taskmanagement.Exception.SubTaskNotCompleatedException;
import com.masai.taskmanagement.Exception.TaskException;
import com.masai.taskmanagement.Exception.taskIsNotPresentException;
import com.masai.taskmanagement.entity.SubTask;
import com.masai.taskmanagement.entity.Task;
import com.masai.taskmanagement.entity.User;
import com.masai.taskmanagement.repository.SubTaskRepository;
import com.masai.taskmanagement.repository.TaskRepository;
import com.masai.taskmanagement.repository.UserRepo;
import com.masai.taskmanagement.servicess.TaskService;

@Service
public class TaskImpl implements TaskService{
	
	@Autowired
	private TaskRepository repo;
	
	@Autowired
	private SubTaskRepository subTaskRepo;
	
	@Autowired
	private UserRepo userRep;

	@Override
	public Task crateTask(Task task , Integer userId) throws TaskException, EmailExitException {
		Optional<User> byId = userRep.findById(userId);
		if(!byId.isPresent()) {
			throw new EmailExitException("User not exit with id "+userId);
		}
		User user = byId.get();
		if(task == null) {
			throw new TaskException("Task Data is Null ! ");
		}
		task.setUser(user);
		Task save = this.repo.save(task);
		return save;
	}

	@Override
	public Task updateTask(Long task_id, Task task) throws taskIsNotPresentException {
		Optional<Task> optionalTask = this.repo.findById(task_id);
		if(!optionalTask.isPresent()) {
			throw new taskIsNotPresentException("task is not present with "+task_id);
		}
		Task task2 = optionalTask.get();
		task2.setCompleted(task.isCompleted());
		task2.setDescription(task.getDescription());
		task2.setDueDate(task.getDueDate());
		task2.setName(task.getName());
		task2.setPriority(task.getPriority());
		task2.setSubTasks(task.getSubTasks());
		Task save = this.repo.save(task2);
		return save;
	}

	@Override
	public Task deleteTask(Long task_id) throws taskIsNotPresentException {
		Optional<Task> optionalTask = this.repo.findById(task_id);
		if(!optionalTask.isPresent()) {
			throw new taskIsNotPresentException("task is not present with "+task_id);
		}
		Task task2 = optionalTask.get();
		this.repo.deleteById(task_id);
		return task2;
	}

	

	@Override
	public ArrayList<Task> showAllTask() {
		List<Task> all = this.repo.findAll();
		return (ArrayList)all;
	}

	@Override
	public Task getTaskById(Long taskId) throws taskIsNotPresentException {
		Optional<Task> optionalTask = this.repo.findById(taskId);
		if(!optionalTask.isPresent()) {
			throw new taskIsNotPresentException("task is not present with "+taskId);
		}
		Task task2 = optionalTask.get();
		return task2;
	}

	@Override
	public Task compleateTask(Long task_id) throws taskIsNotPresentException, SubTaskNotCompleatedException {
		Optional<Task> optionalTask = this.repo.findById(task_id);
		if(!optionalTask.isPresent()) {
			throw new taskIsNotPresentException("task is not present with "+task_id);
		}
		Task task = optionalTask.get();
		List<SubTask> subTasks = task.getSubTasks();
		for(SubTask subTask : subTasks) {
			if(!subTask.isCompleted()) {
				throw new SubTaskNotCompleatedException("Sub Task not compleated first complete sub Task affter cloase this task"+subTask.getId());
			}
		}
		
		task.setCompleted(true);
		Task save = this.repo.save(task);
		return save;
	}
	

}
