package org.lanqiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import org.lanqiao.entity.News;
import org.lanqiao.util.DButil;

public class NewsDaoImpl implements NewsDao {

	@Override
	public List<News> list() {
		List<News> li=new ArrayList<News>();
		Connection conn= DButil.getconnection();
		String sql="select * from T_NEWS";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			News news=null;
			while(rs.next()){
				news = new News(rs.getString("tid"), rs.getString("title"), rs.getString("tcontent"), rs.getString("tpubdate"));
				li.add(news);
			}
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return li;
	}

	@Override
	public News get(String id) {
		News news1=null;
		Connection conn= DButil.getconnection();
		String sql="select * from T_NEWS";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			News news=null;
			while(rs.next()){
				news1 = new News(rs.getString("tid"), rs.getString("title"), rs.getString("tcontent"), rs.getString("tpubdate"));
				
			}
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return news1;
	}

}
