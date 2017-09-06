<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="gb2312">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta content="all" name="robots"/>
<meta name="author" content="Fisher" />
<meta name="Copyright" content="Copyright 2007-2008, 版权所有 www.reefdesign.cn" />
<meta name="description" content="reefdesign" />
<meta name="keywords" content="reefdesign" />
<title>电子书城</title>
<link rel="shortcut icon" href="favicon.ico" >
<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />
</head>

<body class="main">

<%@include file="header.jsp"%>

<div id="divpagecontent">

      <div style="text-align:right; margin:5px 10px 5px 0px"><a href="${pageContext.request.contextPath}/news.do">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/list.do?cid=${cate.cid}">&nbsp;${cate.cname }</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;${goods.gtitle }</div>
        <table cellspacing="0" class="infocontent">
        <tr>
          <td><img src="${pageContext.request.contextPath}/images/ad/page_ad.jpg" width="645" height="84" />
		  
		    <table width="100%%" border="0" cellspacing="0">
              <tr>
                <td width="30%">
				
				<div class="divbookcover"><p><img src="${pageContext.request.contextPath}/images/bookcover/bookcover.jpg" /></p></div>
				
				<div style="text-align:center; margin-top:25px"><a href="cart.html"><img src="${pageContext.request.contextPath}/images/buybutton.gif" border="0" /></a></div>
				<td style="padding:20px 5px 5px 5px"><img src="images/miniicon3.gif" width="16" height="13" /><font class="bookname">&nbsp;&nbsp;${goods.gtitle }</font><hr/>作者：${goods.gauthor } 著<hr/>售价：<font color="#FF0000">￥${goods.gsaleprice }</font>&nbsp;&nbsp;&nbsp;&nbsp;原价：<s>￥${goods.ginprice }</s><hr/>出版社：${goods.publisher.pname }
<hr/><p><b>内容简介：</b></p>　　${goods.gdesc }
</td>
              </tr>
            </table>		  </td>
        </tr>
      </table>
      
      </td>
    </tr>
  </table>
</div>



<div id="divfoot">
  <table width="100%" border="0" cellspacing="0">
    <tr>
      <td rowspan="2" style="width:10%"><img src="${pageContext.request.contextPath}/images/bottomlogo.gif" width="195" height="50" style="margin-left:175px"/></td>
      <td style="padding-top:5px; padding-left:50px"><a href="#"><font color="#747556"><b>CONTACT US</b></font></a></td>
    </tr>
    <tr>
      <td style="padding-left:50px"><font color="#CCCCCC"><b>COPYRIGHT 2008 &copy; eShop All Rights RESERVED.</b></font></td>
    </tr>
  </table>
</div>


</body>
</html>
