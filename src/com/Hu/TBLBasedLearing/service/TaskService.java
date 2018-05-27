package com.Hu.TBLBasedLearing.service;

import java.util.List;

import com.Hu.TBLBasedLearing.entity.Task;
import com.Hu.TBLBasedLearing.entity.TaskUser;
import com.Hu.TBLBasedLearing.model.Result;

public interface TaskService {
	
	public List<Task> getTaskListByStuID(int userId);
	
	public Task findTaskByID(int taskID);
	
	public Result uptask(Task task,TaskUser taskuser); 
	
	public TaskUser findTaskuser(int TaskID,int UserID);
	
	public Result score(TaskUser taskuser);
	
	public List<TaskUser> findall();
}
