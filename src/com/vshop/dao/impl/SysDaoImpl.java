package com.vshop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vshop.dao.ISysDao;
import com.vshop.db.DBUtil;
import com.vshop.db.IResultSetUtil;
import com.vshop.entity.Sys;

/**
 * 实现系统设置操作的接口类
 * @author ASUS
 *@version 1.0
 */

public class SysDaoImpl implements ISysDao{


	/**
	 * 更新系统设置
	 */
	@Override
	public boolean update(Sys sys) {
		String sql = "UPDATE sys SET user_level=?,user_min=?,user_max=?,user_money=? WHERE id=?";
		return DBUtil.executeUpdate(sql, 
				sys.getUser_level(),
				sys.getUser_min(), 
				sys.getUser_max(), 
				sys.getUser_money(),
				sys.getId()) > 0;
	}

	/**
	 * 获取所有的系统设置记录数
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Sys> getList() {
		String sql = "SELECT id,user_level,user_min,user_max,user_money FROM sys";

		return (List<Sys>) DBUtil.executeQuery(sql, new IResultSetUtil() {

			List<Sys> list = new ArrayList<Sys>();

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				while (rs.next()) {
					Sys sys = new Sys();
					sys.setId(rs.getInt(1));
					sys.setUser_level(rs.getInt(2));
					sys.setUser_min(rs.getInt(3));
					sys.setUser_max(rs.getInt(4));
					sys.setUser_money(rs.getFloat(5));
					list.add(sys);
				}
				return list;
			}
		});
	}

	/**
	 * 获取相应的奖金
	 */
	@Override
	public float getMoneyByNum(int num) {
		System.out.println("num=" +num);
		String sql = "SELECT user_money FROM sys WHERE ? >= user_min AND ? <= user_max ";
		return DBUtil.executeQuery(sql,num,num) == null ? 0 : Float
				.parseFloat(DBUtil.executeQuery(sql,num,num).toString());
	}

}
