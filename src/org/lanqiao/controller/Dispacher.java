package org.lanqiao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Category;
import org.lanqiao.entity.Goods;
import org.lanqiao.entity.News;
import org.lanqiao.entity.User;
import org.lanqiao.service.NewServiceImpl;
import org.lanqiao.service.NewsService;

/**
 * Servlet implementation class Dispacher
 */
@WebServlet(name = "dispacher", urlPatterns = { "/dispacher.do" })
public class Dispacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		String id =request.getParameter("id");
		if(type!=null&&type.equals("news")&&id!=null){
			NewsService ns=new NewServiceImpl();
			News news1=ns.getNewsByid(id);
			request.setAttribute("news1", news1);
			request.getRequestDispatcher("/WEB-INF/news.jsp").forward(request, response);
		}else if(type!=null&&type.equals("reg")){
			request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
		}else if(type!=null&&type.equals("info")&&id!=null){
			org.lanqiao.service.GoodsService gs = new org.lanqiao.service.GoodsServiceImpl();
			org.lanqiao.service.CategoryService cs = new org.lanqiao.service.CategoryServiceImpl();
			Goods goods = gs.getGoodsBygid(id);
			//外键处理的一种方式;
			String cid = goods.getCid();
			Category cate = cs.getCategoryById(cid);
			request.setAttribute("goods", goods);
			request.setAttribute("cate", cate);
			request.getRequestDispatcher("/WEB-INF/info.jsp").forward(request, response);
		}else if(type!=null&&type.equals("loginsuccess")){
			//判断有cookie;
			Cookie[] cookies = request.getCookies();
			Cookie userCookie = null;
			for(Cookie c:cookies){
				if(c.getName().equals("uloginid")){
					userCookie = c;
					break;
				}
			}
			if(userCookie!=null){
				String uloginid = userCookie.getValue();
				//根据帐号找此用户;
				org.lanqiao.service.UserService us =new org.lanqiao.service.UserServiceImpl();
				User user =us.getUserByLoginId(uloginid);			
				request.getSession().setAttribute("user", user);
			}
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}else if(type!=null && type.equals("final") ){
			request.getRequestDispatcher("/WEB-INF/my.jsp").forward(request, response);
			
		}else if(type!=null&&type.equals("update")){
			request.getRequestDispatcher("/WEB-INF/modifyuserinfo.jsp").forward(request, response);;
		}else if(type!=null&&type.equals("cart")){
			request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
