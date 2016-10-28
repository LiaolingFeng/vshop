package com.vshop.test;

import java.util.List;

import com.vshop.dao.impl.UserDaoImpl;
import com.vshop.entity.User;
import com.vshop.util.StringHelper;

public class UserDaoImplTest {
	
	public static void main(String[] args) {
		UserDaoImpl userDao = new UserDaoImpl();
		//ctrl + shift +o
	//	User u = userDao.getUserByUserId("auger");
		
	/*	u.setUser_city("北京");
		u.setUser_faq(7);
		
		System.out.println(userDao.saveUserInfo(u));
		
		
		User user = new User();
		user.setUser_id("tom");
		user.setUser_name("TomCat");
		user.setUser_pass(StringHelper.MD5("111111"));
		user.setUser_creator("auger");
		user.setLeft_num(10);
		user.setRight_num(11);
		user.setUser_city("广州");
		user.setUser_birthday("1995-10-02");
		user.setCreated_time(StringHelper.getCurrentTimeStamp());
		System.out.println(userDao.addUser(user));;
		*/
		List<User> list = userDao.getList(1, 4, 1);
		System.out.println(list.size());
	}

}
