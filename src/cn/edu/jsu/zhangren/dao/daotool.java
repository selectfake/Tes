package cn.edu.jsu.zhangren.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class daotool {
/**
 * ���ݿ�����
 * @return
 */
	public static Connection getconnection() {
		Connection conn = null;
		try {
			/**��������*/
			Class.forName("com.mysql.cj.jdbc.Driver");
			/**���������ݿ������*/
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/curriculumdesign?serverTimezone=GMT", "root", "000000");
			//conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
