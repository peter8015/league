// JavaScript Document
function person_D(){
	var pn=document.getElementById("person_name");
	var pdc=document.getElementById("person_Dc");
	var pi=document.getElementById("person_icon");
	if(pi.className=="icon-down"){
		pi.className="icon-up";
		pdc.className="person_detail";
	}else{
		pi.className="icon-down";
		pdc.className="person_detail none";
	}	
}