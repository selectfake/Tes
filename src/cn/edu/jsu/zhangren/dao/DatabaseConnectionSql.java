package cn.edu.jsu.zhangren.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * ���ݿ�����
  */
public class DatabaseConnectionSql {
	/**����MySQL���ݿ���������*/
		private static final String DBRIVER="com.mysql.cj.jdbc.Driver";
		/**����MySQL���ݿ����ӵ�ַ*/
		private static final String DBURL="jdbc:mysql://127.0.0.1:3306/curriculumdesign?serverTimezone=GMT";
		/**�������ݿ������û��������벢�������Ӷ���*/
		private static final String DBUSER="root"; //MySQL���ݿ������û���
		private static final String PASSWORD="000000"; //MySQL���ݿ���������
		private Connection conn=null; //�������Ӷ���
		public Connection con;
		/**���췽���������ݿ�*/
		public DatabaseConnectionSql(){
			try {
				Class.forName(DBRIVER);
				this.conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
			} catch (Exception e) {e.printStackTrace();}
		}
		/**�������ݿ����Ӷ���*/
		public Connection getConnection() {
			return this.conn;
		}
		/**�ر���������*/
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

