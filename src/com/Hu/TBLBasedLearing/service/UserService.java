package com.Hu.TBLBasedLearing.service;

import java.util.List;

import com.Hu.TBLBasedLearing.entity.User;
import com.Hu.TBLBasedLearing.model.Result;

public interface UserService {

	public Result findByName(String UserName, String Password);

	public Result FindUser(String UserName, String Password);
	
	public Result Register(User user);
	
	public Result Updatepwd(User user);
	
	public Result UpdateInfo(User user);
	
	public Result getStuByUserId(int userId,int groupId);
	
	public Result adminUpdateInfo(User user);
	
	public Result delluser(User user);
	
	public List<User> findUsers();
}
