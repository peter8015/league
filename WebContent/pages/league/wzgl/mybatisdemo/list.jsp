<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../../../commons/commonTag.jsp"%>
<%@ include file="../../../../commons/commonMeta.jsp"%>
<%@ include file="../../../../commons/commonCiteListSyn.jsp"%>
<html>
<head>
<script type="text/javascript" language="javascript"
	src="${ctx}/js/common/dwr-util.js"></script>
<script type="text/javascript" language="javascript"
	src="${ctx}/js/common/mainsyn.js"></script>
<script type="text/javascript">  

$(function() {
	  $("#operatetime_begin").ligerDateEditor();
	  $("#operatetime_end").ligerDateEditor();
	$(':button[name=search]').click(function(){
		if($('#operatetime_begin').val() == '' && $('#operatetime_end').val() ==''){
			//alert('请选择开始时间或者结束时间');
			//return;
			}
			var formJson = dwr.util.getValues('frm');
			 //showJson(formJson);
			 //alert($.param(formJson));
			//调用将查询传入
			setCondition(formJson);
			
		});

	
	//添加回车事件
	$(':text').keydown(function(event) {
		switch (event.keyCode) {
		case 13:
			$('form').has(this).find(':button[name=search]').trigger('click');
			break;
		}
	});
});

function checkNum(str)
{  
   var letters="1234567890";
   for(i=0;i<str.length;i++)
   {
      c = str.charAt(i);       
      if(letters.indexOf(c) ==-1)
      {         
        return false; 
      } 
   }
   return true;
}

function ifTo(number){
	var formJson = dwr.util.getValues('frm');
	//alert($.param(formJson));
	if(number == null){
		number=$("#page").val();
		if(number==null||number==""){
			alert("请输入页码");
			return false;
		}
		if(!checkNum(number)||number==0)
		{
			alert("请输入正整数。");
			$("#page").val("");
			return  false;
		}
		if(number>${pageNum}){
			alert("页码数不能大于总页数。");
			$("#page").val("");
			return  false;
		}
	}
	window.location.href="${ctx}//mybatis/notice/NoticeContorller/FlaxiGridDataSyn?rp=10&page="+number+"&"+$.param(formJson);
}

//从子页面获得查询条件的json对象转换成查询条件,查询完之后刷新表格
function setCondition(json) {
	var number=$("#page").val();
	if(number=="") 
		number =1;
	//alert("${ctx}/mybatis/notice/NoticeContorller/FlaxiGridDataSyn.do?rp=10&page="+number+"&"+$.param(json));
	window.location.href="${ctx}/mybatis/notice/NoticeContorller/FlaxiGridDataSyn.do?rp=10&page="+number+"&"+$.param(json);

}


function view(url) {
var ids=getID("listTable");
	
	if((ids==-1) || (ids==-2))
		{
		 $.ligerDialog.question('请选择一条要查看的数据!');
		 return;
		}
		var url =url+"?ids="+ids;  
		 winObj =  $.ligerDialog.open({ url: url, height: 450, width: 800,  isResize: true});
	 
}  


function add(url) {
	  winObj =  $.ligerDialog.open({ url: url, height: 450, width: 800,  isResize: true});
}


function del(url){ 
	  var  ids =  getIdList("listTable");
	if(ids==null){
		 $.ligerDialog.question('请选择要删除的数据!');
	}else{
		$.ligerDialog.confirm('您确认是否删除？', function (yes)
                {
                    if(yes){
                    	 okfun(url);
                    }
                });		 
	}
}

function okfun(url){
	
    var  idss =  getIdList("listTable");
    var ids=idss.substring(0,idss.length-1);
    $.ajax({  
		url:url,  
		type:'post',
		data:'checkbox='+ids,  
		async: false ,
		success: function(){        
  	        $.ligerDialog.success("删除成功");
  	  	window.location.reload();
		},
		error:function(){
			 $.ligerDialog.error("删除失败");
				window.location.reload();
			} 
	 });
    return true;
} 

function update(url){ 
	var ids=getID("listTable");
	
	if((ids==-1) || (ids==-2))
		{
		 $.ligerDialog.question('请选择一条要编辑的数据!');
		 return;
		}
   	var url = url+"?ids=" + ids;
    winObj =  $.ligerDialog.open({ url: url, height: 450, width: 800,  isResize: true});
  	}
