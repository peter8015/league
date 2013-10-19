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

//checkBox 全选反选
function checkBoxAll(tableID,chkID) {
   var inputs= document.getElementById(tableID).getElementsByTagName("input");
   var chkAll=document.getElementById(chkID);
   var b=0;
    for (i = 0; i < inputs.length; i++) { 
        if (inputs[i].type == "checkbox" && !inputs[i].disabled && inputs[i].id!=chkID){
            inputs[i].checked =chkAll.checked;
        }
    }
}

/************表格样式改变************/
 function onmouseoverTr(obj)
 {
 	 obj.className='overTr';
 }  

 function onmouseoutTr(obj) 
 {
 	 obj.className='outTr';
 }  

 function selectCheckBox(obj)
 {
 	 if(obj.checked==true)
 	 {
 	 	obj.parentNode.parentNode.className='selectBox';
 	 	obj.parentNode.parentNode.onmouseover='';
 	 	obj.parentNode.parentNode.onmouseout='';
 	 }
 	 else
 	 {
 	 	obj.parentNode.parentNode.className='unSelectBox';
 	 	obj.parentNode.parentNode.onmouseover=function(){
 	 		obj.parentNode.parentNode.className='overTr';
 	 	 	};
 	    obj.parentNode.parentNode.onmouseout=function(){
 	    	obj.parentNode.parentNode.className='outTr';
 	 	    };
 	 }	
 }   
 
//得到主键id的方法
function getID(tableID){
	var count=0;
	var inputs=document.getElementById(tableID).getElementsByTagName("input");
	for(var i=0;i<inputs.length;i++){
		if(inputs[i].type=="checkbox" && !inputs[i].disabled && inputs[i].id!="chkAll"){
			if(inputs[i].checked==true){
				count++;
			}
			else{
				continue;
			}
		}
	}
	if(count>1){
		
		return -1;
	}
	if(count==0){
		
		return -2;
	}
	if(count==1)
	{
		for(var i=0;i<inputs.length;i++){
			if(inputs[i].type=="checkbox" && !inputs[i].disabled && inputs[i].id!="chkAll"){
				if(inputs[i].checked==true){
					return inputs[i].id;
				}
			}
		}
	}
}


//获得选中的id
function getIdList(tableID)
{
	var count=0;
	var idList="";
	var inputs=document.getElementById(tableID).getElementsByTagName("input");
	for(var i=0;i<inputs.length;i++){
		if(inputs[i].type=="checkbox" && !inputs[i].disabled && inputs[i].id!="chkAll"){
			if(inputs[i].checked==true){
				count++;
			}
			else{
				continue;
			}
		}
	}
	if(count<1){
		
		return null;
	}
	
	for(var i=0;i<inputs.length;i++){
		if(inputs[i].type=="checkbox" && !inputs[i].disabled && inputs[i].id!="chkAll"){
			if(inputs[i].checked==true){
				 idList+=inputs[i].id+",";
			}
		}
	}
	return idList;
}

function getRadioID(tableID)
{
	var count=0;
	var inputs=document.getElementById(tableID).getElementsByTagName("input");
	for(var i=0;i<inputs.length;i++){
		if(inputs[i].type=="radio" && !inputs[i].disabled){
			if(inputs[i].checked==true){
				count++;
			}
			else{
				continue;
			}
		}
	}
	
	if(count==0)
	{
		alert("请选择记录！");
		return null;
	}
	
	for(var i=0;i<inputs.length;i++){
		if(inputs[i].type=="radio" && !inputs[i].disabled){
			if(inputs[i].checked==true){
				return inputs[i].id;
			}
		}
	}
}