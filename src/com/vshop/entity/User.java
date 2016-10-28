package com.vshop.entity;
/**
 * 用户信息实体类
 * @author ASUS
 *@version 1.0
 */

public class User {
	
	public User() {
		
	}
	
	private int id;   //自增Id
	
	private String user_id;   		  //登录账号
	
	private String user_pass; 		 //登录密码（MD5加密）
	
	private int user_level;   		   //所在的树形结构的层级数
	
	private int left_num;			//左侧的值
	
	private int right_num;				//右侧的值
	
	private String user_name;		//真实姓名
	
	private String user_birthday;	//出生日期
	
	private String user_answer;		//密保答案
	
	private int user_faq;			//密保问题
	
	private String user_city;		//所在城市
	
	private String user_creator;	//创建人
	
	private long created_time;		//创建时间（时间戳格式）

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public int getUser_level() {
		return user_level;
	}

	public void setUser_level(int user_level) {
		this.user_level = user_level;
	}

	public int getLeft_num() {
		return left_num;
	}

	public void setLeft_num(int left_num) {
		this.left_num = left_num;
	}

	public int getRight_num() {
		return right_num;
	}

	public void setRight_num(int right_num) {
		this.right_num = right_num;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_birthday() {
		return user_birthday;
	}

	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}

	public String getUser_answer() {
		return user_answer;
	}

	public void setUser_answer(String user_answer) {
		this.user_answer = user_answer;
	}

	public int getUser_faq() {
		return user_faq;
	}

	public void setUser_faq(int user_faq) {
		this.user_faq = user_faq;
	}

	public String getUser_city() {
		return user_city;
	}

	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}

	public String getUser_creator() {
		return user_creator;
	}

	public void setUser_creator(String user_creator) {
		this.user_creator = user_creator;
	}

	public long getCreated_time() {
		return created_time;
	}

	public void setCreated_time(long created_time) {
		this.created_time = created_time;
	}

}
