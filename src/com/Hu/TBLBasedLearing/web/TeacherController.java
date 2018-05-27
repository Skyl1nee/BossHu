package com.Hu.TBLBasedLearing.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Hu.TBLBasedLearing.entity.Group;
import com.Hu.TBLBasedLearing.entity.Task;
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
	

	@RequestMapping("createtask.htm")
	@ResponseBody
	public Result newtask(HttpServletRequest request,@RequestParam("taskName") String taskName,@RequestParam("taskDetails") String taskDetails,@DateTimeFormat(pattern = "yyyy-MM-dd")Date enddate
			,String taskType,String Purpose,String classId){
		User user = SessionHolder.getUser(request.getSession());
		if (!user.getRoleName().equals("教师")) {
			return new Result(500,"您不是教师，不能进行操作");	
		}
		if (Integer.parseInt(classId)  == 0) 
		{
			return new Result(404,"参数错误");
		}
		return teacherService.addTask(taskName,taskDetails,Integer.parseInt(classId),user.getUserID(),enddate,Purpose,taskType);
	}
	
	@RequestMapping("getgrouplist.htm")
	@ResponseBody
	public Result getgrouplist(HttpServletRequest request){
		User user = SessionHolder.getUser(request.getSession());
		if (!user.getRoleName().equals("教师")) {
			return new Result(500,"您不是教师，不能进行操作");	
		}
		
		return teacherService.getGroupList(user.getUserID());		
	}
	

	@RequestMapping("getgrouplistbytaskid.htm")
	@ResponseBody
	public Result getgrouplistbytaskid(HttpServletRequest request,String taskId){
		User user = SessionHolder.getUser(request.getSession());
		if (!user.getRoleName().equals("教师")) {
			return new Result(500,"您不是教师，不能进行操作");	
		}
		
		return teacherService.getGroupList(user.getUserID(),Integer.parseInt(taskId));		
	}
	@RequestMapping("savetasktogroup.htm")
	@ResponseBody
	public Result savetasktogroup(HttpServletRequest request,String ids,String taskId){
		User user = SessionHolder.getUser(request.getSession());
		if (!user.getRoleName().equals("教师")) {
			return new Result(500,"您不是教师，不能进行操作");	
		}
		if (Integer.parseInt(taskId)  == 0) 
		{
			return new Result(404,"参数错误");
		}
		
		if (ids == "") {
			return teacherService.clearTask(Integer.parseInt(taskId));
		}
		List<Integer> groups =  new ArrayList<Integer>() ; 
		for (String id : ids.split(",")) {
			groups.add(Integer.parseInt(id));
		}
		
		
		return teacherService.changeTaskToGroup(groups, Integer.parseInt(taskId));		
	}
	
	@RequestMapping("savegroup.htm")
	@ResponseBody
	public Result savegroup(HttpServletRequest request,String ids,String groupId){
		User user = SessionHolder.getUser(request.getSession());
		if (!user.getRoleName().equals("教师")) {
			return new Result(500,"您不是教师，不能进行操作");	
		}
		if (Integer.parseInt(groupId)  == 0) 
		{
			return new Result(404,"参数错误");
		}
		
		if (ids == "") {
			return teacherService.clearGroup(Integer.parseInt(groupId));
		}
		List<Integer> users =  new ArrayList<Integer>() ; 
		for (String id : ids.split(",")) {
			users.add(Integer.parseInt(id));
		}
		
		
		return teacherService.changeGroup(users, Integer.parseInt(groupId));		
	}
	
	@RequestMapping("delgroup.htm")
	@ResponseBody
	public Result delGroup(HttpServletRequest request,String groupId,String forceDelete){
		User user = SessionHolder.getUser(request.getSession());
		if (!user.getRoleName().equals("教师")) {
			return new Result(500,"您不是教师，不能进行操作");	
		}
		if (Integer.parseInt(groupId)  == 0) 
		{
			return new Result(404,"参数错误");
		}
		
		teacherService.clearGroup(Integer.parseInt(groupId));
		return teacherService.tryDeleteGroup(Integer.parseInt(groupId));
	}
	
	@RequestMapping("deltask.htm")
	@ResponseBody
	public Result delTask(HttpServletRequest request,String taskId){
		User user = SessionHolder.getUser(request.getSession());
		if (!user.getRoleName().equals("教师")) {
			return new Result(500,"您不是教师，不能进行操作");	
		}
		if (Integer.parseInt(taskId)  == 0) 
		{
			return new Result(404,"参数错误");
		}
		
		return teacherService.DeleteTask(Integer.parseInt(taskId));
	}
	
	@RequestMapping("newgroup.htm")
	@ResponseBody
	public Result newgroup(HttpServletRequest request,String classId,String groupName){
		User user = SessionHolder.getUser(request.getSession());
		if (!user.getRoleName().equals("教师")) {
			return new Result(500,"您不是教师，不能进行操作");	
		}
		if (Integer.parseInt(classId)  == 0) 
		{
			return new Result(404,"参数错误");
		}
		return teacherService.addGroup(Integer.parseInt(classId),groupName,user.getUserID());
	}
	

	
	@RequestMapping("getStugrouplist.htm")
	@ResponseBody
	public List<Group> getStuGroupList(HttpServletRequest request){
		User user = SessionHolder.getUser(request.getSession());
		List<Group> groups = this.teacherService.getGroupListByStuID(user.getUserID());
		return groups;		
	}
	@RequestMapping("gettasklist.htm")
	@ResponseBody
	public List<Task> getTaskList(HttpServletRequest request){
		User user = SessionHolder.getUser(request.getSession());
		List<Task> task = this.teacherService.getTaskList(user.getUserID());
		return task;		
	}
}
