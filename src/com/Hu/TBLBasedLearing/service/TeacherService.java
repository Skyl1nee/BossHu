package com.Hu.TBLBasedLearing.service;

import java.util.List;

import com.Hu.TBLBasedLearing.entity.Group;
import com.Hu.TBLBasedLearing.model.Result;

public interface TeacherService {

	public Result getGroupList(int userId);
	
	public List<Group> getGroupListByStuID(int userId);
}
