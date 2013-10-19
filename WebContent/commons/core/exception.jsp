<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
         language="java" isErrorPage="true" %>
<%@ include file="core.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>


    <script type="text/javascript" language="JavaScript">
        function toggle() {
            var div = getExceptionStackDiv();
            var button = getToggleButton();
            if (div.style.display == 'none') {
                div.style.display = 'block';
                button.innerText = '收起异常信息';
            } else {
                div.style.display = 'none';
                button.innerText = '展开异常信息';
            }
        }

        function getToggleButton() {
            return document.getElementById('toggleButton');
        }

        function getExceptionStackDiv() {
            return document.getElementById('exceptionStack');
        }
    </script>
</head>
<body>
<h2>很抱歉，系统发生了错误</h2>

<p>
    请您与管理员联系并提供如下错误信息。
</p>
<hr/>
<h3>错误信息</h3>
<s:actionerror/>
<p>${exception.message}
</p>
<hr/>
<h3>技术细节</h3>


<button id="toggleButton" onclick="toggle()">展开异常信息</button>
<div style="display:none" id="exceptionStack">
    <p>${exceptionStack} 
    </p>
</div>
</body>
</html>