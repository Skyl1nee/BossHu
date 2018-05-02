package com.Hu.TBLBasedLearing.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Hu.TBLBasedLearing.entity.User;
import com.Hu.TBLBasedLearing.model.Result;
import com.Hu.TBLBasedLearing.service.ClassService;
import com.Hu.TBLBasedLearing.service.UserService;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ClassService classService;
	
	@RequestMapping("findusers.htm")
	@ResponseBody	
	public List<User> FindUsers(){
		return this.userService.findUsers();
	}
	
	@RequestMapping("userManager.htm")
	@ResponseBody	
	public Result userManager(String username,String password,int roleID,String gender,int classID,String stuNo,HttpServletRequest request){
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		switch(gender){
		case"2":
			user.setGender("男");break;
		case"1":
			user.setGender("女");break;
		case"3":
			user.setGender("女装大佬");break;
		}		
		user.setRoleID(roleID);		
		user.setClassID(classID);
		user.setStudentNo(stuNo);
		return this.userService.adminUpdateInfo(user);
		
	}
	@RequestMapping("classManager.htm")
	@ResponseBody
	public Result classManager(){
		return null;
		
	}
	
	@RequestMapping("userdell.htm")
	@ResponseBody
	public Result dellUser(){
		User user = new User();
		return this.userService.delluser(user);
		
	}
	
	@RequestMapping("classdell.htm")
	@ResponseBody
	public Result classDell(){
		return null;
		
	}
	@RequestMapping("classadd.htm")
	@ResponseBody
	public Result classaddz(){
		return null;
		
	}
}
