<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<%@ include file="commonTag.jsp"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>提示信息</title>
	
<script type="text/javascript" language="javascript" src="${ctx}/js/common/jquery-ui/jquery-1.4.2.js"></script>

<style type="text/css">
	*{ margin:0; padding:0; font-family:"宋体"; font-size:12px;}
	img{ border:0;}
	body{ background:#d6edfa;}
	a{ color:#013a81;}

</style>
	
	
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
    <td width="31%" align="right"><img src="${ctx}/images/common/sys/403.gif" /></td>
    <td width="40%" align="left" style="font-size:24px; font-weight:bold">&nbsp;&nbsp;没有查询到相关信息！</td>
    <td width="46%" align="left" valign="bottom"><a href="#" onclick="window.history.back();">返回</a></td>   
  </tr>
</table>
</center>
</body>
</html>


