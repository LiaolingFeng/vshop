package com.vshop.service.impl;


import java.util.List;

import com.vshop.dao.ISysDao;
import com.vshop.dao.impl.SysDaoImpl;
import com.vshop.entity.Sys;
import com.vshop.service.ISysService;
/**
 * 实现系统设置业务逻辑的接口类
 * 
 * @author ASUS
 *@version 1.0
 */

public class SysServiceImpl implements ISysService {
	/**
	 * 更新设置
	 */
	@Override
	public boolean update(Sys sys) {
		ISysDao sysDao = new SysDaoImpl();
		return sysDao.update(sys);
	}

	/**
	 * 获取所有设置
	 */
	@Override
	public List<Sys> getList() {
		ISysDao sysDao = new SysDaoImpl();
		return sysDao.getList();
	}

	/**
	 * 获取相应的奖金
	 */
	@Override
	public float getMoneyByNum(int num) {
		ISysDao sysDao = new SysDaoImpl();
		return sysDao.getMoneyByNum(num);
	}

}
