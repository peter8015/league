<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/commons/commonTag.jsp"%>
<%@ include file="/commons/commonMeta.jsp"%>
<%@ include file="/commons/commonCiteList1.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${ctx}/pages/leaguecss/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/pages/leaguecss/bootstrap/css/bootstrap-responsive.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${ctx}/pages/leaguecss/bootstrap/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/pages/leaguecss/css/igo_global.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/pages/leaguecss/css/miaov_style.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/pages/leaguecss/css/bootcss_re.css" />
<link rel="shortcut icon" type="image/x-icon" href="${ctx}/pages/leaguecss/images/igo.ico" />
<script type="text/javascript" src="${ctx}/pages/leaguecss/js/person_D.js"></script>
<title>项目列表</title>
</head>
<body>
<%@ include file="../search/commonPageHead.jsp"%>
<div style="margin-top:50px;"></div>
<div class="logo_menu">
	<div class="container">
    	<a href="#" class="logo"><img src="${ctx}/pages/leaguecss/images/igo/logo.png" /></a>
        <a href="#" class="ad"><img src="${ctx}/pages/leaguecss/images/igo/ad.jpg" /></a>
    </div>
    <div class="clr10"></div>
    <div class="menu">
    	<div class="container">
        	<a href="#">鹰眼</a>
            <a href="#">故事树</a>
            <a href="#">版本树</a>
            <a href="#">冲刺计划</a>
            <a href="#">冲刺墙</a>
            <a href="#">任务墙</a>
            <a href="#">缺陷墙</a>
            <a href="#">故事集</a>
            <a href="#">故事集</a>
        </div>
    </div>
</div>
<div><img src="${ctx}/pages/leaguecss/images/igo/img02.jpg" /></div>
<div style="height:120px;"></div>
</body>
</html>