package com.vshop.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库操作工具类
 * @author ASUS
 *@version 1.0
 *
 */
public class DBUtil {
	/**
	 * 从C3P0数据库链接池中获取数据库链接对象
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// 从数据连接池中获取数据库连接对象
			conn = ConnectionManager.getInstance().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 释放资源
	 * 
	 * @param connection
	 * @param psmtStatement
	 * @param resultSet
	 */
	public static void close(Connection connection,
			PreparedStatement psmtStatement, ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (psmtStatement != null) {
				psmtStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 增删改的通用方法
	 * 
	 * @param sql
	 * @param objects
	 * @return
	 */
	public static int executeUpdate(String sql, Object... objects) {
		int result = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			if (objects != null) {
				for (int i = 0; i < objects.length; i++) {
					psmt.setObject(i + 1, objects[i]); // 下标从1开始的
				}
			}
			result = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, psmt, null);
		}
		return result;
	}

	/**
	 * 查询通用的方法
	 * 
	 * @param sql
	 * @param rsHandler
	 * @param objects
	 * @return
	 */
	public static Object executeQuery(String sql, IResultSetUtil rsHandler,
			Object... objects) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			if (objects != null) {
				for (int i = 0; i < objects.length; i++) {
					preparedStatement.setObject(i + 1, objects[i]);

				}
			}
			resultSet = preparedStatement.executeQuery();

			return rsHandler.doHandler(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement, resultSet);
		}
		return null;
	}

	/**
	 * 查询单个字段值通用的方法
	 * 
	 * @param sql
	 * @param objects
	 * @return
	 */
	public static Object executeQuery(String sql, Object... objects) {
		return executeQuery(sql, new IResultSetUtil() {
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				Object object = null;
				if (rs.next()) {
					object = rs.getObject(1);
				}
				return object;
			}
		}, objects);
	}

}
