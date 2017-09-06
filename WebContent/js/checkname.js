window.onload=function(){
	

		document.querySelector('#img').onclick=function(){
			this.src='${pageContext.request.contextPath }/codeServlet.do?id='+Math.random();
		}
	

	
	
	document.querySelector('#check_use').onclick=function(){
		alert("1");
		var uname=document.querySelector('#uname').value;
		var xmlhttp=new XMLHttpRequest();
		xmlhttp.open("GET", "checkname.do?uname="+uname,true);
		xmlhttp.send(null);
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4){
				if(xmlhttp.status==200){
					var data=xmlhttp.responseText;
					var sp=document.querySelector('#sp');
					if(data=="1"){
						sp.innerHTML='no';
						sp.style.color='red';
					}
					else{
						sp.innerHTML='yes';
						sp.style.color='green';
					}
				}
			}
		}
	}
}