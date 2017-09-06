package org.lanqiao.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.dao.PasswordDao;
import org.lanqiao.dao.PasswordDaoImpl;
import org.lanqiao.dao.UserDao;
import org.lanqiao.dao.UserDaoImpl;
import org.lanqiao.entity.Passwordanswer;
import org.lanqiao.entity.User;
import org.lanqiao.util.MailUtil;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(name = "user", urlPatterns = { "/user.do" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 request.setCharacterEncoding("UTF-8");
		 String uemail=request.getParameter("uemail");
		 String uname=request.getParameter("uname");
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
		 
		 String question=request.getParameter("uquestion");
		 String answer= request.getParameter("uanswer");
		 String answerid=UUID.randomUUID().toString();
		 String ruemail=request.getParameter("ruemail");
		 
		 Passwordanswer pa=new Passwordanswer(answerid, question, answer, ruemail, userid);
		 PasswordDao ps=new PasswordDaoImpl();
		 ps.getPassword(pa);
		
		 MailUtil.sendMail("759621828@qq.com","这里输什么呀", "我去");
		 request.getRequestDispatcher("/WEB-INF/registersuccess.jsp").forward(request, response);
		 
		 
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
