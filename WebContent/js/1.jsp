<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#uname').on('input',function(){
		/* 	var xmlhttp=$.ajax();
			console.log(xmlhttp); */
			$.ajax({
				data:{'uname':$(this).val()},
				dataType:'text',
				type:'GET',
				url:'/webproject/checkname.do',
				success:function(a,b,c,d){//第一个参数：服务器返回数据；第二个：jquery ajax状态值； 第三个：返回http。。。。对象；没有第四个
					if(a=="1"){
						$('span:first').html('no');
					}
					else if(a=="0"){
						$('span:first').html('yes');
					}
				}
			})
		})
	})
</script>
<title>Insert title here</title>
</head>
<body>
	账号：<input type="text" id="uname"/><span></span></br>
	邮箱；<input type="text" id="uemail"/></br>
</body>
</html>