package com.Hu.TBLBasedLearing.dao;

import java.util.List;

import com.Hu.TBLBasedLearing.entity.User;

public interface UserMapper {
	
	public User FindPwdByname(String UserName);
	
	public User FindUser(String UserName,String Password);
	
	public void Register(User user);
	
	public void updatepwd(User user);
	
	public void updateInfo(User user);
	
	public List<User> getStuByUserId(int userId);
	
}
