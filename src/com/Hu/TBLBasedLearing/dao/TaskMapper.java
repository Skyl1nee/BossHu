package com.Hu.TBLBasedLearing.dao;

import java.util.List;

import com.Hu.TBLBasedLearing.entity.Task;
import com.Hu.TBLBasedLearing.entity.TaskUser;

public interface TaskMapper {
	public List<Task> findMyTask(int stuID);
	public Task findTaskByID(int taskID);
	public void changeStatus(Task task);
	public void uptask(TaskUser taskuser);
	public TaskUser findTaskUser(TaskUser taskuser);
	public void score(TaskUser taskuser);
	public List<TaskUser> findall();
}
