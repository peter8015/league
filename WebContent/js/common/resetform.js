function resetform(formid){ 
	 
	var color="";   
	var sp=$("span");
	var dir=$("div");
	for(var j=0;j<dir.length;j++){
	color=$("#"+dir[j].id).css("color");
	if(color=='red'){  
		$("#"+dir[j].id).html("");     
	}
	}
	for(var i=0;i<sp.length;i++){  
         var xh=document.getElementById(sp[i].id).innerHTML;
         if(xh!="*"){
        	 document.getElementById(sp[i].id).innerHTML="*";
        	 $("#"+sp[i].id).css("color","red");
             }
		}   
	document.getElementById(formid).reset(); 
} 