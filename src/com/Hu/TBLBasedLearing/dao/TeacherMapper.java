package com.Hu.TBLBasedLearing.dao;

import java.util.List;

import com.Hu.TBLBasedLearing.entity.Group;


public interface TeacherMapper {

	public List<Group> getGroupByUserId(int userId);
	
	public List<Group> getGroupByStuUserId(int userId);
	
	public List<Group> changeGroup(List<String> users,int groupId);
	
}
