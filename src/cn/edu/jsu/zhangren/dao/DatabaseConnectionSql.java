package cn.edu.jsu.zhangren.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 数据库连接
  */
public class DatabaseConnectionSql {
	/**定义MySQL数据库驱动程序*/
		private static final String DBRIVER="com.mysql.cj.jdbc.Driver";
		/**定义MySQL数据库连接地址*/
		private static final String DBURL="jdbc:mysql://127.0.0.1:3306/curriculumdesign?serverTimezone=GMT";
		/**定义数据库连接用户名，密码并保存连接对象*/
		private static final String DBUSER="root"; //MySQL数据库连接用户名
		private static final String PASSWORD="000000"; //MySQL数据库连接密码
		private Connection conn=null; //保存连接对象
		public Connection con;
		/**构造方法连接数据库*/
		public DatabaseConnectionSql(){
			try {
				Class.forName(DBRIVER);
				this.conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
			} catch (Exception e) {e.printStackTrace();}
		}
		/**返回数据库连接对象*/
		public Connection getConnection() {
			return this.conn;
		}
		/**关闭数据连接*/
		public void close() {
			if(this.conn!=null) {
				try {
					this.conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		public static void main(String args[]) {
			DatabaseConnectionSql dc=new DatabaseConnectionSql();
			if(dc.getConnection()!=null) {
				System.out.println(1);
			}
		}
	}

