<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../common/commonTag.jsp"%>
<%@ include file="../common/commonMeta.jsp"%>
<%@ include file="../common/commonCiteList.jsp"%>
<html>
<head>
<script type="text/javascript" language="javascript"
	src="${ctx }/js/common/pb.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${ctx}/css/common/main.css" rel="stylesheet"
	type="text/css" />
<title>屏幕锁定</title>

<script type="text/javascript" src="${ctx}/js/common/jquery-ui/jquery-1.4.2.js"></script>
<script type="text/javascript" src="${ctx}/js/validate.js"></script>
<script src="${ctx}/js/common/dialog/zDialog.js" type="text/javascript" ></script>
<script src="${ctx}/js/common/dialog/zDrag.js" type="text/javascript"></script>
<div style="display:none">
	<script src="${ctx}/js/common/dialog/DialogImg.js" type="text/javascript"></script>
</div>


<script type="text/javascript" language="javascript">

$(function(){
	$("#jiesuo").focus();
	
/**
	$("#jiesuo").keydown(function(event) {
		if (event.keyCode == 13) {
			pd();
		}
	});
	*/
});

	function pd(){
		var password = $("#jiesuo").val();
		if(isPasswd(password) == false){
			Dialog.alert('只能输入6-20个字母、数字、下划线!');
			return;
		}
		
		var isCheck = true;
		// 判断旧密码和数据库密码是否一致
		$.ajax({
					url : "${ctx}/sym/user/checkPassword.do?",
					type : 'post',
					dataType : 'text',
					data : 'plainPassword=' + $("#jiesuo").val(),
					async : false,
					success : function(data) {
						if (data == "true") {
							isCheck = true;
						} else {
							isCheck = false;
						}
					}
				});
		if(isCheck){
			parent.winObj.close();
		}else{
			Dialog.alert('密码错误,请重新输入!');
			$("#jiesuo").val('');
			}
	}

	
	function qc(){
		document.getElementById('jiesuo').value="";
		}

	function isPasswd(s) {
		var patrn = /^(\w){6,20}$/;
		if (!patrn.exec(s))
			return false
		return true
	}
</script>
</head>

<body>
<br/>
<br/>
<br/>
<br/>
<table width="100%">
	<tr align="center" height="30">
		<td align="right">输入密码:&nbsp;&nbsp;</td>
		<td align="left"><input type='password' id="jiesuo" size="25" name="jiesuo"></td>
	</tr>
	<tr align="center"  height="50">
		<td colspan="2" ><input type="button" value="解锁" onclick="pd()" class="button"/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="清除" onclick="qc()"  class="button"/></td>
	</tr>
</table>
</body>
</html>
