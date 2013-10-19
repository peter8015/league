<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
</head>
<script type="text/javascript" src="${ctx}/js/validate.js"></script> 
<script language="JavaScript">  
window.$=function(obj){return typeof(obj)=="string"?document.getElementById(obj):obj}
//-----------trim----------
function profun(ele){
	ele.value=ele.value.replace(/(^\s+|\s+$)/g,'');
}

function winload(funobj){
	if (document.all)
		window.attachEvent('onload',funobj)
	else
		window.addEventListener('load',funobj,false);
}

function doerror(args)
{
	id=args.element.id;
	var errorid=args.errorid;
	sign=args.sign;
	switch(id)
	{
		case "p1":
			tagid="p1Tip";
			break;

		case "p2":
			tagid="p2Tip";
			break;

		case "p3":
			tagid="p3Tip";
			break;

		case "p4":
			tagid="p4Tip";
			break;
			
		case "p5":
			tagid="p5Tip";
			break;

		case "p6":
			tagid="p6Tip";
			break;

		case "p7":
			tagid="p7Tip";
			break;

		case "p8":
			if(sign==false){
			tagid="p8Tip";
  			switch(errorid)
  			{
  				case 0:
  					errStr="不可以为空"; //判断输入不可以为空值
  					break;
  				case 1:
  					errStr="不是负小数"; //判断输入是不是负小数
  					break;
  				case 2:
  					errStr="不满足大于-100同时小于-50";  //判断是否满足大于-100或者小于-50
  					break;
  			}
  			alert(errStr);
			}
			break;
	}

	if(sign){
		document.getElementById(tagid).style.border="";
		}
	else{
		document.getElementById(tagid).style.border="1px solid red";
	}
}

function test(args){
	var result=false;
	if(args.element.value==("TDTK-jadl")){
	   result=true;
	}
	return result;
}

function validateInput(){
	objform1=new ui_validate("form1");  
	objform1.ErrorMsgType=2;
	objform1.add("p1",doerror,"[notnull]&&[length,>=,6]&&[int]",profun);
	objform1.add("p2",doerror,"[notnull]&&[email]");
	objform1.add("p3",doerror,"[notnull]&&[email]&&[equaltext,p2]");
	objform1.add("p4",doerror,"[notnull]&&[compare,www.google.com]");
	objform1.add("p5",doerror,"[notnull]&&[ipaddress]");
	objform1.add("p6",doerror,"[checked,true]");
	objform1.add("p7",doerror,"[notnull]&&[test]");
	objform1.add("p8",doerror,["[notnull]","[float]&&[scale,<,0]","[scale,>,-100]&&[scale,<,-50]"]);
}

winload(validateInput);

function formSubmit(){
	if(objform1.groupcheckall() == true){
		$("form1").submit();
	}
}

</script>
 
<title>前端校验demo</title>
</head>
<body>
<h4>前端校验demo</h4>
<table width="80%" cellspacing="0">
  <tr>
    <th><h3>校验：</h3></th>
  </tr>
  
  <tr>
    <td colspan="3"><div>
        <form id="form1" name="regChk" method="post" action="${ctx}/validate_demo_ok.jsp">
          <table width="95%" border="0" cellspacing="1" cellpadding="0">
          
           <tr>
              <td align="right">p1：</td>
              <td nowrap><span>*</span>
                <input id="p1" type="text" size="20" /></td>
              <td align="left"><span id="chkPet"></span></td>
              <td>
              <div id="p1Tip">
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6-20位int型字符
               </div>
               </td>
            </tr>
     		
     		<tr>
              <td align="right">p2：</td>
              <td nowrap><span>*</span>
                <input id="p2" type="text" size="20" /></td>
              <td align="left"><span id="chkPet"></span></td>
              <td>
              <div id="p2Tip">
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;email格式
               </div>
               </td>
            </tr>
            
     		<tr>
              <td align="right">p3：</td>
              <td nowrap><span>*</span>
                <input id="p3" type="text" size="20" /></td>
              <td align="left"><span id="chkPet"></span></td>
              <td>
              <div id="p3Tip">
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;重复上面的输入
               </div>
               </td>
            </tr>         
            
            <tr>
              <td align="right">p4：</td>
              <td nowrap><span>*</span>
                <input id="p4" type="text" size="20" /></td>
              <td align="left"><span id="chkPet"></span></td>
              <td>
              <div id="p4Tip">
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入字符串"www.google.com"
               </div>
               </td>
            </tr>     
            
            <tr>
              <td align="right">p5：</td>
              <td nowrap><span>*</span>
                <input id="p5" type="text" size="20" /></td>
              <td align="left"><span id="chkPet"></span></td>
              <td>
              <div id="p5Tip">
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入IP地址
               </div>
               </td>
            </tr>    
            
            <tr>
              <td align="right">p6：</td>
              <td nowrap><span>*</span>
                <input type="checkbox" id="p6" /></td>
              <td align="left"><span id="chkPet"></span></td>
              <td>
              <div id="p6Tip">
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选中
               </div>
               </td>
            </tr>       
            
            <tr>
              <td align="right">p7：</td>
              <td nowrap><span>*</span>
                <input id="p7" type="text" size="20" /></td>
              <td align="left"><span id="chkPet"></span></td>
              <td>
              <div id="p7Tip">
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入"TDTK-jadl"
               </div>
               </td>
            </tr>         
            
            <tr>
              <td align="right">p8：</td>
              <td nowrap><span>*</span>
                <input id="p8" type="text" size="20" /></td>
              <td align="left"><span id="chkPet"></span></td>
              <td>
              <div id="p8Tip">
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入大于-100同时小于-50的小数
               </div>
               </td>
            </tr>   
            
          </table>
        </form>
      </div></td>
  </tr>
</table>
<div>
 <input name="" type="button" value="提交" onclick="formSubmit();"/>
 <input name="" type="button" value="取消" />
</div>
</body>
</html>

