package com.Hu.TBLBasedLearing.dao;

import java.util.List;

import com.Hu.TBLBasedLearing.entity.Task;

public interface TaskMapper {
	public List<Task> findMyTask();
}
