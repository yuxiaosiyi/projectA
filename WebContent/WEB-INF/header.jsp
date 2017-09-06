<%@page import="org.lanqiao.service.CategoryServiceImpl"%>
<%@page import="org.lanqiao.service.CategoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!-- Logo -->
<div id="divhead">
  <table cellspacing="0" class="headtable">
    <tr>
      <td><a href="${pageContext.request.contextPath }/news.do"><img src="${pageContext.request.contextPath }/images/logo.gif" width="95" height="30" border="0" /></a></td>
      <td style="text-align:right"><img src="${pageContext.request.contextPath }/images/cart.gif" width="26" height="23" style="margin-bottom:-4px"/>&nbsp;<a href="${pageContext.request.contextPath }/dispacher.do?type=cart">购物车</a>　|　<a href="#">帮助中心</a>　|　<a href="${pageContext.request.contextPath }/dispacher.do?type=loginsuccess">我的帐户</a>　|　<a href="${pageContext.request.contextPath }/dispacher.do?type=reg">新用户注册</a></td>
    </tr>
  </table>
</div> 
<!-- Logo end -->

<%
	CategoryService cs=new CategoryServiceImpl();
	request.setAttribute("cates", cs.getCategory1());
%>
<!-- menu -->
<div id="divmenu">
	<c:forEach items="${cates }" var="item">
    <a href="${pageContext.request.contextPath }/list.do?type=goods&cid=${item.cid}">${item.cname }</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</c:forEach>
	&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath }product_list.html" style="color:#FFFF00">全部商品目录</a>
</div>
<!-- menu end -->
<!-- search -->
<div id="divsearch"><table width="100%" border="0" cellspacing="0">
  <tr>
    <td style="text-align:right; padding-right:220px">
  <input type="text" name="textfield" class="inputtable"/>
<!--<input name="searchbutton" type="image" src="images/serchbutton.gif" style=" margin-bottom:-4px"/>-->
<a href="search.html"><img src="${pageContext.request.contextPath }/images/serchbutton.gif" border="0" style="margin-bottom:-4px"/></a></td>
  </tr>
</table>

</div>
<!-- search end -->