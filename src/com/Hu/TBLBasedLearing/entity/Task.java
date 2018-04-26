package com.Hu.TBLBasedLearing.entity;

import java.util.Date;

public class Task {
	
	private int TaskID;
	private String TaskName;
	private String TaskDetails;
	private String TeacherID;
	private int GroupID;
	private String Status;
	private Date CreateDate;
	private Date EndDate;
	private String FilePath;
	private String Level;
	private String TeacherName;
	private int StudentID;
	public int getTaskID() {
		return TaskID;
	}
	public void setTaskID(int taskID) {
		TaskID = taskID;
	}
	public String getTaskName() {
		return TaskName;
	}
	public void setTaskName(String taskName) {
		TaskName = taskName;
	}
	public String getTaskDetails() {
		return TaskDetails;
	}
	public void setTaskDetails(String taskDetails) {
		TaskDetails = taskDetails;
	}
	public String getTeacherID() {
		return TeacherID;
	}
	public void setTeacherID(String teacherID) {
		TeacherID = teacherID;
	}
	public int getGroupID() {
		return GroupID;
	}
	public void setGroupID(int groupID) {
		GroupID = groupID;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	public String getFilePath() {
		return FilePath;
	}
	public void setFilePath(String filePath) {
		FilePath = filePath;
	}
	public String getLevel() {
		return Level;
	}
	public void setLevel(String level) {
		Level = level;
	}
	public String getTeacherName() {
		return TeacherName;
	}
	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}
}
