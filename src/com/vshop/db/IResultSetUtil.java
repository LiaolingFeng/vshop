package com.vshop.db;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 处理ResultSet的接口
 * 
 * @author ASUS
 * @version 1.0
 * 
 */

public interface IResultSetUtil {
	public Object doHandler(ResultSet rs) throws SQLException;
}
