package com.Hu.TBLBasedLearing.service;

import java.util.Date;
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

	public Result tryDeleteGroup(int groupId);

	public Result addGroup(int parseInt, String groupName,int userId);


	public Result DeleteTask(int taskId);

	public Result addTask(String taskName, String taskDetails, int classId, int userID, Date enddate, String purpose, String taskType);

	public Result getGroupList(int userID, int taskId);

	public Result clearTask(int taskId);

	public Result changeTaskToGroup(List<Integer> groups, int taskId);

	
}
