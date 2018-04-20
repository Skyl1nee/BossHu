package com.Hu.TBLBasedLearing.dao;

import com.Hu.TBLBasedLearing.entity.User;

public interface UserMapper {
	
	public User FindPwdByname(String UserName);

}
