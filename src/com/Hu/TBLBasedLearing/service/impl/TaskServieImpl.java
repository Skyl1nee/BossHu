package com.Hu.TBLBasedLearing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hu.TBLBasedLearing.dao.TaskMapper;
import com.Hu.TBLBasedLearing.entity.Task;
import com.Hu.TBLBasedLearing.model.Result;
import com.Hu.TBLBasedLearing.service.TaskService;
@Service
public class TaskServieImpl implements TaskService {


	// 自动注入用户数据操作接口
	@Autowired
	public TaskMapper taskMapper;
	@Override
	public List<Task> getTaskListByStuID(int userId) {
		List<Task> tasklists = this.taskMapper.findMyTask(userId);
		return tasklists;
	}
	@Override
	public Task findTaskByID(int taskID) {
		Task task = this.taskMapper.findTaskByID(taskID);
		return task;
	}
	@Override
	public Result setStatus(Task task) {
		try{
			this.taskMapper.changeStatus(task);
			return new Result(200,"修改成功");
		}
		catch(Exception e){
			return new Result(500,"修改失败");
		}
	}

}
