package web.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class BaseDAO {
	/**
	 * 驱动类
	 */

	private static final String JDBC = "com.mysql.jdbc.Driver";
	/**
	 * 连接字符串
	 */
	private static final String SQL = "jdbc:mysql://localhost:3306/mydb";
	/**
	 * 数据库用户名
	 */
	private static final String NAME = "root";
	/**
	 * 数据库密码
	 */
	private static final String PSWW = "123456";

	/**
	 * 连接对象
	 */
	protected static Connection conn;
	/**
	 * 预处理对象
	 */
	protected static PreparedStatement ps;
	/**
	 * 结果集
	 */
	protected static ResultSet rs;

	/**
	 * 获得连接对象
	 * 
	 * @return
	 */
	protected static Connection getConn() {
		try {
			Class.forName(JDBC);
			conn = DriverManager.getConnection(SQL, NAME, PSWW);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 释放资源
	 * 
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	protected void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
