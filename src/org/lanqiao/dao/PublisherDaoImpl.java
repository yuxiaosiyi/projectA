package org.lanqiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lanqiao.entity.Publisher;
import org.lanqiao.util.DButil;

public class PublisherDaoImpl implements PublisherDao {

	@Override
	public Publisher getPublisher() {
		
		Publisher publisher=null;
		Connection conn= DButil.getconnection();
		String sql="select * from t_publisher order by pid asc";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
			 publisher= new Publisher(rs.getString("pid"), rs.getString("pname"));
			}
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		return publisher;
	}

}
