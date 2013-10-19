<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/commons/commonTag.jsp"%>
<%@ include file="/commons/commonMeta.jsp"%>
<%@ page import="org.springframework.security.ui.AbstractProcessingFilter" %>
<%@ page import="org.springframework.security.ui.webapp.AuthenticationProcessingFilter" %>
<%@ page import="org.springframework.security.AuthenticationException" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${ctx}/pages/leaguecss/css/login.css" />
<link rel="shortcut icon" type="image/x-icon" href="${ctx}/pages/leaguecss/images/favicon.ico" />
<title>league</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-1.7.2.min.js"></script>
<script src="${ctx}/js/common/validate/jquery.validate.js" type="text/javascript"></script>
<script src="${ctx}/js/common/validate/messages_cn.js" type="text/javascript"></script>
<script>
	$(document).ready(function() {
		
		$("#sub").click(function(){
				if($("#loginForm").valid()){
					$("#loginForm").submit();
					}
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
</script>
</head>
<body>
	<div class="w1000">
	<div class="logo"><img src="${ctx}/pages/leaguecss/images/login_logo.png" /></div>
    <div class="clr40"></div>
    <div class="login_wap">
    	<div class="login_wap_box">
        	<div class="ad fl">
            	<img src="${ctx}/pages/leaguecss/images/login_ad.jpg" />
            </div>
            <div class="login_form fr">
<!--            	<form action="${ctx}/j_spring_security_check" method="post" name="loginForm" id="loginForm">-->
            	<form action="${ctx}/j_spring_security_check" method="post" name="loginForm" id="loginForm">
            	<div class="login">
            	<%if ("1".equals(request.getParameter("error"))) {%>
		          <span style="color:red"> 用户名或密码错误，请重试</span>
		        
		       <%
			}
			   if ("3".equals(request.getParameter("error"))) {
		     %>   
		     <span style="color:red"> 此帐号已从别处登录</span>
		   <%}%>
                	<div class="item fore1">
                        <span>用户名</span>
                        <div class="item-ifo">
                            <input type="text" id="j_username" name="j_username" class="text"    tabindex="1" autocomplete="off"/>
                            <c:if test="not empty param.error">
						value='<%=session.getAttribute(AuthenticationProcessingFilter.SPRING_SECURITY_LAST_USERNAME_KEY)%>'</c:if> 
                            <div class="i-name ico"></div>
                        </div>
                    </div>
                    <div class="item fore2">
                        <span>密码</span>
                        <div class="item-ifo">
                            <input type="password" id="j_password" name="j_password" class="text" tabindex="2"/>
                            <div class="i-pass ico"></div>
                        </div>
                    </div>
                    <div class="item fore4" id="autoentry">
                        <div class="item-ifo">
                            <input type="checkbox" class="checkbox" name="chkRememberMe" clstag="passport|keycount|login|04"/>
                            <label class="mar">自动登录</label>
                        </div>
                    </div>
                    <div class="item login-btn2013">
                        <input type="button" class="btn-img btn-entry" id="sub" value="登  录" tabindex="8" />
                    </div>
                    </div>
                </form>
                
            </div>
        </div>
    </div>
    <div class="login_inverted_img">
    	<img src="${ctx}/pages/leaguecss/images/login_box_bg.png" height="240" width="1000" />
    </div>
</div>
</body>
</html>