package com.Hu.TBLBasedLearing.entity;

public class User {

	private Integer UserID;
	private String UserName;
	private String Password;
	private String Gender;
	private String RoleID;
	private String GroupID;
	private String ClassID;
	private String RoleName;
	public Integer getUserID() {
		return UserID;
	}
	public void setUserID(Integer userID) {
		UserID = userID;
	}
	public String getUserName() {
		return UserName;
	}
	public String getRoleName() {
		return RoleName;
	}
	public void setRoleName(String roleName) {
		RoleName = roleName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getRoleID() {
		return RoleID;
	}
	public void setRoleID(String roleID) {
		RoleID = roleID;
	}
	public String getGroupID() {
		return GroupID;
	}
	public void setGroupID(String groupID) {
		GroupID = groupID;
	}
	public String getClassID() {
		return ClassID;
	}
	public void setClassID(String classID) {
		ClassID = classID;
	}
	
	
	
}
