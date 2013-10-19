<script>
 	var availableTags = new Array();
	$(function() {
		//添加回车事件
		$("#dropdownlink + ul li").click(function() {
			$("#dropdownlink").html($(this).text()+'<span class="caret"></span>');
			return true;
		});
	});
</script>
<div class="navbar navbar-fixed-top">
	<div class="navbar-inner"> 
        <div> 
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
            <span class="icon-bar"></span> 
            <span class="icon-bar"></span> 
            <span class="icon-bar"></span> 
          </a> 
          <a class="brand" href="<%=request.getContextPath()%>/pages/league/igo/index/index.jsp"><img src="<%=request.getContextPath()%>/pages/leaguecss/images/league_icon.png" /></a> 
          <div class="nav-collapse"> 
			<ul class="nav">
            <li class="divider-vertical"></li> 
            <li class="home"> 
                <a href="<%=request.getContextPath()%>/pages/league/igo/search/search_index.jsp"><span><img src="<%=request.getContextPath()%>/pages/leaguecss/images/home_icon.png" /></span></a> 
            </li>
            <li class="divider-vertical"></li> 
              <li> 
                <a href="<%=request.getContextPath() %>/project/guideList">我的项目</a> 
              </li>
              <li id="dropdownli"><div class="input-append btn-group"><input type="text" class="span2" placeholder="请输入文字..." />
          <a class="btn dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)" id="dropdownlink">搜项目<span class="caret"></span></a>
          <ul class="dropdown-menu">
          	<li><a href="javascript:void(0)">搜项目</a></li>
            <li><a href="javascript:void(0)">搜人员</a></li>
            <li><a href="javascript:void(0)">搜任务</a></li>
          </ul>
        </div></li>
              
              <li><button class="btn marg_t05 marg_l03">搜索</button></li>
			</ul>
            
			<ul class="nav" style="float:right;">
            	<li class="tools"> 
            		<a href="#"><img src="<%=request.getContextPath()%>/pages/leaguecss/images/defect.jpg" /><span class="num">5</span></a> 
            	</li> 
            	<li class="tools"> 
            		<a href="#"><img src="<%=request.getContextPath()%>/pages/leaguecss/images/task.jpg" /><span class="num">33</span></a> 
            	</li> 
            	<li class="active posi_r">
                	<a href="#" id="person_name" onclick="person_D()"><img src="<%=request.getContextPath()%>/pages/leaguecss/images/people_icon.png" /> 何欣<span class="icon-down" id="person_icon"></span></a>
                	<div class="person_detail none" id="person_Dc">
                    	<p><a href="#">个人资料</a></p>
                        <p><a href="#">密码修改</a></p>
                    </div>
                </li>
                <li><a href="<%=request.getContextPath()%>/j_spring_security_logout" title="退出"><span><img src="<%=request.getContextPath()%>/pages/leaguecss/images/exit.jpg" /></span></a>
                </li> 
            </ul> 
          </div> 
        </div> 
      </div> 
</div>