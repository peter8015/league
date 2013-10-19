<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../../../commons/commonTag.jsp"%>
<%@ include file="../../../../commons/commonMeta.jsp"%>
<%@ include file="../../../../commons/commonCiteListSyn.jsp"%>
<html>
<head>
<title>通知公告修改</title>

<script type="text/javascript" src="${ctx}/js/common/validate/validate.js"></script>
<script type="text/javascript" language="javascript" src="${ctx}/js/common/resetform.js"></script>
<script type="text/javascript" language="javascript" src="${ctx}/js/common/fckeditor/fckeditor.js"></script>


<script type="text/javascript">
$(function(){
document.getElementById("djgzName").select(); 
});
function winload(funobj){
	if (document.all)  
		window.attachEvent('onload',funobj);
	else
		window.addEventListener('load',funobj,false);
}

//-----------trim----------
function profun(ele){
	ele.value=ele.value.replace(/(^\s+|\s+$)/g,'');
}

function profun2(ele){
	ele.value=ele.value.replace(/(^\s+|\s+$)/g,''); 
}


function doerror(args)
{
	id=args.element.id;
	sign=args.sign; 
	var errorString="";   
	switch(id)
	{
		case "djgzName":
	  		errorString="不为空且不大于20个字符";     
	  					break; 
		case "djgzContent":
			errorString="最多可输入2000个字符";
		break;    
		case "djgzType":
			errorString="请选择";
		break;    
	}
	if(sign){
			$("#" + id +"Validate").css("color","green");      
				document.getElementById(id+"Validate").innerHTML ="√";    
	}else{     
		$("#" + id +"Validate").css("color","red");
		document.getElementById(id+"Validate").innerHTML = errorString;  
	}  
}

function validateInput(){
	objform1=new ui_validate("form1"); 
	objform1.ErrorMsgType=2; 
	objform1.add("djgzName",doerror,"[notnull]&&[length,<=,20]",profun2);
	objform1.add("djgzType",doerror,"[selected,!=,-1]",profun); 
  	}
 
winload(validateInput);

function formSubmit(){
	if(objform1.groupcheckall() == true){  
		$("#form1").submit();   
		showLoading();      
	}       
}
window.onload = function()
{
var oFCKeditor = new FCKeditor( 'djgzContent' ) ;
oFCKeditor.BasePath = "${ctx}/js/common/fckeditor/" ;
oFCKeditor.ToolbarSet = 'Default' ;
oFCKeditor.Height=340;  
oFCKeditor.ReplaceTextarea() ;
}

</script>
</head>
<body id="saveLoad" class="bodys">
<form id="form1" action="updatesyn.do" method="post" enctype="multipart/form-data"> 

<input type="hidden" name="id" value="${govDjgzBos.id}" />
  <table width="100%" height="250">    
  <tr>
    <td  align="right">标题：&nbsp;&nbsp;</td>
    <td  align="left"><input id="djgzName" name="djgzName" type="text" size="16"  value="${govDjgzBos.djgzName}"/><span id="djgzNameValidate" class="mustSpan">*</span></td>
  		<td >类型&nbsp;&nbsp;</td>
  	<td >
  	<select id="djgzType" name="djgzType">
  		
  			<option  selected value="公告">公告</option>
  			<option   value="通知">通知</option>
  			<option    value="其它">其它</option>
  		</select>
  	<span id="djgzTypeValidate" class="mustSpan">*</span>
  	</td>
  </tr>
  <tr>
    <td  align="right">内容：&nbsp;&nbsp;</td>
    <td colspan="3" align="left"><textarea id="djgzContent" name="djgzContent" cols="85" rows="6">${govDjgzBos.djgzContent}</textarea>
    <div id="coaRemarkValidate" style="color: red"></div>   
    </td>
  </tr> 
 
 
    
</table>

</form>
</body>  
</html>