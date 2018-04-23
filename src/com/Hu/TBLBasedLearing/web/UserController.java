package com.Hu.TBLBasedLearing.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
}
