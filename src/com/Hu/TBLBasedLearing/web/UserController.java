package com.Hu.TBLBasedLearing.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.Hu.TBLBasedLearing.entity.User;
import com.Hu.TBLBasedLearing.model.Result;
import com.Hu.TBLBasedLearing.service.UserService;
import com.Hu.TBLBasedLearing.web.holder.SessionHolder;

@Controller
@RequestMapping("user")
public class UserController {
	// 注入service
	@Autowired
	private UserService userService;
	@RequestMapping("login.htm")
	@ResponseBody
	public Result Login(String username, String password, HttpServletRequest request) throws Exception{
		Result result = this.userService.FindUser(username, password);
		if(result.isSuccess()){
			SessionHolder.holder(result.getData(User.class), request.getSession());           
		}
		return result;
	}
	
	@RequestMapping("index.htm")
	@ResponseBody
	public User index(HttpServletRequest request){
		User user = SessionHolder.getUser(request.getSession());		
		return user;		
	}
	
	
	@RequestMapping("getgrouplist")
	@ResponseBody
	public User getgrouplist(HttpServletRequest request){
		User user = SessionHolder.getUser(request.getSession());		
		return user;		
	}
	
	@RequestMapping("reg.htm")
	@ResponseBody
	public Result test(String username,String password,String roleID,String gender,String classID,HttpServletRequest request){
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		switch(gender){
		case"1":
			user.setGender("男");break;
		case"2":
			user.setGender("女");break;
		case"3":
			user.setGender("女装大佬");break;
		}
		
		user.setRoleID(roleID);
		if(roleID.equals("2")){
			user.setClassID(null);
		}
		else{
			user.setClassID(classID);
		}		
		Result result = this.userService.Register(user);
		if(result.isSuccess()){
			Result loginResult = this.userService.FindUser(user.getUserName(),user.getPassword());
			SessionHolder.holder(loginResult.getData(User.class), request.getSession());
		}				
		return result;		
	}
}
