package com.Hu.TBLBasedLearing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hu.TBLBasedLearing.dao.UserMapper;
import com.Hu.TBLBasedLearing.entity.User;
import com.Hu.TBLBasedLearing.model.Result;
import com.Hu.TBLBasedLearing.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	// 自动注入用户数据操作接口
	@Autowired
	private UserMapper userMapper;
	@Override
	public Result findByName(String UserName, String Password) {
		User user = this.userMapper.FindPwdByname(UserName);
		if(Password == null ||!user.getPassword().equals(Password)){
			return new Result(400,"密码或者用户名错误");
		}
		return new Result(200,user);
	}

}
