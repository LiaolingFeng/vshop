package com.vshop.util;

import com.vshop.service.ISysService;
import com.vshop.service.impl.SysServiceImpl;

/**
 * 自定义函数类
 * 
 * @author ASUS
 * @version 1.0
 * 
 */
public class GetMoney {

	/**
	 * 自定义函数（用在EL表达式中）
	 * 
	 * @return
	 */
	public static float GetMoneyByNum(int right,int left) {
		ISysService sysService = new SysServiceImpl();
		return sysService.getMoneyByNum((right-left-1)/2);
	}
}
