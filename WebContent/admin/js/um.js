$(function(){
	$('#btnsave').on('click',function(){
		var isValid = $('f1').form('validate');
		if(isValid){
			$.ajax({
				type:'post',
				data:$('#f1').serialize(),
				url:'/webproject/usercontroller.do?type=add',
				success:function(data){
					if(data=="1"){
						$.messager.alert('添加信息','添加成功','info');
						$('#f1').form('clear');
						$('#dialog').dialog('close');
						$('#tab').datagrid('reload');
					}else{
						$.messager.alert('添加信息','添加失败','info');
					}
				}
			})
		}else{
			$.messager.alert('添加信息','表单验证失败','info');
		}
	})
	$('#btnsavet').on('click',function(){
		var isValid = $('f2').form('validate');
		if(isValid){
			$.ajax({
				type:'post',
				data:$('#f2').serialize(),
				url:'/webproject/usercontroller.do?type=edit',
				success:function(data){
					if(data=="1"){
						$.messager.alert('修改信息','修改成功','info');
						$('#f2').form('clear');
						$('#dialogt').dialog('close');
						$('#tab').datagrid('reload');
					}else{
						$.messager.alert('修改信息','修改失败','info');
					}
				}
			})
		}else{
			$.messager.alert('修改信息','表单验证失败','info');
		}
	})
	$('#dialog').dialog({
		title: '用户信息',    
	    width: 500,    
	    height: 300,    
	    closed: true,       
	    modal: true, 
	    iconCls:'icon-add',
	    resizable:true,
	    modal:true,
	    collapsible:true,
	    buttons:$("#footer"),
	   
	});
	$('#dialogt').dialog({
		title: '用户信息',    
	    width: 500,    
	    height: 300,    
	    closed: true,       
	    modal: true, 
	    iconCls:'icon-edit',
	    resizable:true,
	    modal:true,
	    collapsible:true,
	    buttons:$("#footert"),
	   
	});
	$('#tab').datagrid({
		url:'/webproject/usercontroller.do',
		title:'用户信息',
		iconCls:'icon-ok',
		collapsible:true,
		rownumber:true,
		singleSelect:true,
		queryParams:{type:'list'},
		toolbar:[{
			text:'编辑',iconCls:'icon-edit',handler:function(){
				var row = $('#tab').datagrid('getSelected');
				console.log(row);
				if(row==null)
				{
					$.messager.alert('修改操作','请选择要修改的行','info');
					
				}
				if(row!=null)
				{
					$('#dialogt').dialog('open');
					$('#userid').textbox('setValue',row.userid );
					$('#userid').textbox('readonly',true );
					$('#uemailt').textbox('setValue',row.uemail );
					$('#uemailt').textbox('readonly',true );
					$('#uloginidt').textbox('setValue',row.uloginid );
					$('#uloginidt').textbox('readonly',true );
					$('#upasswordt').textbox('setValue',row.upassword);
					$('#utelt').textbox('setValue',row.utel);
					$('#uaddresst').textbox('setValue',row.uaddress);
					$('#usext').textbox('setValue',row.usex);
				}
			}
		},'-',{
			text:'删除',iconCls:'icon-remove',handler:function(){
				//$.messager.alert('删除','实现删除功能','info');
				var row=$('#tab').datagrid('getChecked');
				if(row==""){
					$.messager.alert('删除提示','请选择删除行','info');
				}else{
					console.log(row);
					$.messager.confirm('确认删除', '您确定要删除吗？', function(r){
						if (r){
							for(var i=0;i<row.length;i++){
							$.ajax({
								type:'post',
								url:'/webproject/usercontroller.do',
								data:{type:'remove',userid:row[i].userid},
								success:function(data){
									if(data=="1")
									{
										$.messager.alert('删除提示','删除成功','info');
										$('#tab').datagrid('reload');
									}else{
										$.messager.alert('删除提示','删除失败','info');
									}$('#tab').datagrid('reload');
								}
							});
						}
						}else{
							$.messager.alert('删除提示','不能进行删除','info');
						}
					});
				}$('#tab').datagrid('reload');
			}
		},'-',{
			text:'添加',iconCls:'icon-add',handler:function(){
				$('#dialog').dialog('open');
			}
		}],
		columns:[[{
			field:'chk',checkbox:true
		},{
			field:'userid',title:'编号'
		},{
			field:'uemail',title:'邮箱'
		},{
			field:'uloginid',title:'账号'
		},{
			field:'upassword',title:'密码'
		},{
			field:'utel',title:'电话'
		},{
			field:'usex',title:'性别'
		},{
			field:'ustateid',title:'状态编号'
		},{
			field:'uroleid',title:'角色编号'
		}]]
	})
})