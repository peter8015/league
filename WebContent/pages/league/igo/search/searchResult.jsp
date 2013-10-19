<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="/commons/commonTag.jsp"%>
<%@ include file="/commons/commonMeta.jsp"%>
<%@ include file="/commons/commonCiteList1.jsp"%>
<link rel="Shortcut Icon" href="<%=request.getContextPath()%>/pages/leaguecss/images/igo.ico">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pages/leaguecss/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pages/leaguecss/bootstrap/css/bootstrap-responsive.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-1.9.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/pages/leaguecss/bootstrap/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pages/leaguecss/css/igo_global.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pages/leaguecss/css/miaov_style.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/pages/leaguecss/js/person_D.js"></script>
<title>搜索结果</title>
<script>
	$(function() {
		// 隐藏页首搜索框
		$("#dropdownli").hide();
		$("#dropdownli").next().hide();
	})
</script>
</head>

<body>
<%@ include file="/commons/commonHead.jsp"%>
<div style="margin-top:60px;"></div>
<div class="container" >
    <div class="search_condition">
    	<div class="span5 fl marg_L0"><a href="#" class="logo"><img src="<%=request.getContextPath()%>/pages/leaguecss/images/igologo.png" /></a><a href="#" class="on">搜项目</a><a href="#">搜团队</a><a href="#">搜人员</a></div>
        <div class="clr"></div>
        <input type="text" class="span5 marg_t05" placeholder="澳门" /><button type="submit" class=" btn btn-warning marg_t05 marg_l03">走你</button>
    </div>
    <div class="clr10"></div>
	<div class="fl search_result01">
		 <c:forEach items="${resultList}" var="bo">
		    <table cellpadding="0" cellspacing="0" class="table-condensed">
	        	<tr><th><a href="#">Story Tree</a></th></tr>
	        	<tr><td class="des">卡片名称:${bo.cardName}, 卡片类型:${bo.cardType}</td></tr>
	            <tr><td class="pro_name"><span>所属项目：</span><a href="#">${bo.projectName}>></a></td></tr>
	        </table>
		  </c:forEach>
		  <c:forEach items="${projectList}" var="pro">
		    <table cellpadding="0" cellspacing="0" class="table-condensed">
	        	<tr><th><a href="#">Story Tree</a></th></tr>
	        	<tr><td class="des">名称:${pro.name}</td></tr>
	            <tr><td class="pro_name"><span>所属项目：</span><a href="#">${pro.name}>></a></td></tr>
	        </table>
		  </c:forEach> 
        <table cellpadding="0" cellspacing="0" class="table-condensed">
        	<tr><th><a href="#">Story Tree</a></th></tr>
        	<tr><td class="des">有关此条详细<a href="#">内容</a>的描述有关此条详细内容的描述有关此条详细内容的描述有关此条详细内容的描述有关此条详细内容的描述有关此条详细内容的描述有关此条详细内容的描述有关此条详细内容的描述有关此条详细内容的描述有关此条详细内容的描述有关此条详细内容的描述</td></tr>
            <tr><td class="pro_name"><span>所属项目：</span><a href="#">项目名称>></a></td></tr>
        </table>
        <table cellpadding="0" cellspacing="0" class="table-condensed">
        	<tr><th><a href="#">Release Tree</a></th></tr>
        	<tr><td class="des">有关此条详细内容的描容的描述有关此条详细内容的描述有关此条详细内容的描述...</td></tr>
            <tr><td class="pro_name"><span>所属项目：</span><a href="#">项目名称>></a></td></tr>
        </table>
        <table cellpadding="0" cellspacing="0" class="table-condensed">
        	<tr><th><a href="#">搜索的名称显示</a></th></tr>
        	<tr><td class="des">有关此条详细内容的描述有关此条详细内容的描述有关此条详细内容的描述有关此条详细内容的关此条详细内容的描述有关此条详细内容的描述</td></tr>
            <tr><td class="pro_name"><span>所属项目：</span><a href="#">项目名称>></a></td></tr>
        </table>
        <table cellpadding="0" cellspacing="0" class="table-condensed">
        	<tr><th><a href="#">搜索的名称显示</a></th></tr>
        	<tr><td class="des">有关此条详细内容的描述有关此条描述有关此条详细内容的描述有关此条详细内容的描述</td></tr>
            <tr><td class="pro_name"><span>所属项目：</span><a href="#">项目名称>></a></td></tr>
        </table>
        <table cellpadding="0" cellspacing="0" class="table-condensed">
        	<tr><th><a href="#">搜索的名称显示</a></th></tr>
        	<tr><td class="des">有关此条详细内容的描细内容的描述</td></tr>
            <tr><td class="pro_name"><span>所属项目：</span><a href="#">项目名称>></a></td></tr>
        </table>
        <div class="page fl">
                	<a href="#" class="btn marg_l03">上一页</a><a href="#" class="btn marg_l03">1</a><a href="#" class="btn btn-warning marg_l03">2</a><a href="#" class="btn marg_l03">3</a><a href="#" class="btn marg_l03">4</a><a href="#" class="btn marg_l03">下一页</a>
                </div>
    </div>
    <div class="fr search_about">
    	<div class="sidenav affix">
        <div class="search_about_C">
    	<div class="search_a_T">
        	<span>相关搜索</span>
        </div>
        <div class="search_a_C" >
        	<a class="rank02" href="#">Release Tree</a>
            <a class="rank01" href="#">css</a>
            <a class="rank03" href="#">Story Tree</a>
            <a class="rank04" href="#">Backlog</a>
            <a class="rank05" href="#">css</a>
            <a class="rank06" href="#">Sprint Backlog</a>
            <a class="rank02" href="#">Release Tree</a>
            <a class="rank01" href="#">css</a>
            <a class="rank03" href="#">Story Tree</a>
            <a class="rank04" href="#">Backlog</a>
            <a class="rank05" href="#">css</a>
            <a class="rank06" href="#">Sprint Backlog</a>
        </div>
        </div>
    	</div>
    </div>
    <div class="clr10"></div>
    <div class="modal-footer"></div>
</div>
</body>
</html>
