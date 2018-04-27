package com.Hu.TBLBasedLearing.service;

import java.util.List;

import com.Hu.TBLBasedLearing.entity.Group;
import com.Hu.TBLBasedLearing.entity.Task;
import com.Hu.TBLBasedLearing.model.Result;

public interface TeacherService {

	public Result getGroupList(int userId);
	
	public List<Group> getGroupListByStuID(int userId);
	
	public Result changeGroup(List<Integer> users,int groupId) ;

	public Result clearGroup(int groupId);
	
	public List<Task> getTaskList(int userId);
	
}
