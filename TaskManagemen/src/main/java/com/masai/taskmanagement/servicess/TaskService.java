package com.masai.taskmanagement.servicess;

import java.util.ArrayList;

import com.masai.taskmanagement.Exception.EmailExitException;
import com.masai.taskmanagement.Exception.SubTaskNotCompleatedException;
import com.masai.taskmanagement.Exception.TaskException;
import com.masai.taskmanagement.Exception.taskIsNotPresentException;
import com.masai.taskmanagement.entity.Task;

public interface TaskService {
	
	Task crateTask(Task task , Integer userId) throws TaskException, EmailExitException;
	Task updateTask(Long task_id , Task task) throws taskIsNotPresentException;
	Task deleteTask(Long task_id) throws taskIsNotPresentException;
	
	
	ArrayList<Task> showAllTask();
	
	Task getTaskById(Long taskId) throws taskIsNotPresentException;
	
	Task compleateTask(Long task_id) throws taskIsNotPresentException, SubTaskNotCompleatedException;

}
