<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../../common/commonTag.jsp"%>
<%@ include file="../../../common/commonMeta.jsp"%>
<%@ include file="../../../common/commonCiteList1.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css" href="${ctx}/pages/leaguecss/css/global.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/pages/leaguecss/css/igo.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/pages/leaguecss/css/team_member.css" />

<link rel="shortcut icon" type="image/x-icon" href="${ctx}/pages/leaguecss/images/igo.ico" />
<style type="text/css">
body{ background:url(${ctx}/pages/leaguecss/images/menu_bg2.jpg) repeat-x #f8f8f8;}
</style>
<title>搜索结果</title>	
<script type="text/javascript" language="javascript" src="${ctx}/js/common/dwr-util.js"></script>
<script type="text/javascript" language="javascript" src="${ctx}/js/common/win1.js"></script>
<script type="text/javascript">  
	function cancel(){
		window.history.back();
	}
	
	function deleteGroup(grpId){
		window.location.href='<%=request.getContextPath() %>/myrecord/GroupContorller/deleteGroup.do?groupBo.id='+grpId;
	}
	
	function commit()
	{
		var groupName = $("#groupName").val();
		if(groupName != null && groupName!=""){
			window.location.href='<%=request.getContextPath() %>/myrecord/GroupContorller/addGroup.do?groupBo.name='+groupName;
		}
		return false;
	}
</script>
</head>
<body  class="bodys">	

<div>  
<%@ include file="topMainIGo.jsp"%> 
<script type="text/javascript">  
selectFirstTitle("project");
</script>
<div class="w1200">
	<div class="clr10"></div>

	<div class="right_igo">
    	<div class="main_inner"> 
              
			<div><a href="#" target="blank" class="page-help-at-action-bar">Help</a> <h1>搜索结果：</h1></div> 
		    <div class='clear-both'><!-- Clear floats --></div> 
		    <div class="content-margin-adjust">
		 		 
		
		<div class='clear-both'><!-- Clear floats --></div>
		<table id='users' class="highlightable-table" width="100%"> 
		  <thead> 
		    <tr class="table-top">
				<th>项目名称</th> 
		    </tr> 
		  </thead> 
		 
		  <tbody> 
		  <s:iterator value="projects">
		    <tr class="direct_member activated" >
		        <td><a class="" href="#">${name}</a></td>  
		    </tr>
		    </s:iterator>
		  </tbody> 
		</table> 
		</div>   
		</div>
		</div>
  </div>
</div>


   
</body>
</html>