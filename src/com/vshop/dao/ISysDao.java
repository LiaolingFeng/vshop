package com.vshop.dao;

import java.util.List;

import com.vshop.entity.Sys;

/**
 * 系统设置的接口类
 * @author ASUS
 *@version 1.0
 *
 *alt+/
 */
public interface ISysDao {
	
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
