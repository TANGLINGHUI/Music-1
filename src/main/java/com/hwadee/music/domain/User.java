package com.hwadee.music.domain;

public class User {
	private int user_id;//用户ID
	private String user_name;//用户姓名
	private String  user_mail;//用户邮箱
	private String user_gender;//用户性别
	private String user_pwd;//用户密码
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_mail() {
		return user_mail;
	}
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public User(int user_id, String user_name, String user_mail, String user_gender, String user_pwd) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_mail = user_mail;
		this.user_gender = user_gender;
		this.user_pwd = user_pwd;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_mail=" + user_mail + ", user_gender="
				+ user_gender + ", user_pwd=" + user_pwd + "]";
	}
	

	
}
