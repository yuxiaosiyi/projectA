package org.lanqiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;
import org.lanqiao.entity.Publisher;
import org.lanqiao.util.DButil;

public class GoodsDaoImpl implements GoodsDao {
	//获取某一类别商品数据;
	@Override
	public PageInfo<Goods> list(String cid,int pagesize, int pageindex) {
		
		PageInfo<Goods> pageinfo = new PageInfo<Goods>();
		
		List<Goods> list = new ArrayList<Goods>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			//1获取连接
			PublisherDao dao=new PublisherDaoImpl();
			conn = DButil.getconnection();
			//2通过连接创建preparedstatement对象;
			String sql="select t2.* from (select t1.* ,rownum rn from (select * from t_goods where cid=?) t1 where rownum<=? ) t2 where rn>=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			int endindex = pagesize * pageindex+pagesize;
			int startindex = pageindex*pagesize +1;
			ps.setInt(2, endindex);
			ps.setInt(3, startindex);
			//3执行操作
			rs = ps.executeQuery();
			//4取数据;
			Goods goods = null;
			while(rs.next()){
				goods = new Goods(rs.getString("gid"), rs.getString("gtitle"), rs.getString("gauthor"), rs.getDouble("gsaleprice"), rs.getDouble("ginprice"), rs.getString("gdesc"), rs.getString("gimg"), rs.getInt("gclicks"), rs.getString("cid"), rs.getString("pid"));
				Publisher publisher=dao.getPublisher();
				goods.setPublisher(publisher);
				list.add(goods);
			}
			//给pageinfo对象赋值;
			pageinfo.setDatas(list);
			pageinfo.setIsfirstpage(pageindex==1);
			int totalnumber = this.totalRecords(cid);
			int totalpage = totalnumber % pagesize ==0 ? totalnumber / pagesize : totalnumber /pagesize +1;
			pageinfo.setIslastpage(totalpage==pageindex);
			pageinfo.setPageindex(pageindex);
			pageinfo.setPagesize(pagesize);
			pageinfo.setTotalnumber(totalnumber);
			pageinfo.setTotalpages(totalpage);
			
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
		return pageinfo;
	}
	//获取某一类别商口总数;
	@Override
	public int totalRecords(String cid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int total = 0;
		try{
			//1获取连接
			conn = DButil.getconnection();
			//2通过连接创建preparedstatement对象;
			String sql="select count(*) from t_goods where cid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			//3执行操作
			rs = ps.executeQuery();
			//4取数据;
			if(rs.next()){
				total = rs.getInt(1);
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
		return total;
	}
	@Override
	public Goods get(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Goods goods=null;
		try{
			//1获取连接
			conn = DButil.getconnection();
			//2通过连接创建preparedstatement对象;
			String sql="select * from t_goods where gid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			//3执行操作
			rs = ps.executeQuery();
			//4取数据;
			if(rs.next()){
				goods=new Goods(rs.getString("gid"), rs.getString("gtitle"), rs.getString("gauthor"), rs.getDouble("gsaleprice"), rs.getDouble("ginprice"), rs.getString("gdesc"), rs.getString("gimg"), rs.getInt("gclicks"), rs.getString("cid"), rs.getString("pid"));
			}
			PublisherDao dao=new PublisherDaoImpl();
			Publisher publisher=dao.getPublisher();
			goods.setPublisher(publisher);
			
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
		return goods;
	}
	@Override
	public void addGoods(Goods goods) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try{
			//1获取连接
			conn = DButil.getconnection();
			//2通过连接创建preparedstatement对象;
			String sql="insert into t_goods values(?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, goods.getGid());
			ps.setString(2, goods.getGtitle());
			ps.setString(3, goods.getGauthor());
			ps.setDouble(4, goods.getGsaleprice());
			ps.setDouble(5, goods.getGinprice());
			ps.setString(6, goods.getGdesc());
			ps.setString(7, goods.getGimg());
			ps.setInt(8, goods.getGclicks());
			ps.setString(9, goods.getCid());
			ps.setString(10, goods.getPid());
			//3执行操作
		   ps.executeUpdate();
			System.out.println("123");
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
	@Override
	public void updateGoods(Goods goods) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			//1获取连接
			conn = DButil.getconnection();
			//2通过连接创建preparedstatement对象;
			String sql="update t_goods set gtitle=?,gauthor=?,gsaleprice=?,ginprice=?,gimg=?,gclicks=?,cid=?,pid=? where gid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, goods.getGtitle());
			ps.setString(2, goods.getGauthor());
			ps.setDouble(3, goods.getGsaleprice());
			ps.setDouble(4, goods.getGinprice());
			ps.setString(5, goods.getGimg());
			ps.setInt(6, goods.getGclicks());
			ps.setString(7, goods.getCid());
			ps.setString(8, goods.getPid());
			ps.setString(9, goods.getGid());
			//3执行操作
			ps.executeUpdate();
			//4取数据;
			
		}catch(Exception e){
			
		}
		finally{
			//5关闭对象
			try {
				
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}
	@Override
	public void removeGoods(String gid) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			//1获取连接
			conn = DButil.getconnection();
			//2通过连接创建preparedstatement对象;
			String sql="delete from t_goods where gid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, gid);
			//3执行操作
			ps.executeUpdate();
			//4取数据;
			
			
		}catch(Exception e){
			
		}
		finally{
			//5关闭对象
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

}