</script>
</head>
<body>
	<div style="padding-top: 1px;">
		<!-- 组件布局  START-->
		<!------------------------------------------------------------列表查询区域----------------------------------------------------------------->
		<fieldset>
			<legend>
				<b><img src="${ctx}/images/common/index/1.gif"></img><span
					class="spanTitle">报文查询</span></b>
			</legend>
			<form id="frm" name="frm" action="" method="post">
				<table border="0px" cellspacing="0px" cellpadding="0px" width="100%"
					align="center">
					<tr>
						<td width="100%">
							<table width="100%" align="center" border="0" bordercolor="black">
								<tr>
									<td align="right">标题：</td>
									<td><input id="bankAppidCode" name="djgzName"
										style="width: 130px; background-color: #E0E0E0;"
										value="${ssBankMsgTempvo.djgzName}" type="text" />
									</td>
									<td align="right">内容：</td>
									<td><input id="sendMsg" name="djgzContent"
										style="width: 130px; background-color: #E0E0E0;"
										value="${ssBankMsgTempvo.djgzContent}" type="text" />
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td colspan="4" align="center"><br>
							<button type="button" name="search" class="button">
								<img src="${ctx}/images/common/button/search.png" />查&nbsp;&nbsp;询
							</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="button" name="reset1" class="button"
								onclick="document.getElementById('frm').reset();">
								<img src="${ctx}/images/common/button/reset.png" />重&nbsp;&nbsp;置
							</button> <br></td>
					</tr>
				</table>
			</form>
		</fieldset>
		<!-- 组件布局  START-->
		<!------------------------------------------------------------主列表----------------------------------------------------------------->
		<table border="0px" cellspacing="0px" cellpadding="0px" height="26px"
			width="100%" background="${ctx}/images/common/index/11.gif">
			<tr>
				<td valign="middle" align="left" width="30px">&nbsp;&nbsp;<img
					src="${ctx}/images/common/index/1.gif"></img></td>
				<td valign="middle"><span class="spanTitle">&nbsp;&nbsp;报文列表</span></td>
				<td valign="middle">
					<div class="menu" id="commonButton">
						<table align="right">
							<tr>
								<td><a href="#" onclick="add('addinputsyn.do')">添&nbsp;&nbsp;
										加</a></td>
								<td><a href="#" onclick="update('updateinput.do')">编&nbsp;&nbsp;
										辑</a></td>
								<td><a href="#" onclick="del('delete.do')">删&nbsp;&nbsp;
										除</a></td>
								<td><a href="#" onclick="view('selectinput.do')">查&nbsp;&nbsp; 看</a></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>

	</div>

	<!-- 组件布局  START-->
	<div>
		<form action="/mybatis/notice/NoticeContorller/FlaxiGridDataSyn"
			method="post">
			<table id="listTable" class="highlightable-table" width="100%">
				<thead>
					<tr class="table-top">
						<th><input type="checkbox" id="chkAll"
							onclick="checkBoxAll('listTable','chkAll');"></th>
						<th>标题</th>
						<th>类型</th>
						<th>发送时间</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${listSsBankMsgTemp}" var="SsBankMsg">
						<tr class="direct_member activated">
							<td class='trSelected'><input type="checkbox"
								id="${SsBankMsg.id}" value="${SsBankMsg.id}"></td>
							<td class='user-name'>${SsBankMsg.djgzName}</td>
							<td class='user-name'>${SsBankMsg.djgzContent}</td>
							<td class='user-name'>${SsBankMsg.djgzTime}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</form>

		<form action="" method="get" name="myform">
			<table align="center" height="30">
				<tr>
					<td><c:if test="${page>1}">
							<a href="#" onclick="return ifTo(${page-1});"> 上一页&nbsp; </a>
						</c:if></td>
					<td><c:if test="${page<pageNum}">
							<a href="#" onclick="return ifTo(${page+1});"> 下一页&nbsp; </a>
						</c:if></td>
					<td>跳到第 <input size="5" name="page" id="page"
						onkeypress="if(event.keyCode==13){return false; }" />页 <input
						type="button" class="button" value="OK" onclick="return ifTo();">&nbsp;
					</td>
					<td>当前第${page}页&nbsp;&nbsp;${(page-1)*5+1} -
						${page*5>totalCount?totalCount:page*5} of ${totalCount}
						&nbsp;&nbsp;</td>
					<td>总${pageNum}页</td>
				</tr>
			</table>
		</form>
	</div>
	<!----------------------------------------------------------------end------------------------------------------------------------->
</body>
</html>