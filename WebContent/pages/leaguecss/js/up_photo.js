function receive(){
	var _b = document.getElementById("www_zzjs_net");
	//包括边线的可见区域宽高
	//_b.style.width = document.documentElement.offsetWidth+"px";
	//_b.style.height = document.documentElement.offsetHeight+"px";
	//可见区域宽高
	_b.style.width = document.documentElement.clientWidth+"px";
	_b.style.height = document.documentElement.clientHeight+"px";
	//正文全文宽高
	//_b.style.width = document.documentElement.scrollWidth+"px";
	//_b.style.height = document.documentElement.scrollHeight+"px";
	_b.style.visibility = 'visible';
	_b.style.display = "block";
	var _p = document.getElementById("tck");
	_p.width = 370;	_p.height = 300;
	//包括边线的可见区域宽高
	//_p.style.left = (document.documentElement.offsetWidth - _p.width)/2 + "px";
	//_p.style.top = (document.documentElement.offsetHeight- _p.height)/2 + "px";
	//可见区域宽高
	_p.style.left = (document.documentElement.clientWidth - _p.width)/2 + "px";
	_p.style.top = (document.documentElement.clientHeight- _p.height)/2 + "px";
	//正文全文宽高
	//_p.style.left = (document.documentElement.scrollWidth - _p.width)/2 + "px";
	//_p.style.top = (document.documentElement.scrollHeight- _p.height)/2 + "px";
	_p.style.visibility = 'visible';
	_p.style.display = "block";
}
function receiveclose(){
	document.getElementById("www_zzjs_net").style.display="none";
	document.getElementById("tck").style.display="none" ; 
 }
//function checkfinish()
//{
//	pupopen();
	//document.getElementById("paysubmit").disabled = true; 
//	  document.payform.submit();
//}