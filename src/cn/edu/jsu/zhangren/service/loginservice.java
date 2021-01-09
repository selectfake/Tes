package cn.edu.jsu.zhangren.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import cn.edu.jsu.zhangren.dao.daotool;
/**
 * 登录的数据库连接
 */
public class loginservice {

	public static int tologin(String id,String password) {
		
		Connection conn = null;
		PreparedStatement presta = null;
		ResultSet res = null;
		conn = daotool.getconnection();
		String sql = "select * from user where id = ?";
		try {
			presta = conn.prepareStatement(sql);
			presta.setString(1, id);
			res= presta.executeQuery();
			if(res.next()) {
				String pwd = res.getString("password");
				if(pwd.equals(password)) {
					
					return 1;
				}else{
					JOptionPane.showMessageDialog(null, "密码错误", "ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
					return -1;
				}
				 
			}else {
				JOptionPane.showMessageDialog(null, "用户不存在", "ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
				return -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
}
