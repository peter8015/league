<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="commonTag.jsp"%>
<%@ include file="commonMeta.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>404 - 页面不存在</title>
<style type="text/css">
	*{ margin:0; padding:0; font-family:"宋体"; font-size:12px;}
	img{ border:0;}
	body{ background:#d6edfa;}
	a{ color:#013a81;}

</style>
	<script type="text/javascript">
		function logout(){
			top.window.location.href="${ctx}/"; 
		}  
	</script>
	
</head>
<body>
<center>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0" style="color:#013a81;">
 <tr>
    <td height="200" align="right">&nbsp;</td>
    <td height="200" align="left" style="font-size:24px; font-weight:bold">&nbsp;</td>
    <td height="200" align="left" valign="bottom">&nbsp;</td>
  </tr>
  <tr>
        <td width="31%" align="right"><img src="${ctx}/images/common/sys/404.gif" /></td>
    <td width="23%" align="left" style="font-size:24px; font-weight:bold">&nbsp;&nbsp;页面不存在！</td>
    <td width="46%" align="left" valign="bottom"><a href="#" onclick="logout();">退出系统</a></td>
  </tr>
</table>
</center>
</body>
</html>


