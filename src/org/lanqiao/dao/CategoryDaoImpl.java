package org.lanqiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.Category;
import org.lanqiao.entity.News;
import org.lanqiao.util.DButil;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public List<Category> getCategory() {
		List<Category> cate=new ArrayList<Category>();
		Connection conn= DButil.getconnection();
		String sql="select * from t_category order by corder asc";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			Category category=null;
			while(rs.next()){
			 category= new Category(rs.getString("cid"), rs.getString("cname"));
			 cate.add(category);
			}
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return cate;
	}

	@Override
	public Category get(String cid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Category cate = null;
		try{
			//1获取连接
			conn = DButil.getconnection();
			//2通过连接创建preparedstatement对象;
			String sql="select * from t_category where cid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			//3执行操作
			rs = ps.executeQuery();
			//4取数据;
			if(rs.next()){
				cate = new Category(rs.getString("cid"), rs.getString("cname"));
			}
		}catch(Exception e){
			
		}
		finally{
			//5关闭对象
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cate;
	}

}
