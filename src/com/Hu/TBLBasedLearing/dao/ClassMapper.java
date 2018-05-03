package com.Hu.TBLBasedLearing.dao;

import java.util.List;

import com.Hu.TBLBasedLearing.entity.ClassInfo;

public interface ClassMapper {

	public List<ClassInfo> findall();
	
	public void addclass(ClassInfo ci);
	
	public void dellclass(int ClassID);
	
	public void updateclass(ClassInfo ci);
}
