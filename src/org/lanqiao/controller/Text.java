package org.lanqiao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;

import com.google.gson.Gson;

/**
 * Servlet implementation class Text
 */
@WebServlet(name = "goodlist", urlPatterns = { "/goodslist.do" })
public class Text extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String pageindex = request.getParameter("pageindex");
		
		if(cid==null){
			cid="1";
		}
		
		String pagesize =request.getParameter("pagesize");
		if(pagesize==null)
			pagesize="5";
		if(pageindex==null||pageindex=="0")
			pageindex="1";
		
		
		//根据cid找此类型 所有商品;....

		org.lanqiao.service.GoodsService gs = new org.lanqiao.service.GoodsServiceImpl();
		PageInfo<Goods> pageinfo = gs.goodsList(cid, Integer.parseInt(pagesize),Integer.parseInt(pageindex));
		Gson gson=new Gson();
		response.getWriter().write(gson.toJson(pageinfo));
		
		
//		org.lanqiao.service.CategoryService cs =new org.lanqiao.service.CategoryServiceImpl();
//		Category cate = cs.getCategoryById(cid);
//		request.setAttribute("cate", cate);
//		request.setAttribute("pageinfo", pageinfo);
//		request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
