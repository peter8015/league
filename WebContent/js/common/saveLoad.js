

function showJson(json) {
		$.each(json, function(i, n) {
			alert("NAME: " + i + ", VALUE: " + n);
		});
	}
	
function clearForm(formName) {
			var formObj = document.forms[formName];
			var formEl = formObj.elements;
			for ( var i = 0; i < formEl.length; i++) {
				var element = formEl[i];
				if (element.type == 'submit') {
					continue;
				}
				if (element.type == 'reset') {
					continue;
				}
				if (element.type == 'button') {
					continue;
				}
				if (element.type == 'hidden') {
					continue;
				}

				if (element.type == 'text') {
					element.value = '';
				}
				if (element.type == 'textarea') {
					element.value = '';
				}
				if (element.type == 'checkbox') {
					element.checked = false;
				}
				if (element.type == 'radio') {
					element.checked = false;
				}
				if (element.type == 'select-multiple') {
					element.selectedIndex = -1;
				}
				if (element.type == 'select-one') {
					element.selectedIndex = -1;
				}
			}
		}

function success(message){
	if(message==''){
		 $.ligerDialog.success('数据保存成功!');
	}else{
		 $.ligerDialog.success(message);
	}
		 
	}

function error(message){
	if(message==''){
		 $.ligerDialog.error('数据保存失败!');
	}else{
		 $.ligerDialog.success(message); 
	}
}

function showLoading() {
	   var div=document.createElement("div");  
	   sWidth = screen.availWidth; 
		if(screen.availHeight > document.body.scrollHeight){
			sHeight = screen.availHeight;	//少于一屏
		}else{
			sHeight = document.body.clientHeight;	//多于一屏 
		}
		div.setAttribute("id", "page_loading");     
		div.style.position = "absolute"; 
		div.style.top = "0"; 
		div.style.left = "0";
		div.style.background = "#E3E3E3";  
		div.style.filter = "Alpha(Opacity = 65);"; 
		div.style.opacity = "0.3"; 
		div.style.width = sWidth + "px"; 
		div.style.height = sHeight + "px"; 
		div.style.zIndex = "10000"; 
	    div.innerHTML="<div>"+ 
	   		"<table height='100%' width='100%' align='center' ><tr><td valign='middle' align='center'>"+                
			"<img src='"+__baseCtxPath+"/js/common/flexigrid/images/flexigrid/indicator_waitanim.gif'></img>"+           
			"</td></tr>"+           
			"<tr><td valign='middle' align='center'>数据保存中,请等待!...</td>"+    
			"</tr></table>"+   
		   "</div>";       

	   document.body.appendChild(div); 
	}      