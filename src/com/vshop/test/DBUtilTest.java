package com.vshop.test;

import com.vshop.db.DBUtil;
import com.vshop.util.StringHelper;

public class DBUtilTest {
	
	public static void main(String[] args) {	
		
		//能够连接到链接对象
		System.out.println(DBUtil.getConnection());	
		
		//测试查询
		System.out.println(DBUtil.executeQuery("select user_id from user where id=1"));
		
		//测试其他
		System.out.println(StringHelper.getCurrentFormatDate());
		//时间戳
		System.out.println(StringHelper.getCurrentFormatDate());
		
	}

}
