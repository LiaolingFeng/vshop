package com.vshop.service;

import java.util.List;

import com.vshop.entity.Sys;

/**
 * 系统设置业务逻辑的接口
 * 
 * @author ASUS
 *@version 1.0
 */
public interface ISysService {

	/**
	 * 更新系统设置
	 * @param sys
	 * @return
	 */
	public boolean update(Sys sys);
	
	/**
	 * 获取所有的系统设置记录
	 * @return
	 */
	public List<Sys> getList();
	
	/**
	 * 获取相应的奖金
	 * @param num
	 * @return
	 */
	public float getMoneyByNum(int num);
}
