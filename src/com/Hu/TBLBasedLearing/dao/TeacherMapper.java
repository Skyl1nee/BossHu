package com.Hu.TBLBasedLearing.dao;

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
	
}
