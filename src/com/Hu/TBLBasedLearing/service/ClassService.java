package com.Hu.TBLBasedLearing.service;

import java.util.List;

import com.Hu.TBLBasedLearing.entity.ClassInfo;
import com.Hu.TBLBasedLearing.model.Result;

public interface ClassService {	
	public List<ClassInfo> findall();
	public Result addClass(ClassInfo ci);
	public Result dellClass(int ClassID);
	public Result upodateClass(ClassInfo ci);
}
