package com.Hu.TBLBasedLearing.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Hu.TBLBasedLearing.entity.ClassInfo;
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
	public Result userManager(int userID,String username,String password,int roleID,String gender,int classID,String stuNo,HttpServletRequest request){
		User user = new User();
		user.setUserID(userID);
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
	@RequestMapping("classupdate.htm")
	@ResponseBody
	public Result classManager(int classID,String className,String classLevel,String classRemark,HttpServletRequest request){
		ClassInfo ci = new ClassInfo();
		ci.setClassID(classID);
		ci.setClassName(className);
		ci.setLevel(classLevel);
		ci.setRemark(classRemark);
		return this.classService.upodateClass(ci);
		
	}
	
	@RequestMapping("userdell.htm")
	@ResponseBody
	public Result dellUser(int userID){
		User user = new User();
		user.setUserID(userID);
		return this.userService.delluser(user);
		
	}
	
	@RequestMapping("classdell.htm")
	@ResponseBody
	public Result classDell(int classID){		
		return this.classService.dellClass(classID);
		
	}
	@RequestMapping("classadd.htm")
	@ResponseBody
	public Result classadd(String className,String classLevel,String classRemark,HttpServletRequest request){
		ClassInfo ci = new ClassInfo();
		ci.setClassName(className);
		ci.setLevel(classLevel);
		ci.setRemark(classRemark);
		return this.classService.addClass(ci);		
	}
}
