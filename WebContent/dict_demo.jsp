<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
</head>


<body>
		静态字典demo
		<br/>
		<br/>
		<jadl:dict code="3" dict="gender"/>
		<jadl:dict code="1" dict="gender123"/>
        <jadl:dictMap dict="gender"/>
      	|字典结构gender = ${dict_gender}
        <br/>
        |显示值为2的字典项:<jadl:dict code="2" dict="gender"/>
   		 <br/>       
        |遍历显示字典gender
        <c:forEach var="gender" items="${dict_gender}">
        <tr>
        	<input name="gender" type="radio" value="${gender.key}"/>
        	<td>${gender.value}</td>
        </tr>
   		</c:forEach>
   		<br/>
   		<br/>
        <jadl:dictMap dict="language"/>
        |字典结构language = ${dict_language}
        <br/>
        |显示值为zh的字典项:<jadl:dict code="zh" dict="language"></jadl:dict>
   		<br/>
   		|遍历显示字典language        
        <c:forEach var="language" items="${dict_language}">
        <tr>
        	<input name="language" type="radio" value="${language.key}"/>
        	<td>${language.value}</td>
        </tr>
   		</c:forEach>
   		<br/>
</body>
</html>
