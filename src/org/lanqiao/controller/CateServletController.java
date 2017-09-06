package org.lanqiao.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Category;
import org.lanqiao.service.CategoryService;
import org.lanqiao.service.CategoryServiceImpl;

import com.google.gson.Gson;

/**
 * Servlet implementation class CateServletController
 */
@WebServlet(name = "catecontroller", urlPatterns = { "/catecontroller.do" })
public class CateServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		CategoryService cs=new CategoryServiceImpl();
		List<Category> cate=cs.getCategory1();
		Gson gson=new Gson();
		response.getWriter().write(gson.toJson(cate));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
