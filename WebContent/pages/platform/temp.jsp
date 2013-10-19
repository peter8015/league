<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'temp.jsp' starting page</title>
	</head>

	<body>


		<td id="col_r" valign="top">
			
			<!--  单位模块 START -->
			<div id="module_info2" class="desk_module">
				<table border="0" cellspacing="0" width="100%" class="desk_tab"
					name="tabName_box">
					<tr>
						<td class="desk_tab_title" id="module_info2_head">
							<div class="desk_index" id="module_info2_title">
								爆破作业单位许可证受理审批
							</div>
						</td>
						<td id="module_info2_more" class="desk_tab_title_right" nowrap>

							<div class="desk_tab_more">
								<a
									href="/info/info/infoColumnAction.do?step=columnTree&amp;pageUrl=/commons/site/entry_info.jsp&amp;SelectNodeId=4028818b0c62365d010c66cbe0de006b"><img
										src="${ctx}/pages/image/blank.gif" width="40" height="20" />
								</a>
							</div>

							<div id="module_info2_op" class="desk_tab_opera">

								<img src="${ctx}/pages/image/desktop/module_edit.gif"
									alt="显示设置选项" />

								<img src="${ctx}/pages/image/desktop/module_close.gif"
									alt="不显示该模块" />
							</div>

						</td>
					</tr>

					<tr id="trId_module_info2">
						<td colspan="2" class="desk_tab_content">
							<div id="module_info2_content" class="box_content">
								<table width="100%" height="57" border="0">
									<tr>
										<td>
											<img src="${ctx}/pages/image/desktop/bg_info_blue.gif"
												align="absmiddle" border="0" />
											<a href="javascript:searchYszsqslwsp()">有<span
												style="color: red"><s:property value="countYszWsp" />
											</span>条运输许可证申请受理未审批</a>
										</td>
									</tr>
									<tr>
										<td>
											<img src="${ctx}/pages/image/desktop/bg_info_blue.gif"
												align="absmiddle" border="0" />
											<a href="javascript:searchYszsqysp()">有<span
												style="color: red"><s:property value="countYszYsp" />
											</span>条运输许可证申请已审批</a>
										</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
				</table>
			</div>
			<!--  单位模块 END -->

			<!--  人员模块 START -->
			<div id="module_info2" class="desk_module">
				<table border="0" cellspacing="0" width="100%" class="desk_tab"
					name="tabName_box">
					<tr>
						<td class="desk_tab_title" id="module_info2_head">
							<div class="desk_index" id="module_info2_title">
								人员许可证受理审批
							</div>
						</td>
						<td id="module_info2_more" class="desk_tab_title_right" nowrap>

							<div class="desk_tab_more">
								<a
									href="/info/info/infoColumnAction.do?step=columnTree&amp;pageUrl=/commons/site/entry_info.jsp&amp;SelectNodeId=4028818b0c62365d010c66cbe0de006b"><img
										src="${ctx}/pages/image/blank.gif" width="40" height="20" />
								</a>
							</div>

							<div id="module_info2_op" class="desk_tab_opera">

								<img src="${ctx}/pages/image/desktop/module_edit.gif"
									alt="显示设置选项" />

								<img src="${ctx}/pages/image/desktop/module_close.gif"
									alt="不显示该模块" />
							</div>

						</td>
					</tr>

					<tr id="trId_module_info2">
						<td colspan="2" class="desk_tab_content">
							<!-- 显示内容 -->
							<div id="module_info2_content" class="box_content">

								<table width="100%" height="57" border="0">
									<tr>
										<td>
											<img src="${ctx}/pages/image/desktop/bg_info_blue.gif"
												align="absmiddle" border="0" />
											<a href="javascript:searchYszsqslwsp()">有<span
												style="color: red"><s:property value="countYszWsp" />
											</span>条运输许可证申请受理未审批</a>
										</td>
									</tr>
									<tr>
										<td>
											<img src="${ctx}/pages/image/desktop/bg_info_blue.gif"
												align="absmiddle" border="0" />
											<a href="javascript:searchYszsqysp()">有<span
												style="color: red"><s:property value="countYszYsp" />
											</span>条运输许可证申请已审批</a>
										</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
				</table>
			</div>
			<!--  人员模块 END -->
			
		</td>

	</body>
</html>
