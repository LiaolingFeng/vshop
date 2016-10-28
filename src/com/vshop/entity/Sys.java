package com.vshop.entity;
/**
 * 系统设置实体类
 * @author ASUS
 *
 */

public class Sys {
	
	public Sys() {
		
	}
	private int id;		//自增Id
	
	private int user_level;		//会员级别
	
	private int user_min;		//最小人数
	
	private int user_max;		//最大人数
	
	private float user_money;		//会员级别相应的奖金
	
	private long created_time;		//创建时间（时间戳）
	
	private String creator;		//创建人

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_level() {
		return user_level;
	}

	public void setUser_level(int user_level) {
		this.user_level = user_level;
	}

	public int getUser_min() {
		return user_min;
	}

	public void setUser_min(int user_min) {
		this.user_min = user_min;
	}

	public int getUser_max() {
		return user_max;
	}

	public void setUser_max(int user_max) {
		this.user_max = user_max;
	}

	public float getUser_money() {
		return user_money;
	}

	public void setUser_money(float user_money) {
		this.user_money = user_money;
	}

	public long getCreated_time() {
		return created_time;
	}

	public void setCreated_time(long created_time) {
		this.created_time = created_time;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

}
