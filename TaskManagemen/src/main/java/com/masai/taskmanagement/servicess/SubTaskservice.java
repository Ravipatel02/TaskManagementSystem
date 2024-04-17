package com.masai.taskmanagement.servicess;

import com.masai.taskmanagement.Exception.taskIsNotPresentException;
import com.masai.taskmanagement.entity.SubTask;

public interface SubTaskservice {
	SubTask crateTask(SubTask s_task ,Long task_id) throws taskIsNotPresentException;
	SubTask updateTask(Long s_task_id , SubTask subTask , Long task_id) throws taskIsNotPresentException;
	SubTask deleteTask(Long s_task_id) throws taskIsNotPresentException;
	SubTask complateTask(Long subTaskId) throws taskIsNotPresentException;

}
