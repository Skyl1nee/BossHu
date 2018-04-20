package com.Hu.TBLBasedLearing.web.holder;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.Hu.TBLBasedLearing.entity.User;
import com.Hu.TBLBasedLearing.utils.WebKeys;

/**
 * 用户会话持有器<br>
 * 主要用作用户信息存储和获取
 * 
 * @author Administrator
 *
 */
public abstract class SessionHolder {

	/** 登录用户集合. */
	private static Map<Integer, User> loginUsers = new HashMap<Integer, User>();

	/** 登录用户的会话. */
	private static Map<Integer, HttpSession> sessions = new HashMap<Integer, HttpSession>();

	/**
	 * 持有用户会话,将用户和session绑定。
	 * 
	 * @param user
	 * @param session
	 * @return
	 */
	public static boolean holder(User user, HttpSession session) {
		session.setAttribute(WebKeys.USER_SESSION_KEY, user);
		loginUsers.put(user.getUserID(), user);
		sessions.put(user.getUserID(), session);
		return true;
	}

	/**
	 * 移除用户和会话的绑定信息
	 * 
	 * @param userId
	 * @return
	 */
	public static boolean remove(Long userId) {
		HttpSession session = getByUserId(userId);
		if (session != null) {
			session.removeAttribute(WebKeys.USER_SESSION_KEY);
			sessions.remove(userId);
			loginUsers.remove(userId);
		}
		return true;
	}

	/**
	 * 从会话中获取用户信息
	 * 
	 * @param session
	 * @return
	 */
	public static User getUser(HttpSession session) {
		Object obj = session.getAttribute(WebKeys.USER_SESSION_KEY);
		if (null != obj) {
			// User.class.cast(obj);
			return (User) obj;
		}
		return null;
	}

	/**
	 * 通过用户ID获取session
	 * 
	 * @param userId
	 * @return
	 */
	public static HttpSession getByUserId(Long userId) {
		return sessions.get(userId);
	}

}
