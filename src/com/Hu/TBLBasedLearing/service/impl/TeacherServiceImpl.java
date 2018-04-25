package com.Hu.TBLBasedLearing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hu.TBLBasedLearing.dao.TeacherMapper;
import com.Hu.TBLBasedLearing.entity.Group;
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

}