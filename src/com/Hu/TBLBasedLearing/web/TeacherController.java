package com.Hu.TBLBasedLearing.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Hu.TBLBasedLearing.entity.Group;
import com.Hu.TBLBasedLearing.entity.User;
import com.Hu.TBLBasedLearing.model.Result;
import com.Hu.TBLBasedLearing.service.TeacherService;
import com.Hu.TBLBasedLearing.service.UserService;
import com.Hu.TBLBasedLearing.web.holder.SessionHolder;

@Controller
@RequestMapping("teacher")
public class TeacherController {
	// 注入service
	@Autowired
	private UserService userService;
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping("getgrouplist.htm")
	@ResponseBody
	public Result getgrouplist(HttpServletRequest request){
		User user = SessionHolder.getUser(request.getSession());
		if (!user.getRoleName().equals("教师")) {
			return new Result(500,"您不是教师，不能进行操作");	
		}
		
		return teacherService.getGroupList(user.getUserID());		
	}
	@RequestMapping("getStugrouplist.htm")
	@ResponseBody
	public List<Group> getStuGroupList(HttpServletRequest request){
		User user = SessionHolder.getUser(request.getSession());
		List<Group> groups = this.teacherService.getGroupListByStuID(user.getUserID());
		return groups;		
	}

}
