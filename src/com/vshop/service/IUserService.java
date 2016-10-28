package com.vshop.service;

import java.util.List;
import com.vshop.entity.User;

/**
 * 用户业务逻辑的接口
 * @author ASUS
 *
 */

public interface IUserService {
	/**
	 * 登录的实现方法   (1.用户名错误，2，密码错误，3.正确)
	 */
	public String login(String user_id,String user_pass);
	
	/**
	 * 根据用户账号获取用户信息
	 * @param user_id
	 * @return
	 */
	public User getUserByUserId(String user_id);
	
	/**
	 * 保存用户信息
	 * @param user_id
	 * @return
	 */
	public boolean saveUserInfo(User user);
	
	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	public boolean addUser(User user);
	
	
	/**
	 * 更新左下标值
	 * @param right_num
	 * @return
	 */
	public boolean updateLeft_num(int right_num,int id);
	
	
	/**
	 * 更新右下标值
	 * @param left_num
	 * @return
	 */
	public boolean updateRight_num(int left_num,int id);
	
	
	/**
	 * 根据用户账号查询该账号所在的树形结构的层级数
	 * @param user_id
	 * @return
	 */
	public int getUserLevelByUserId(String user_id);

	
	/**
	 * 根据用户账号更新用户的层级数
	 * @param user_level
	 * @param user_id
	 * @return
	 */
	public boolean updateUser_level(int user_level,String user_id);
	
	/**
	 * 查询当前用户下的子节点集合
	 * @param left_num
	 * @param right_num
	 * @return
	 */
	public List<User> getList(int left_num,int right_num,int user_level);

}
