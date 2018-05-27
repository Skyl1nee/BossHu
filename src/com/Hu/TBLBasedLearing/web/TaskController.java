package com.Hu.TBLBasedLearing.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.Hu.TBLBasedLearing.entity.Task;
import com.Hu.TBLBasedLearing.entity.TaskUser;
import com.Hu.TBLBasedLearing.entity.User;
import com.Hu.TBLBasedLearing.model.Result;
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
	@RequestMapping("upload.htm")
	public Result upload(@RequestParam("uploadFile") CommonsMultipartFile uploadFile,String taskID,HttpServletRequest request, HttpServletResponse response) {
		User user = SessionHolder.getUser(request.getSession());
		Task task = new Task();
		TaskUser taskuser= new TaskUser(); 
		task = this.taskService.findTaskByID((Integer.parseInt(taskID)));
		// 设置保存路径
		String savePath = "upload//" +task.getTaskName();
		// 获取文件名称
		String fileName = uploadFile.getOriginalFilename();

		// 创建本地文件
		File targetFile = new File(savePath, fileName);
		// 判断文件及目录是否存在
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}		
		try {
			uploadFile.transferTo(targetFile);
			task.setStatus("已提交");
			taskuser.setUserID(user.getUserID());
			taskuser.setTaskID((Integer.parseInt(taskID)));
			taskuser.setFilePath(savePath + "//" + fileName);
			return this.taskService.uptask(task,taskuser);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return new Result(500,"失败");
		}		
		
	}
	@RequestMapping("score.htm")
	@ResponseBody
	public Result Score(String taskID,String userID,int score,HttpServletResponse response){				
		TaskUser taskuer = taskService.findTaskuser(Integer.parseInt(taskID), Integer.parseInt(userID));
		taskuer.setScore(score);
		return taskService.score(taskuer);			
	}
	@RequestMapping("findallTaskuser.htm")
	@ResponseBody
	public List<TaskUser> findall(HttpServletResponse response){
		List<TaskUser> lists = taskService.findall();
		return lists;
	}
}
