package org.lanqiao.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;
import org.lanqiao.service.GoodsService;
import org.lanqiao.service.GoodsServiceImpl;


import com.google.gson.Gson;

/**
 * Servlet implementation class GoodsServlerController
 */
@WebServlet(name = "goodscontroller", urlPatterns = { "/goodscontroller.do" })
public class GoodsServlerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String type=request.getParameter("type");
		if(type!=null&&type.equals("list")){
			String cid=request.getParameter("cid");
			String pagesize=request.getParameter("rows");
			String pageindex=request.getParameter("page");
			GoodsService gs=new GoodsServiceImpl();
			PageInfo<Goods> page=gs.goodsList(cid, Integer.parseInt(pagesize), Integer.parseInt(pageindex)-1);
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("total", page.getTotalnumber());
			map.put("rows", page.getDatas());
			Gson gson=new Gson();
			response.getWriter().write(gson.toJson(map));
			System.out.println();
		}else if(type!=null&&type.equals("edit")){
			String gid=request.getParameter("gid");
			String gtitle=request.getParameter("gtitle");
			String gauthor=request.getParameter("gauthor");
			String gsaleprice=request.getParameter("gsaleprice");
			String ginprice=request.getParameter("ginprice");
			String gimg=request.getParameter("gimg");
			String gclick=request.getParameter("gclick");
			String cid=request.getParameter("cid");
			String pid=request.getParameter("pid");
			Goods gd=new Goods();
			String gdesc=gd.getGdesc();
			Goods goods=new Goods(gid, gtitle, gauthor, Double.parseDouble(gsaleprice), Double.parseDouble(ginprice), gdesc, gimg, Integer.parseInt(gclick), cid, pid);
			GoodsService gs=new GoodsServiceImpl();
			gs.updateGoods(goods);
			response.getWriter().write("1");
			System.out.println(goods);
		}else if(type!=null&&type.equals("remove")){
			String gid=request.getParameter("gid");
			System.out.println(gid);
			GoodsService gs=new GoodsServiceImpl();
			gs.removeGoods1(gid);
			response.getWriter().write("1");
		}else if(type!=null&&type.equals("add")){
			String gid=request.getParameter("gid");
			String gtitle=request.getParameter("gtitle");
			String gauthor=request.getParameter("gauthor");
			String gsaleprice=request.getParameter("gsaleprice");
			String ginprice=request.getParameter("ginprice");
			String gimg=request.getParameter("gimg");
			String gclick=request.getParameter("gclick");
			String cid=request.getParameter("cid");
			String pid=request.getParameter("pid");
			String gdesc="随便写点";
			Goods goods=new Goods(gid, gtitle, gauthor, Double.parseDouble(gsaleprice), Double.parseDouble(ginprice), gdesc, gimg, Integer.parseInt(gclick), cid, pid);
			GoodsService gs=new GoodsServiceImpl();
			gs.addGoods(goods);
			response.getWriter().write("1");
			System.out.println(goods);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
