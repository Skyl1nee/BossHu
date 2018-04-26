package com.Hu.TBLBasedLearing.service;

import java.util.List;

import com.Hu.TBLBasedLearing.entity.Task;

public interface TaskService {
	
	public List<Task> getTaskListByStuID(int userId);
}
