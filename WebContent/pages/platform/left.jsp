<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../common/commonTag.jsp"%>
<html>
 <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>java基础开发框架系统菜单导航</title>
	<link rel="stylesheet" type="text/css" href="${ctx}/css/common/main.css"></link>
	<link rel="stylesheet" type="text/css" href="${ctx}/css/common/menu.css"></link>
	<link rel="stylesheet" type="text/css" href="${ctx}/css/imgBock/style.css"></link>
	<script type="text/javascript" language="javascript" src="${ctx}/js/imgBock/jquery.js"></script>

	<script type="text/javascript" language="javascript" src="${ctx}/js/imgBock/interface.js"></script>  
	<script>
	var imurl="${ctx}/images/common/index/jdsb.gif";
	var titName="XX管理";
		function gotoPage(url,titleName,imgurl)
		{
			var ifrm=document.getElementById("ifrm");
			ifrm.src='${ctx}/viewAction.do?urlView='+url;
			imurl=imgurl;     
			titName=titleName;
			if(window.parent.detail.imgPages){       
				window.parent.detail.document.getElementById("sp").innerHTML=titleName;
				//window.parent.detail.document.getElementById("img").src=imgurl;
			}else{ 
				window.parent.document.getElementById("detail").src="${ctx}/sym/user/IndexImage.do";   
			}
			
			var myTitile = $('#myTitile').val(titleName);
			var myImg = $('#myImg').val(imgurl);
		}


		function chanagewin()
		{
			ifrm.height=window.screen.availHeight;
		}

		function shouImg(){  
			var a=$("#imgTab1").find("tr").size();
			if(document.getElementById("imgTab1").style.display=="block"){
				document.getElementById("imgTab1").style.display="none";
				//document.getElementById("dock2").style.display="block";
				document.getElementById("imgId").src="${ctx}/images/common/index/t.gif";
				document.getElementById("imgId").alt="显示";
			    document.getElementById("ifrm").style.height=window.screen.availHeight-window.screenTop-74-80;                
			}else{  
				document.getElementById("imgTab1").style.display="block";  
				//document.getElementById("dock2").style.display="none";
				document.getElementById("imgId").src="${ctx}/images/common/index/b.gif"; 
				document.getElementById("imgId").alt="隐藏"; 
				document.getElementById("ifrm").style.height=window.screen.availHeight-window.screenTop-74-150+(5-a)*25;            
			}     
		}
	</script>
<script type="text/javascript">
	   
	$(document).ready(function(){
			/* $('#dock2').Fisheye(
				{ 
					maxWidth: 35,                     
					items: 'a',   
					itemsText: 'span',
					container: '.dock-container2',
					itemWidth: 40,              
					proximity: 25,                 
					alignment : 'center',  
					valign: 'bottom',
					halign : 'center' 
				}
			); */
			var a=$("#imgTab1").find("tr").size();
			document.getElementById("ifrm").style.height=window.screen.availHeight-window.screenTop-74-150+(5-a)*25;      

			var myTitile = $('#myTitile').val();
			var myImg = $('#myImg').val();

			if(myTitile != 'XX管理'){
					if(window.parent.detail.imgPages){       
						window.parent.detail.document.getElementById("sp").innerHTML=myTitile;
						window.parent.detail.document.getElementById("img").src=myImg;
					}else{ 
						window.parent.document.getElementById("detail").src="${ctx}/sym/user/IndexImage.do";   
					}
				}
		});    
  
</script> 
</head> 
<body style="overflow:hidden;background-color:#d6edfa;">   
    <div>
	<table cellpadding="0" cellspacing="0" width="200" height="" border="0">
  <tr>
    <td style="padding-top:1px;">
	<table width="200px" height="26px" border="0" align="left" cellpadding="0" id="ifmTab" cellspacing="0" background="${ctx}/images/common/index/11.gif">
			<tr>
			  <td valign="middle" align="left" width="30px">&nbsp;&nbsp;<img src="${ctx}/images/common/index/left-tb.gif"></td>
			  <td valign="middle" align="left">&nbsp;&nbsp;<span class="spanTitle">导航菜单</span></td>
			</tr>
    </table>
	</td>
  </tr>
  
   <s:if test="@com.base.platform.framework.utils.SpringSecurityUtils@hasAuthority('a_sym_super,a_wz')">
	  <tr>  
	    <td style="background-color:#d6edfa;"><iframe src="${ctx}/viewAction.do?urlView=pages/league/wzgl/govTree.jsp" id="ifrm" class="ifrmm" frameborder="0"></iframe></td>
	  </tr>
	  <input type="hidden" id="myTitile" value="XX管理">
	  <input type="hidden" id="myImg" value="${ctx}/images/common/index/xtpt.gif">
  </s:if>
  
 


  
  
   
  <s:elseif test="@com.base.platform.framework.utils.SpringSecurityUtils@hasAuthority('a_sym_super,a_sym')">
  	   <tr>  
	    <td style="background-color:#d6edfa;"><iframe src="${ctx}/viewAction.do?urlView=pages/platform/sym/symTree.jsp" id="ifrm" class="ifrmm" frameborder="0"></iframe></td>
	  </tr>
	  <input type="hidden" id="myTitile" value="系统管理">
	  <input type="hidden" id="myImg" value="${ctx}/images/common/index/xtpt.gif">
  </s:elseif>
  
<!--   <tr> 
  	<td class="ha" onclick="shouImg()"><img id="imgId" alt="隐藏" src="${ctx}/images/common/index/b.gif"></td>  
  </tr> -->
     <tr> 
  	<td  ><img id="imgId" alt="隐藏" src="${ctx}/images/common/index/b.gif"></td>  
  </tr>
  
  
  <tr><td> 
  <table id="imgTab1" style="display: block">    
	 <s:if test="@com.base.platform.framework.utils.SpringSecurityUtils@hasAuthority('a_sym_super,a_wz')">
	  	<tr >
			<td class="ha"><a href="#" onclick="gotoPage('pages/league/wzgl/govTree.jsp','XX管理','${ctx}/images/common/index/xtpt.gif')">&nbsp;&nbsp;<img src="${ctx}/images/common/index/sb.gif" style="border:none">&nbsp;&nbsp;XX管理</a></td>
		</tr>
	 </s:if>  
	
	
  
	 

	<s:if test="@com.base.platform.framework.utils.SpringSecurityUtils@hasAuthority('a_sym_super,a_sym')">
		<tr>
			<td  class="ha"><a href="#" onclick="gotoPage('pages/platform/sym/symTree.jsp','系统管理','${ctx}/images/common/index/xtpt.gif')">&nbsp;&nbsp;<img src="${ctx}/images/common/index/sb.gif" style="border:none">&nbsp;&nbsp;系统管理</a></td>
		</tr>
	</s:if>
	</table>
	
	 
	</td>
	</tr>
</table> 
	</div>
</body>
</HTML>


