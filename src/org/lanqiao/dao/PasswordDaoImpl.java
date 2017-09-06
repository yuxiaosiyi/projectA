package org.lanqiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lanqiao.entity.Passwordanswer;
import org.lanqiao.util.DButil;

public class PasswordDaoImpl implements PasswordDao {

	@Override
	public void getPassword(Passwordanswer password) {
		Connection conn= DButil.getconnection();
		String sql="insert into t_passwordanswer values(?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, password.getAnswerid());
			ps.setString(2, password.getAquestion());
			ps.setString(3, password.getAnswer());
			ps.setString(4, password.getEmail());
			ps.setString(5, password.getUserid());
			
			ResultSet rs=ps.executeQuery();
			
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
