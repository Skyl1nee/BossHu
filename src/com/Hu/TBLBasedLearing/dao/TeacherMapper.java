package com.Hu.TBLBasedLearing.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.Hu.TBLBasedLearing.entity.Group;
import com.Hu.TBLBasedLearing.entity.Task;


public interface TeacherMapper {

	public List<Group> getGroupByUserId(int userId);
	
	public List<Group> getGroupByStuUserId(int userId);
	
	public List<Group> changeGroup(@Param("users")List<Integer> users,@Param("groupId")int groupId);

	public void clearGroup(int groupId);

	public List<Task> getTaskList(int userId);

	public void tryDeleteGroup(int groupId);

	public void addGroup(@Param("classId")int classId, @Param("groupName")String groupName,@Param("userId")int userId);

	public void addTask(@Param("taskName")String taskName, @Param("taskDetails")String taskDetails,@Param("classId") int classId,@Param("userId")int userId,@Param("enddate")Date enddate, @Param("purpose")String purpose, @Param("taskType")String taskType);

	public void DeleteTask(@Param("taskId")int taskId);

	public List<Group> getgrouplistbytaskid(@Param("userID")int userID, @Param("taskId")int taskId);

	public void clearTask(@Param("taskId")int taskId);

	public void changeTaskToGroup(@Param("groups")List<Integer> groups, @Param("taskId")int taskId);
	
}
