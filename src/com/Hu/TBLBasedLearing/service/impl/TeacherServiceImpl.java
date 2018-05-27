package com.Hu.TBLBasedLearing.service.impl;

import java.util.Date;
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
	@Override
	public Result tryDeleteGroup(int groupId) {
		try {
			teacherMapper.tryDeleteGroup(groupId);
		} catch (Exception e) {
			return new Result(500,"服务器错误");
		}
		return new Result(200);
	}
	@Override
	public Result addGroup(int classId, String groupName,int userId) {
		try {
			teacherMapper.addGroup(classId,groupName,userId);
		} catch (Exception e) {
			return new Result(500,"服务器错误");
		}
		return new Result(200);
	}
	@Override
	public Result addTask(String taskName, String taskDetails, int classId, int userId,Date enddate,String purpose,String taskType) {
		try {
			if (taskType == "班级任务") {
				classId = (Integer) null;
			}
			teacherMapper.addTask(taskName,taskDetails,classId,userId,enddate,purpose,taskType);
		} catch (Exception e) {
			return new Result(500,"服务器错误");
		}
		return new Result(200);
	}
	@Override
	public Result DeleteTask(int taskId) {
		try {
			teacherMapper.DeleteTask(taskId);
		} catch (Exception e) {
			return new Result(500,"服务器错误");
		}
		return new Result(200);
	}
	@Override
	public Result getGroupList(int userID, int taskId) {
		List<Group> groupList;
		try {
			groupList = teacherMapper.getgrouplistbytaskid(userID,taskId);
		} catch (Exception e) {
			return null;
		}
		return new Result(200,groupList);
	}
	@Override
	public Result clearTask(int taskId) {
		try {
			teacherMapper.clearTask(taskId);
		} catch (Exception e) {
			return new Result(500,"服务器错误");
		}
		return new Result(200);
	}
	@Override
	public Result changeTaskToGroup(List<Integer> groups, int taskId) {
		try {
			teacherMapper.changeTaskToGroup(groups, taskId);
		} catch (Exception e) {
			return new Result(500,"服务器错误");
		}
		return new Result(200);
	}
}
