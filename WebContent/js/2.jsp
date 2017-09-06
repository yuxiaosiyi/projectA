<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#txtSerach').on('input',function(){
	/* 	var xmlhttp=$.ajax();
		console.log(xmlhttp); */
		$.ajax({
			data:{key:$(this).val()},
			dataType:'json',
			type:'post',
			url:'/webproject/search.do',
			success:function(data){//第一个参数：服务器返回数据；第二个：jquery ajax状态值； 第三个：返回http。。。。对象；没有第四个
				if(data!='undefined'){
					console.log(data[0].key);
				}
			}
		})
	})
})
</script>
<title>Insert title here</title>
</head>
<body>
	<input type="text" id="txtSerach" list="da" ><br>
	<datalist id="ds"></datalist>
</body>
</html>