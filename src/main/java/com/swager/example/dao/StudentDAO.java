package com.swager.example.dao;

public class StudentDAO {
	
	int studentid;
	String studentname;
	int studentphone;
	 
	public StudentDAO() {
		
	}
	public StudentDAO(int studentid2, String studentname2, int studentphone2) {
		// TODO Auto-generated constructor stub
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public int getStudentphone() {
		return studentphone;
	}
	public void setStudentphone(int studentphone) {
		this.studentphone = studentphone;
	}
	@Override
	public String toString() {
		return "StudentDAO [studentid=" + studentid + ", studentname=" + studentname + ", studentphone="
				+ studentphone + "]";
	}
	
	

}
