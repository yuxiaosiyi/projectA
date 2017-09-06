package org.lanqiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.User;
import org.lanqiao.util.DButil;

public class UserDaoImpl implements UserDao {

	@Override
	public void getUser(User user) {
		
		Connection conn= DButil.getconnection();
		String sql="insert into t_user values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getUemail());
			ps.setString(3, user.getUloginid());
			ps.setString(4, user.getUpassword());
			ps.setString(5, user.getUsex());
			ps.setString(6, user.getUaddress());
			ps.setString(7, user.getUtel());
			ps.setString(8, user.getUstateid());
			ps.setString(9, user.getUroleid());
			ResultSet rs=ps.executeQuery();
			
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User getUserByLoginId(String loginid) {
		User user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			//1获取连接
			conn = DButil.getconnection();
			//2通过连接创建PreparedStatement对象;
			String sql="select * from t_user where uloginid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);
			//3执行操作
			rs = ps.executeQuery();
			//4取数据;
			if(rs.next()){
				user =new User(rs.getString("userid"), rs.getString("uemail"), rs.getString("uloginid"), rs.getString("upassword"), rs.getString("usex"), rs.getString("uaddress"), rs.getString("utel"), rs.getString("ustateid"), rs.getString("uroleid"));
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
		return user;
	}

	@Override
	public void upDate(User user) {
		Connection conn= DButil.getconnection();
		String sql="update t_user set uemail=?,uloginid=?,upassword=?,usex=?,uaddress=?,utel=?,ustateid=?,uroleid=? where userid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			System.out.println(1);
			ps.setString(1, user.getUemail());
			ps.setString(2, user.getUloginid());
			ps.setString(3, user.getUpassword());
			ps.setString(4, user.getUsex());
			ps.setString(5, user.getUaddress());
			ps.setString(6, user.getUtel());
			ps.setString(7, user.getUstateid());
			ps.setString(8, user.getUroleid());
			ps.setString(9, user.getUserid());
			//System.out.println(2);
			//System.out.println(user.getUserid());
			int k=ps.executeUpdate();
			System.out.println(k);
			
			
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> getuserOnback() {
		List<User> user=new ArrayList<User>();
		User us=new User();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			//1获取连接
			conn = DButil.getconnection();
			//2通过连接创建PreparedStatement对象;
			String sql="select * from t_user ";
			ps = conn.prepareStatement(sql);
			
			//3执行操作
			rs = ps.executeQuery();
			//4取数据;
			while(rs.next()){
				us =new User(rs.getString("userid"), rs.getString("uemail"), rs.getString("uloginid"), rs.getString("upassword"), rs.getString("usex"), rs.getString("uaddress"), rs.getString("utel"), rs.getString("ustateid"), rs.getString("uroleid"));
				user.add(us);
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
		return user;
	}

	@Override
	public void removeUser(String userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			//1获取连接
			conn = DButil.getconnection();
			//2通过连接创建PreparedStatement对象;
			String sql="delete t_user where userid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			//3执行操作
			ps.executeUpdate();
			//4取数据;
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
		
	}

}
