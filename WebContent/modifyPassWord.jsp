<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<div id="modify" style="display:none;" >
	<div style="padding: 20px 0px 0px 60px;">
		<form method="post">

			<table>

				<tr>
					<td>旧&nbsp;&nbsp;密&nbsp;&nbsp;码：</td>
					<td><input tabindex="1" type="password" id="passWord" name="passWord" style="width: 150px;"></input>
					</td>
				</tr>
				<tr>
					<td>新&nbsp;&nbsp;密&nbsp;&nbsp;码：</td>
					<td><input tabindex="2" type="password"  id="newPassword" name="newPassword"
						style="width: 150px;"></input>
					</td>
				</tr>

				<tr>
					<td>再输入一次：</td>
					<td><input tabindex="3" id="dblnewPassword"  type="password" name="dblnewPassword"
						style="width: 150px;"></input>
					</td>
				</tr>
			
				<tr height="30px" >
				
				<td colspan="2" align="center" style="color: red">
				<div><span
					id="message"></span>
					</div>
				</td>
				
				</tr>
				
			</table>
		</form>
	</div>
	
</div>
