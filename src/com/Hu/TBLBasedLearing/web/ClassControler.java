package com.Hu.TBLBasedLearing.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Hu.TBLBasedLearing.entity.ClassInfo;
import com.Hu.TBLBasedLearing.service.ClassService;

@Controller
@RequestMapping("class")
public class ClassControler {
	// 注入service
	@Autowired
	private ClassService classService;
	@RequestMapping("findall.htm")
	@ResponseBody
	public List<ClassInfo> findall(){
		List<ClassInfo> classes = this.classService.findall();
		return classes;
	}
}
