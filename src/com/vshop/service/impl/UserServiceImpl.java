package com.vshop.service.impl;

import java.util.List;

import com.vshop.dao.IUserDao;
import com.vshop.dao.impl.UserDaoImpl;
import com.vshop.entity.User;
import com.vshop.service.IUserService;
/**
 * 实现用户业务逻辑的接口类
 * @author ASUS
 *@version 1.0
 */

public class UserServiceImpl implements IUserService{
	/**
	 * 登录的实现方法   (1.用户名错误，2，密码错误，3.正确)
	 */
	@Override
	public String login(String user_id, String user_pass) {

		IUserDao userDao = new UserDaoImpl();
		return userDao.login(user_id, user_pass);
	}

	/**
	 * 根据用户账号获取用户信息
	 */
	@Override
	public User getUserByUserId(String user_id) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.getUserByUserId(user_id);
	}

	/**
	 * 根据用户账号修改用户信息
	 */
	@Override
	public boolean saveUserInfo(User user) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.saveUserInfo(user);
	}

	/**
	 * 新增用户
	 */
	@Override
	public boolean addUser(User user) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.addUser(user);
	}

	@Override
	public boolean updateLeft_num(int right_num,int id) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.updateLeft_num(right_num,id);
	}

	@Override
	public boolean updateRight_num(int left_num,int id) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.updateRight_num(left_num,id);
	}

	
	/**
	 * 根据用户账号查询该账号所在的树形结构的层级数
	 */
	@Override
	public int getUserLevelByUserId(String user_id) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.getUserLevelByUserId(user_id);
	}

	/**
	 * 根据用户账号更新用户的层级数
	 */
	@Override
	public boolean updateUser_level(int user_level, String user_id) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.updateUser_level(user_level, user_id);
	}

	/**
	 * 查询当前用户下的子节点集合
	 */
	@Override
	public List<User> getList(int left_num, int right_num, int user_level) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.getList(left_num, right_num, user_level);
	}

}
