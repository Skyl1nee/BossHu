package com.Hu.TBLBasedLearing.entity;

public class TaskUser {

	public int ID;
	public int UserID;
	public int TaskID;
	public int Score;
	public String  FilePath;
	public String TaskName;
	public String UserName;
	public String TaskType;
	public String GroupName;
	public String ClassName;
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTaskType() {
		return TaskType;
	}
	public void setTaskType(String taskType) {
		TaskType = taskType;
	}
	public String getGroupName() {
		return GroupName;
	}
	public void setGroupName(String groupName) {
		GroupName = groupName;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public int getTaskID() {
		return TaskID;
	}
	public void setTaskID(int taskID) {
		TaskID = taskID;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	public String getFilePath() {
		return FilePath;
	}
	public void setFilePath(String filePath) {
		FilePath = filePath;
	}
	public String getTaskName() {
		return TaskName;
	}
	public void setTaskName(String taskName) {
		TaskName = taskName;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
}
