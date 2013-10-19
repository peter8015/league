<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="commonTag.jsp"%>
<%@ include file="commonMeta.jsp"%>

<html>
<head>
<title>成功页面</title>
 
<script> 
	//parent.winObj.hide(); 
	
	if(${empty message == false}){
		parent.window.success('${message}');
	}else{
		parent.window.success('');
	}
	parent.window.ifTo('1');
</script>
</head>

<body>
保存成功！  
</body>
</html>