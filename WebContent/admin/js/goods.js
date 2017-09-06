var sign;
$(function(){
	$('#cate').combobox({
		url:'/webproject/catecontroller.do',
		valueField:'cid',
		textField:'cname',
		onSelect:function(data){
			loadGoods(data.cid,0);
			sign=data.cid
		},
		onLoadSuccess:function(){
			var datas=$(this).combobox('getData');
			if(datas.length>0){
				$(this).combobox('setValue',datas[0].cid);
				var cid=$('#cate').combobox('getValue');
				sign=cid;
				loadGoods(cid,0);
			}
		}
	});
	$('#dialog').dialog({
	    closed: true, 
	    width: 500,    
	    height: 300,
	    iconCls:'icon-add',
	    resizable:true,
	    modal:true,
	    collapsible:true,
	});
	
})
function loadGoods(cid,sign){
	$('#tb').datagrid({
		url:'/webproject/goodscontroller.do?type=list',
		title:'商品信息',
		queryParams:{cid:cid,sign:sign},
		iconCls:'icon-ok',
		collapsible:true,
		pagination:true,
		pageSize:10,
		rownumbers:true,
		striped:true,
		singleSelect:true,
		pageList:[10,20,30,40],
		toolbar:[{
			text:'编辑',iconCls:'icon-edit',handler:function(){
				var row = $('#tb').datagrid('getSelected');
				if(row==null)
				{
					$.messager.alert('修改操作','请选择要修改的行','info');
					
				}
				if(row!=null)
				{
					$('#dialog').dialog({
						title: '修改操作',    
					    closed: false, 
					    buttons:[{
							text:'保存',
							iconCls:'icon-save',
							handler:function(){
							var isValid = $('f1').form('validate');
							if(isValid){
								$.ajax({
									type:'post',
									data:$('#f1').serialize(),
									url:'/webproject/goodscontroller.do?type=edit',
									success:function(data){
										if(data=="1"){
											$.messager.alert('修改信息','修改成功','info');
											$('#f1').form('clear');
											$('#dialog').dialog('close');
											$('#tab').datagrid('reload');
										}else{
											$.messager.alert('修改信息','修改失败','info');
										}
									}
								})
							}else{
								$.messager.alert('修改信息','表单验证失败','info');
							}}
						},{
							text:'关闭',
							iconCls:'icon-cancel',
							handler:function(){}
						}],
					   
					});
					$('#gid').textbox('setValue',row.gid );
					$('#gid').textbox('readonly',true );
					$('#cid').textbox('setValue',row.cid );
					$('#pid').textbox('setValue',row.pid);
					$('#gtitle').textbox('setValue',row.gtitle);
					$('#gauthor').textbox('setValue',row.gauthor);
					$('#gsaleprice').textbox('setValue',row.gsaleprice);
					$('#ginprice').textbox('setValue',row.ginprice);
					$('#gimg').textbox('setValue',row.gimg);
					$('#gclick').textbox('setValue',row.gclick);
					
				}
				
				
			}
		},'-',{
			text:'删除',iconCls:'icon-remove',handler:function(){
				//$.messager.alert('删除','实现删除功能','info');
				var row=$('#tb').datagrid('getChecked');
				if(row==""){
					$.messager.alert('删除提示','请选择删除行','info');
				}else{
					console.log(row);
					$.messager.confirm('确认删除', '您确定要删除吗？', function(r){
						if (r){
							for(var i=0;i<row.length;i++){
							$.ajax({
								type:'post',
								url:'/webproject/goodscontroller.do',
								data:{type:'remove',gid:row[i].gid},
								success:function(data){
									if(data=="1")
									{
										$.messager.alert('删除提示','删除成功','info');
										$('#tb').datagrid('reload');
									}else{
										$.messager.alert('删除提示','删除失败','info');
									}$('#tb').datagrid('reload');
								}
							});
						}
						}else{
							$.messager.alert('删除提示','不能进行删除','info');
						}
					});
				}$('#tb').datagrid('reload');
			}
			
		},'-',{
			text:'添加',iconCls:'icon-add',handler:function(){
				$('#dialog').dialog({
					title: '用户信息',       
				    closed: false,       
				    buttons:[{
						text:'保存',
						iconCls:'icon-save',
						handler:function(){
						var isValid = $('f1').form('validate');
						if(isValid){
							$.ajax({
								type:'post',
								data:$('#f1').serialize(),
								url:'/webproject/goodscontroller.do?type=add',
								success:function(data){
									if(data=="1"){
										$.messager.alert('添加信息','添加成功','info');
										$('#f1').form('clear');
										$('#dialog').dialog('close');
										$('#tb').datagrid('reload');
									}else{
										$.messager.alert('添加信息','添加失败','info');
									}
								}
							})
						}else{
							$.messager.alert('修改信息','表单验证失败','info');
						}}
					},{
						text:'关闭',
						iconCls:'icon-cancel',
						handler:function(){}
					}],
				});
			}
		}],
		columns:[[{
			field:'chk',checkbox:true
		},{
			field:'gid',title:'商品编号'
		},{
			field:'gtitle',title:'标题'
		},{
			field:'gauthor',title:'作者'
		},{
			field:'gsaleprice',title:'现价'
		},{
			field:'ginprice',title:'原价'
		},{
			field:'gimg',title:'图片'
		},{
			field:'gclick',title:'点击量'
		},{
			field:'cid',title:'类别编号'
		},{
			field:'pid',title:'出版社编号'
		}]]
	})
}