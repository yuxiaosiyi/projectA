package org.lanqiao.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.dao.UserDao;
import org.lanqiao.dao.UserDaoImpl;
import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;
import org.lanqiao.service.UserServiceImpl;

import com.google.gson.Gson;

/**
 * Servlet implementation class UserControllerServlet
 */
@WebServlet(name = "usercontroller", urlPatterns = { "/usercontroller.do" })
public class UserControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	String type=request.getParameter("type");
	if(type!=null&&type.equals("list")){
		UserService us=new UserServiceImpl();
		List<User> user=us.getuserOnback1();
		Gson gson=new Gson();
		response.getWriter().write(gson.toJson(user));
	}else if(type!=null&&type.equals("add")){
		 String uemail=request.getParameter("uemail");
		 String uname=request.getParameter("uloginid");
		 String upassword=request.getParameter("upassword");
		 String usex=request.getParameter("usex");
		 String utel=request.getParameter("utel");
		 String uaddress=request.getParameter("uaddress");
		 String userid=UUID.randomUUID().toString();
		 String uroleid="116F9526C319462780B9CA72F6BB9B41";
		 String ustateid="B5868B7A06E54DAEB19658343D3A2B28";
		 
		 User user=new User(userid, uemail, uname, upassword, usex, uaddress, utel, ustateid, uroleid);
		 UserDao ud=new UserDaoImpl();
		 ud.getUser(user);
		 response.getWriter().write("1");
	}else if(type!=null&&type.equals("remove")){
		String userid=request.getParameter("userid");
		System.out.println(userid);
		UserService us=new UserServiceImpl();
		us.removeUser1(userid);
		response.getWriter().write("1");
	}else if(type!=null&&type.equals("edit")){
		 String uemail=request.getParameter("uemailt");
		 String uname=request.getParameter("uloginidt");
		 String upassword=request.getParameter("upasswordt");
		 String usex=request.getParameter("usext");
		 String utel=request.getParameter("utelt");
		 String uaddress=request.getParameter("uaddresst");
		 String userid=request.getParameter("userid");
		 String uroleid="116F9526C319462780B9CA72F6BB9B41";
		 String ustateid="B5868B7A06E54DAEB19658343D3A2B28";
		 User user=new User(userid, uemail, uname, upassword, usex, uaddress, utel, ustateid, uroleid);
		 UserService us=new UserServiceImpl();
		 us.updateUser(user);
		 response.getWriter().write("1");
	}
	
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	doGet(request, response);
}
}
