package com.Hu.TBLBasedLearing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hu.TBLBasedLearing.dao.ClassMapper;
import com.Hu.TBLBasedLearing.entity.ClassInfo;
import com.Hu.TBLBasedLearing.service.ClassService;
@Service
public class ClassServiceImpl implements ClassService {

	// 自动注入用户数据操作接口
	@Autowired
	private ClassMapper classMapper;
	@Override
	public List<ClassInfo> findall() {
		// TODO Auto-generated method stub
		return this.classMapper.findall();
	}

}
