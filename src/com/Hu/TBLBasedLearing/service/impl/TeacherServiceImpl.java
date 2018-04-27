package com.Hu.TBLBasedLearing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hu.TBLBasedLearing.dao.TeacherMapper;
import com.Hu.TBLBasedLearing.entity.Group;
import com.Hu.TBLBasedLearing.entity.Task;
import com.Hu.TBLBasedLearing.model.Result;
import com.Hu.TBLBasedLearing.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	// 自动注入用户数据操作接口
	@Autowired
	TeacherMapper teacherMapper;
	
	@Override
	public Result getGroupList(int userId) {
		List<Group> groups = teacherMapper.getGroupByUserId(userId);
		return new Result(200,groups);
	}
	@Override
	public List<Group> getGroupListByStuID(int userId) {
		List<Group> groups = teacherMapper.getGroupByStuUserId(userId);
		return groups;
	}
	@Override
	public Result changeGroup(List<Integer> users, int groupId) {
		try {
			teacherMapper.changeGroup(users, groupId);
		} catch (Exception e) {
			return new Result(500,"服务器错误");
		}
		return new Result(200);
	}
	@Override
	public Result clearGroup(int groupId) {
		try {
			teacherMapper.clearGroup(groupId);
		} catch (Exception e) {
			return new Result(500,"服务器错误");
		}
		return new Result(200);
	}
	@Override
	public List<Task> getTaskList(int userId) {
		List<Task> taskList;
		try {
			taskList = teacherMapper.getTaskList(userId);
		} catch (Exception e) {
			return null;
		}
		return taskList;
	}
}
