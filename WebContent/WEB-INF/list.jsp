<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="gb2312">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <meta content="all" name="robots" />
    <meta name="author" content="Fisher" />
    <meta name="Copyright" content="Copyright 2007-2008, 版权所有 www.reefdesign.cn" />
    <meta name="description" content="reefdesign" />
    <meta name="keywords" content="reefdesign" />
    <title>电子书城</title>
    <link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />
</head>
<body class="main">
	<%@include file="header.jsp" %>
    <div id="divpagecontent">
        <table width="100%" border="0" cellspacing="0">
            <tr>
                <td>
                    <div style="text-align: right; margin: 5px 10px 5px 0px">
                        <a href="${pageContext.request.contextPath}">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;公告新闻</div>
                    <table cellspacing="0" class="infocontent">
                        <tr>
                            <td>
                                <table width="100%" border="0" cellspacing="0">
                                    <tr>
                                        <td style="padding: 10px">
                                        <c:set var="cid" value="1"></c:set>
                                            以下 <strong>${pageinfo.totalnumber}</strong> 条  每页显示<strong>${fn:length(pageinfo.datas)}</strong>条<hr />
									<c:forEach items="${pageinfo.datas }" var="goods">
										<c:set var="cid" value="${goods.cid }"></c:set>
                                            <table border="0" cellspacing="0" class="searchtable">
                                                <tr>
                                                    <td width="20%" rowspan="2">
                                                        <div class="divbookpic">
                                                            <p>
                                                                <a href="${pageContext.request.contextPath }/dispacher.do?id=${goods.gid}&type=info">
                                                                    <img src="${pageContext.request.contextPath }/images/bookcover/${goods.gimg }.jpg" width="115" height="129" border="0" /></a></p>
                                                        </div>
                                                    </td>
                                                    <td colspan="2">
                                                        <font class="bookname">${goods.gtitle }</font><br />
                                                        作者：${goods.gauthor } 著<br />
                                               ${goods.gdesc }
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        售价：<font color="#FF0000">￥${goods.gsaleprice }</font>&nbsp;&nbsp;&nbsp;&nbsp;原价：<s>￥${goods.ginprice }</s>
                                                    </td>
                                                    <td style="text-align: right">
                                                        <a href="${pageContext.request.contextPath}/cart.do?gid=${goods.gid}">
                                                            <img src="${pageContext.request.contextPath}/images/buy.gif" width="91" height="27" border="0" style="margin-bottom: -8px" /></a>
                                                    </td>
                                                </tr>
                                            </table>
                                           </c:forEach>
                                            <div class="pagination">
                                                <ul>
                                                	<c:if test="${pageinfo.isfirstpage }">
                                                		<li class="disablepage"><< 上一页 </li>
                                                	</c:if>
                                               		 <c:if test="${!pageinfo.isfirstpage }">
                                                   		 <li><a href="${pageContext.request.contextPath }/list.do?cid=${cid}&pageindex=${pageinfo.pageindex-1}"><< 上一页 </a></li>
                                                    </c:if>
                                                    	<c:set var="startpage" value="${pageinfo.pageindex-5 }"/>
                                                    	<c:set var="endpage" value="${startpage+9 }"/>
                                                    	<c:if test="${startpage<=0 }">
                                                    		<c:set var="startpage" value="1"/>
                                                    		<c:set var="endpage" value="${startpage+9 }"/>
                                                    	</c:if>
                                                    	<c:if test="${endpage>pageinfo.totalpages }">
                                                    		<c:set var="startpage" value="${endpage-9 }"/>
                                                    		<c:set var="endpage" value="${pageinfo.totalpages }"/>
                                                    	</c:if>
	                                                    <c:forEach var="i" begin="${startpage}" end="${endpage }">
	                                                    	<c:if test="${pageinfo.pageindex==i }">
	                                                    		<li class="currentpage">${i }</li>
	                                                    	</c:if>
	                                                    	<c:if test="${pageinfo.pageindex!=i }">
	                                                    		<li><a href="${pageContext.request.contextPath }/list.do?cid=${cid}&pageindex=${i}">${i }</a></li>
	                                                    	</c:if>
	                                                    
	                                                    </c:forEach>
	                                                   
                                                    <c:if test="${pageinfo.islastpage }">
                                                		<li class="disablepage">下一页>> </li>
                                                	</c:if>
                                                	<c:if test="${!pageinfo.islastpage }">
                                                    	<li class="nextpage"><a href="${pageContext.request.contextPath }/list.do?cid=${cid}&pageindex=${pageinfo.pageindex+1}">下一页 >></a></li>
                                                    </c:if>
                                                </ul>
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
    <div id="divfoot">
  <table width="100%" border="0" cellspacing="0">
    <tr>
      <td rowspan="2" style="width:10%"><img src="images/bottomlogo.gif" width="195" height="50" style="margin-left:175px"/></td>
      <td style="padding-top:5px; padding-left:50px"><a href="#"><font color="#747556"><b>CONTACT US</b></font></a></td>
    </tr>
    <tr>
      <td style="padding-left:50px"><font color="#CCCCCC"><b>COPYRIGHT 2008 &copy; eShop All Rights RESERVED.</b></font></td>
    </tr>
  </table>
</div>
    
  
</body>
</html>
    