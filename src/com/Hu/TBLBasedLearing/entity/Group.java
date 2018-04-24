package com.Hu.TBLBasedLearing.entity;

public class Group {
	private int GroupID;
	private String GroupName;
	private String CreateDate;
	private String DismissDate;
	private int TeacherID;
	private int ClassID;
	private String ClassName;
	private int GroupLeaderID;
	private String GroupLeader;

	private String GroupLeaderNo;
	
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public String getGroupLeaderNo() {
		return GroupLeaderNo;
	}
	public void setGroupLeaderNo(String groupLeaderNo) {
		GroupLeaderNo = groupLeaderNo;
	}
	public String getGroupLeader() {
		return GroupLeader;
	}
	public void setGroupLeader(String groupLeader) {
		GroupLeader = groupLeader;
	}
	public int getGroupID() {
		return GroupID;
	}
	public void setGroupID(int groupID) {
		GroupID = groupID;
	}
	public String getGroupName() {
		return GroupName;
	}
	public void setGroupName(String groupName) {
		GroupName = groupName;
	}
	public String getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(String createDate) {
		CreateDate = createDate;
	}
	public String getDismissDate() {
		return DismissDate;
	}
	public void setDismissDate(String dismissDate) {
		DismissDate = dismissDate;
	}
	public int getTeacherID() {
		return TeacherID;
	}
	public void setTeacherID(int teacherID) {
		TeacherID = teacherID;
	}
	public int getClassID() {
		return ClassID;
	}
	public void setClassID(int classID) {
		ClassID = classID;
	}
	public int getGroupLeaderID() {
		return GroupLeaderID;
	}
	public void setGroupLeaderID(int groupLeaderID) {
		GroupLeaderID = groupLeaderID;
	}

}
