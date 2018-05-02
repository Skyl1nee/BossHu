package com.Hu.TBLBasedLearing.service.impl;

import java.util.List;

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
	
	
	@Override
	public Result FindUser(String UserName, String Password) {
		User user = this.userMapper.FindUser(UserName,Password);
		if(user == null){
			return new Result(400,"密码或者用户名错误");
		}
		return new Result(200,user);
	}


	@Override
	public Result Register(User user) {
		if(user != null){
			try{
				this.userMapper.Register(user);
			}catch(Exception e) {
				return new Result(500,"新增失败"); 
			}
		}
		return new Result(200,"新增成功");
	}


	@Override
	public Result Updatepwd(User user) {
		if(user != null){
			try{
				this.userMapper.updatepwd(user);
			}catch(Exception e) {
				return new Result(500,"修改失败"); 
			}
		}
		return new Result(200,"修改成功");
	}


	@Override
	public Result UpdateInfo(User user) {
		if(user != null){
			try{
				this.userMapper.updateInfo(user);
			}catch(Exception e) {
				return new Result(500,"修改失败"); 
			}
		}
		return new Result(200,"修改成功");
	}


	@Override
	public Result getStuByUserId(int userId,int groupId) {
		
		List<User> list;
		try {
			list = userMapper.getStuByUserId(userId,groupId);
		} catch (Exception e) {
			return new Result(500,"服务器错误");
		}
		
		return new Result(200,list);
	}


	@Override
	public Result adminUpdateInfo(User user) {
		if(user != null){
			try{
				this.userMapper.adminUpdateInfo(user);;
			}catch(Exception e) {
				return new Result(500,"修改失败"); 
			}
		}
		return new Result(200,"修改成功");
	}


	@Override
	public Result delluser(User user) {
		if(user != null){
			try{
				this.userMapper.delluser(user);
			}catch(Exception e) {
				return new Result(500,"删除失败"); 
			}
		}
		return new Result(200,"删除成功");
	}


	@Override
	public List<User> findUsers() {
		List<User> users;
		users = this.userMapper.findUsers();		
		return users;
	}

}
