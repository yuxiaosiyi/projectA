

package org.lanqiao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Category;
import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;
import org.lanqiao.service.CategoryServiceImpl;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet(name = "listServlet", urlPatterns = { "/list.do" })
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String pid=request.getParameter("pid");
		String pageindex = request.getParameter("pageindex");
		if(pageindex==null){
			pageindex="1";
		}
		if(cid==null){
			cid="1";
		}
		if(pid==null){
			pid="1";
		}
		int pagesize =5;
		
		//根据cid找此类型 所有商品;....

		org.lanqiao.service.GoodsService gs = new org.lanqiao.service.GoodsServiceImpl();
		PageInfo<Goods> pageinfo = gs.goodsList(cid, pagesize,Integer.parseInt(pageindex));
		
		org.lanqiao.service.CategoryService cs =new org.lanqiao.service.CategoryServiceImpl();
		Category cate = cs.getCategoryById(cid);
		request.setAttribute("cate", cate);
		request.setAttribute("pageinfo", pageinfo);
		request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}