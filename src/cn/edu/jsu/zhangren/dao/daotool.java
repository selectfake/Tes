package cn.edu.jsu.zhangren.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class daotool {
/**
 * 数据库连接
 * @return
 */
	public static Connection getconnection() {
		Connection conn = null;
		try {
			/**加载驱动*/
			Class.forName("com.mysql.cj.jdbc.Driver");
			/**建立和数据库的连接*/
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/curriculumdesign?serverTimezone=GMT", "root", "000000");
			//conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
