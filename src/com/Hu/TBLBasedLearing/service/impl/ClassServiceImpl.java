package com.Hu.TBLBasedLearing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hu.TBLBasedLearing.dao.ClassMapper;
import com.Hu.TBLBasedLearing.entity.ClassInfo;
import com.Hu.TBLBasedLearing.model.Result;
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
	@Override
	public Result addClass(ClassInfo ci) {
		try{
			this.classMapper.addclass(ci);
		}
		catch(Exception e){
			return new Result(500,"添加失败");
		}
		return new Result(200,"添加成功");
	}
	@Override
	public Result dellClass(int ClassID) {
		try{
			this.classMapper.dellclass(ClassID);;
		}
		catch(Exception e){
			return new Result(500,"删除失败");
		}
		return new Result(200,"删除成功");
	}
	@Override
	public Result upodateClass(ClassInfo ci) {
		try{
			this.classMapper.updateclass(ci);;
		}
		catch(Exception e){
			return new Result(500,"修改失败");
		}
		return new Result(200,"修改成功");
	}
	

}
