package cn.edu.jsu.zhangren.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import cn.edu.jsu.zhangren.dao.daotool;
/**
 * 注册账户的数据库连接
 * */
public class registerservice {

	public static int tores(String id,String password) {
		int ans = 1;
		
		Connection conn = null;
		PreparedStatement presta = null;
		ResultSet res = null;
		conn = daotool.getconnection();
		String sql = "select * from user where id = ?";
		try {
			presta = conn.prepareStatement(sql);
			presta.setString(1, id);
			res= presta.executeQuery();
			if(!res.next()) {
				String sql2 = "insert into  user(password,id)values(?,?)";
				presta = conn.prepareStatement(sql2);
				
				presta.setString(1, password);
				presta.setString(2, id);
				presta.executeUpdate();
				JOptionPane.showMessageDialog(null, "注册成功", "INFORMATION_MESSAGE",JOptionPane.INFORMATION_MESSAGE);
				return 1;
			}else {
				JOptionPane.showMessageDialog(null, "用户名已存在", "ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ans;
	}
}
