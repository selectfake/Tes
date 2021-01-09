package cn.edu.jsu.zhangren.dao;

/**
 * 定义sm，xb，dh，zp与数据库连接的dao类
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import cn.edu.jsu.zhangren.dao.DatabaseConnectionSql;
import cn.edu.jsu.zhangren.vo.Peo;
public class AllDate {
	private Connection conn=new DatabaseConnectionSql().getConnection();
	public AllDate() {}
	public List<Peo> getAllPetData() {
		List<Peo> listpets=new ArrayList<Peo>();
		String sql="select * from datainput";
		try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Peo peo=new Peo();
				peo.setXm(rs.getString(1));
				peo.setXb(rs.getString(2));
				peo.setDh(rs.getString(3));
				peo.setZp(rs.getString(4));

				listpets.add(peo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listpets;
	}
	
	
	public Vector<Vector> getTableRows(List<Peo> list){
		Vector<Vector> rows=new Vector<Vector>();
		for(int i=0;i<list.size();i++) {
			Vector row=new Vector();
			Peo pets=list.get(i);
			Collections.addAll(row, pets.getXm(),pets.getXb(),pets.getDh(),pets.getZp());
			rows.add(row);
		}
		return rows;
	}
	public static int tologin(String id, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

}