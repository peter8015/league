<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="org.springframework.security.ui.AbstractProcessingFilter" %>
<%@ page import="org.springframework.security.ui.webapp.AuthenticationProcessingFilter" %>
<%@ page import="org.springframework.security.AuthenticationException" %>
<%@ include file="/commons/commonTag.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>java基础开发框架V1.0</title>
<link href="${ctx}/css/common/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"   src="${ctx}/js/common/jquery-ui/jquery-1.4.2.js"></script>
<script src="${ctx}/js/common/validate/jquery.validate.js" type="text/javascript"></script>
<script src="${ctx}/js/common/validate/messages_cn.js" type="text/javascript"></script>

<style type="text/css">

	.error{
		color: red
	}
</style>


<script>
	$(document).ready(function() {
		$("#j_username").focus();
		$("#loginForm").validate({
				messages: {
					j_username: {
						required: '用户名不能为空'
					},
					j_password: {
						required: '密码不能为空'
					}
				}		
	});
		$("#sub").click(function(){
				if($("#loginForm").valid()){
					$("#loginForm").submit();
					}
			});
		
		$("#res").click(function(){
			$("#loginForm").get(0).reset();
		});

		$("#changeImage").click(function(){
			//$('#captchaImg').html('<img src="${ctx}/security/jcaptcha.jpg?' + Math.round(Math.random() * 100000) + '"/>');
				this.src='${ctx}/security/jcaptcha.jpg?' + Math.round(Math.random() * 100000) ;
			});
		$("#changeImage1").click(function(){
			//$('#captchaImg').html('<img src="${ctx}/security/jcaptcha.jpg?' + Math.round(Math.random() * 100000) + '"/>');
				document.getElementById("changeImage").src='${ctx}/security/jcaptcha.jpg?' + Math.round(Math.random() * 100000) ;
			});
		//添加回车事件
		$('#j_username,#j_password').keydown(function(event) {
			switch (event.keyCode) {
			case 13:
				$("#loginForm").submit(); 
				break;
			}
		});
		
	});   

/**
	 function document.onkeydown(){
			if(document.getElementById("j_captcha").value!= null){ 
			var evt = window.event?window.event:evt;
			if(evt.keyCode==13)	{   
				$("#loginForm").submit();   
			}
		}
	}
	
	*/       		
</script>


</head>
<body id="loginbaby">
<center>
<form id="loginForm" action="${ctx}/pages/platform/index.jsp" method="post">

<div class="loginbar">
  <div class="login">
		<%if ("1".equals(request.getParameter("error"))) {%>
		<span style="color:red"> 用户名或密码错误，请重试</span>
		<%
			}
			if ("2".equals(request.getParameter("error"))) {
		%>
		<span style="color:red"> 验证码错误，请重试</span>
		<%
			}
			if ("3".equals(request.getParameter("error"))) {
		%>   
		<span style="color:red"> 此帐号已从别处登录</span>
		<%}%>
  <table width="100%" border="0" cellpadding="0" cellspacing="0">  
  <tr height="35">
    <td height="30px" align="right">用户名：</td>
    <td height="30px" align="left" valign="middle">
		<input type='text' id='j_username' name='j_username'  class="required"  size=21  
					<c:if test="not empty param.error">
						value='<%=session.getAttribute(AuthenticationProcessingFilter.SPRING_SECURITY_LAST_USERNAME_KEY)%>'</c:if> />
	</td>
  </tr>
  <tr height="35">
    <td height="30px" align="right">密&nbsp;&nbsp;码：</td>
    <td height="30px" align="left" valign="middle">
		<input type='password' id='j_password' name='j_password' class="required" size=21 />
	</td>
  </tr>
  
  <tr>
    <td height="30px" align="right">验证码：</td>
    <td height="30px" align="left" valign="middle">
		<input id="j_captcha" type='text' name='j_captcha' size='4' class="required"/>
		<span id="captchaImg"><img src="${ctx}/security/jcaptcha.jpg" style="cursor:pointer;" id="changeImage" alt="点击更换图片"></span>
	</td>
  </tr>
 
  
 
   <tr>
    <td height="16px" align="right">&nbsp;</td>
    <td height="16px" align="left">
    	<!-- <input type="checkbox" name="_spring_security_remember_me"/>两周内记住我  -->
		<span style="margin-left:60px"><a  id="changeImage1" href="#">看不清楚换一张</a></span>
	</td>
  </tr>
  
  
  
  <tr>
    <td height="20px" align="right"></td>
    <td height="20px" align="left" valign="middle"><input name="" type="button" class="btn1" id="sub"/>&nbsp;&nbsp;&nbsp;
    <input name="" type="button" class="btn2" id="res"/></td>
  </tr>
</table>
  </div>
</div>
</form>
</center>
</body>
</html>