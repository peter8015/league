<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="commonTag.jsp"%>
<%@ include file="commonMeta.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
<!--
body { font-family:"宋体"; font-size:12px; margin:0; padding:0;}
.wrapper{ width:400px; margin:0 auto;}
.top{ background: url(${ctx}/images/common/save/tc.gif) repeat-x; height:26px;}
.topl{ background:url(${ctx}/images/common/save/tl.gif) no-repeat; height:26px; padding-left:31px; float:left; font-weight:bold; line-height:26px;}
.topr{ background:url(${ctx}/images/common/save/tr.gif) no-repeat right center; height:26px; padding-right:6px;float:right;}
.center{ width:360px; background:url(${ctx}/images/common/save/cen.gif) repeat-y; padding:40px 20px;}
.bottom{ height:6px; background:url(${ctx}/images/common/save/bc.gif) repeat-x;}
.bottoml{ width:6px; height:6px; float:left; background:url(${ctx}/images/common/save/bl.gif) no-repeat;}
.bottomr{ width:6px; height:6px; float:right; background:url(${ctx}/images/common/save/br.gif) no-repeat;}
.center span{ background:url(${ctx}/images/common/save/n.gif) no-repeat; padding:10px 0 10px 35px; display:block;}
img{ border:0;}
-->
</style>
<script type="text/javascript" language="javascript" src="${ctx}/js/common/win.js"></script>
<script type="text/javascript">
	function closewindow(){	
           parent.closeLayer();
	}
	function clock(){
		i = i -1;
		if(i > 0)
			setTimeout("clock();",1000);
		else
			closewindow();
	}
	
	var i = 2;
	clock();

</script>
</head>

<body>

<div class="wrapper">

<div class="top">
<div class="topl">信息确认</div>
<div class="topr"><a href="#"><img src="${ctx}/images/common/save/tn.gif" /></a></div>
</div>

<div class="center">
<span>操作失败</span>
</div>

<div class="bottom">
<div class="bottoml"></div>
<div class="bottomr"></div>
</div>

</div>



</body>
</html>
