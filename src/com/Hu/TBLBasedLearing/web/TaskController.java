package com.Hu.TBLBasedLearing.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Hu.TBLBasedLearing.entity.Task;
import com.Hu.TBLBasedLearing.entity.User;
import com.Hu.TBLBasedLearing.service.TaskService;
import com.Hu.TBLBasedLearing.web.holder.SessionHolder;

@Controller
@RequestMapping("task")
public class TaskController {
	@Autowired
	public TaskService taskService;
	@RequestMapping("gettasklist.htm")
	@ResponseBody
	public List<Task> getTaskListByStuID(HttpServletRequest request){
		User user = SessionHolder.getUser(request.getSession());
		return this.taskService.getTaskListByStuID(user.getUserID());		
	}
}
