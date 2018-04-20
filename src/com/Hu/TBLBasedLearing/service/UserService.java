package com.Hu.TBLBasedLearing.service;

import com.Hu.TBLBasedLearing.model.Result;

public interface UserService {

	public Result findByName(String UserName, String Password);
}
