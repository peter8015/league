	/************************************身份证验证*******************************************/
	
	function isChinaIDCard(StrNo){
	StrNo = StrNo.toString();
	if (StrNo.length==18){
		var a,b,c
		if (!isInteger(StrNo.substr(0,17))) {return false}
		a=parseInt(StrNo.substr(0,1))*7+parseInt(StrNo.substr(1,1))*9+parseInt(StrNo.substr(2,1))*10;
		a=a+parseInt(StrNo.substr(3,1))*5+parseInt(StrNo.substr(4,1))*8+parseInt(StrNo.substr(5,1))*4;
		a=a+parseInt(StrNo.substr(6,1))*2+parseInt(StrNo.substr(7,1))*1+parseInt(StrNo.substr(8,1))*6;
		a=a+parseInt(StrNo.substr(9,1))*3+parseInt(StrNo.substr(10,1))*7+parseInt(StrNo.substr(11,1))*9;
		a=a+parseInt(StrNo.substr(12,1))*10+parseInt(StrNo.substr(13,1))*5+parseInt(StrNo.substr(14,1))*8;
		a=a+parseInt(StrNo.substr(15,1))*4+parseInt(StrNo.substr(16,1))*2;
		b=a%11;

		if (b==2) { //最后一位为校验位
			c=StrNo.substr(17,1).toUpperCase(); //转为大写X
		}
		else{
			c=parseInt(StrNo.substr(17,1));
		}

		switch(b){
			case 0: if ( c!=1 ) {Dialog.alert( "身份证好号码校验位错:最后一位应该为:1 ");return false;}break;
			case 1: if ( c!=0 ) {Dialog.alert( "身份证好号码校验位错:最后一位应该为:0 ");return false;}break;
			case 2: if ( c!= "X ") {Dialog.alert( "身份证好号码校验位错:最后一位应该为:X ");return false;}break;
			case 3: if ( c!=9 ) {Dialog.alert( "身份证好号码校验位错:最后一位应该为:9 ");return false;}break;
			case 4: if ( c!=8 ) {Dialog.alert( "身份证好号码校验位错:最后一位应该为:8 ");return false;}break;
			case 5: if ( c!=7 ) {Dialog.alert( "身份证好号码校验位错:最后一位应该为:7 ");return false;}break;
			case 6: if ( c!=6 ) {Dialog.alert( "身份证好号码校验位错:最后一位应该为:6 ");return false;}break;
			case 7: if ( c!=5 ) {Dialog.alert( "身份证好号码校验位错:最后一位应该为:5 ");return false;}break;
			case 8: if ( c!=4 ) {Dialog.alert( "身份证好号码校验位错:最后一位应该为:4 ");return false;}break;
			case 9: if ( c!=3 ) {Dialog.alert( "身份证好号码校验位错:最后一位应该为:3 ");return false;}break;
			case 10: if ( c!=2 ){Dialog.alert( "身份证好号码校验位错:最后一位应该为:2 ");return false}
		}
	}else { //15位身份证号
		if (!isInteger(StrNo)) {
			Dialog.alert( "身份证号码错误,前15位不能含有英文字母！ ");
			return false;
		}
	}
		
	switch(StrNo.length){
		case 15:
		if (isValidDate( "19 "+StrNo.substr(6,2),StrNo.substr(8,2),StrNo.substr(10,2))){
			return true;
		}else{
			return false;
		}
		case 18:
		if (isValidDate(StrNo.substr(6,4),StrNo.substr(10,2),StrNo.substr(12,2))){
			return true;
		}else{
			return false;
		}
	}
	
	Dialog.alert( "输入的身份证号码必须为15位或者18位！ ");
	return false;
}
		
function isValidDate(iY, iM, iD) {
	var a=new Date(iY,iM,iD);
	var y=a.getFullYear();
	var m=a.getMonth();
	var d=a.getDate();
	if (y!=iY || m!=iM || d!=iD){
		window.Dialog.alert ( '身份证号码内日期错误！ ');
		return false;
	}
	return true;
}
	
function isInteger(str) {
	if (/[^\d]+$/.test(str)){
		return false;
	}
	return true;
}
		
		
function IDUpdate(StrNo){
	
	if (!isChinaIDCard(StrNo)){
		return false
	}
	
	if (StrNo.length==15){
		var a,b,c
		StrNo=StrNo.substr(0,6)+ "19 "+StrNo.substr(6,9);
		a=parseInt(StrNo.substr(0,1))*7+parseInt(StrNo.substr(1,1))*9+parseInt(StrNo.substr(2,1))*10;
		a=a+parseInt(StrNo.substr(3,1))*5+parseInt(StrNo.substr(4,1))*8+parseInt(StrNo.substr(5,1))*4;
		a=a+parseInt(StrNo.substr(6,1))*2+parseInt(StrNo.substr(7,1))*1+parseInt(StrNo.substr(8,1))*6;
		a=a+parseInt(StrNo.substr(9,1))*3+parseInt(StrNo.substr(10,1))*7+parseInt(StrNo.substr(11,1))*9;
		a=a+parseInt(StrNo.substr(12,1))*10+parseInt(StrNo.substr(13,1))*5+parseInt(StrNo.substr(14,1))*8;
		a=a+parseInt(StrNo.substr(15,1))*4+parseInt(StrNo.substr(16,1))*2;
		b=a%11;
		
		switch(b){
			case 0: {StrNo=StrNo+ "1 ";}break;
			case 1: {StrNo=StrNo+ "0 ";}break;
			case 2: {StrNo=StrNo+ "X ";}break;
			case 3: {StrNo=StrNo+ "9 ";}break;
			case 4: {StrNo=StrNo+ "8 ";}break;
			case 5: {StrNo=StrNo+ "7 ";}break;
			case 6: {StrNo=StrNo+ "6 ";}break;
			case 7: {StrNo=StrNo+ "5 ";}break;
			case 8: {StrNo=StrNo+ "4 ";}break;
			case 9: {StrNo=StrNo+ "3 ";}break;
			case 10: {
				StrNo=StrNo+ "3 ";
			}
		}
	}
	
	return StrNo;
	
}
	