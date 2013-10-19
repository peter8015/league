/**  

 * @author Pan, Shao Hua
 * @date 2011-10-27
 * @version 1.0
 * datasheetWidget.js
 */

function DatasheetWidget(){
/**       base setup    ******/
this.table = null;
this.thead = null;
this.tbody = null;
this.mouseOverRowBgColor = null;
this.rowNumber = 1 ;
this.initTdWidth = "80px";


/****    table setup   ****/
this.cursor="default";
this.borderColor="#ababab";
this.borderRight="1px solid #ccc";
this.borderTop = "0px solid #ccc";
this.borderBottom = "1px solid #ccc";
this.borderLeft = "0px solid #ccc";
this.borderCollapse = "collapse" ;

/****    head setup         *******/
this.tableWidth = "617px";
this.columns = new Array("none");
this.ecolumns = new Array("none");
this.columnType = new Array("none");
this.columnWidth = new Array("617px");
this.widthSwitch =true;
this.headHeight = "26px";
this.headBackGroundColor="#EFEFEF";
this.headFontFamily="Tahoma, Arial";
this.headFontSize="12px";
this.headFontColor="#000000";
this.headFontWeight="bold";

/*****    body setup        ********/
this.rowHeight = "25px";
this.bodyBackGroundFirstColor="#ffffff";
this.bodyBackGroundSecondColor="#efefef";
this.bodyFontFamily="Tahoma, Arial";
this.bodyFontSize="12px";
this.bodyFontColor="#000000";
this.bodyFontWeight="normal";

/*****    hightlight setup    ********/
this.highLightColor = "#8DEEEE";
this.clickLightColor = null;

/****     option setup  ********/
this.optionWidth = "25px";
this.optionSwitch = false;

/**       align setup    ******/
this.headColumnAlign = new Array("center");
this.bodyColumnAlign = new Array("left") ;
this.dataColumns = new Array("none");

/**       grid setup      ******/
this.gridSwitch= true;
}

DatasheetWidget.prototype.initial=function(containID,tableId){
var container = document.getElementById(containID);
var table = document.createElement("table");

if(this.gridSwitch){
table.border="1px";
}else{
table.border="0px";
}
table.cellpadding="0";
table.cellspacing="0";
table.id= tableId;
table.className="DatasheetTableStyles";
table.style.position="relative";
table.style.borderCollapse=this.borderCollapse;
table.style.cursor=this.cursor;
table.style.borderRight=this.borderRight;
table.style.borderTop = this.borderTop;
table.style.borderBottom = this.borderBottom;
table.style.borderLeft = this.borderLeft;
table.borderColor=this.borderColor;
table.style.borderColor=this.borderColor;
this.table = table;
var thead = document.createElement("thead");
table.appendChild(thead);
var tbody = document.createElement("tbody");
table.appendChild(tbody);
  //create thead
    var head = this.table.getElementsByTagName("thead")[0];
    this.thead = head;
	  if (head.getElementsByTagName("tr").length == 0) {
		 var row = document.createElement("tr"); 
		 row.style.height = this.headHeight;
		 row.className = "DatasheetTableHeadStyles";
		 row.style.background= this.headBackGroundColor;
		 row.style.fontFamily = this.headFontFamily;
		 row.style.color =this.headFontColor;
		 row.style.fontWeight=this.headFontWeight;
		 for (var i = 0; i < this.columns.length; i++) {
			cell = document.createElement ("td");
			cell.className = 'sortedUp';
			
			var textDiv = document.createElement("div");	
				textDiv.id = "div0"+i;
				
				 if(this.optionSwitch&&i==0){
				textDiv.style.width = this.optionWidth;
				}else{
				    if(this.widthSwitch){
				     
				         width = parseFloat(this.columnWidth[i]);
				       
				        if(width=="-1"){     
				        textDiv.style.width = this.transformAveWidth();
				       
				        }else if(width>1 ){
				        
				        textDiv.style.width = this.columnWidth[i];
				        
				        }else if(width>0&&width<1){
				        
				         
				        textDiv.style.width = parseFloat(this.tableWidth)*width+"px";
				        
				        }else{
				        alert("your setup is error!");
				        }
				      
				      
				    
				    }else{
				    
				        var initTdWidth = this.calcuAveWidth(); 
				        this.initTdWidth = initTdWidth;
				        textDiv.style.width = initTdWidth;
				    }
				    
				    
				}
				textDiv.style.overflow = "hidden";
				textDiv.style.fontSize = this.headFontSize;
			
				 if(document.all&&document.getElementById){
			 
			    textDiv.className = "nowrapsh";
			    }
			
				var text = this.columns[i];
				
				textDiv.innerHTML = text ;
				cell.setAttribute("id",text);
				cell.appendChild(textDiv);
			
			 
			 
			cell.style.padding="2px";
			cell.style.fontsize="2px";
			cell.style.fontFamily="Tahoma, Arial";
			cell.style.textAlign=this.headColumnAlign[i];
			cell.setAttribute("nowrap","true");
			row.appendChild(cell);
		}
		 head.appendChild(row);
		}
//create tbody
    var tbody = this.table.getElementsByTagName("tbody")[0];
    this.tbody = tbody;
    	
	  container.appendChild(table);
	 
	  
 }	,



/**************event part******************************************/
DatasheetWidget.prototype.addEv = function(element, eventName, funcName){
	  if (element.attachEvent) { 
		element.attachEvent("on" + eventName, funcName);
	  } else if (element.addEventListener) { 
		element.addEventListener(eventName, funcName, true);
	  } else {
		element["on" + eventName] = funcName;
	  }
},
DatasheetWidget.prototype.delEv = function(element,eventName,funcName){
     if (element.detachEvent) { 
		element.detachEvent("on" + eventName, funcName);
	 } else if (element.removeEventListener) {
		element.removeEventListener(eventName, funcName, true);
	 } else {
		element["on" + eventName] = null;
	 }
},
DatasheetWidget.prototype.clearData = function(){
	
	var obj = this.table;
	if(obj != null){
		for(var i=obj.rows.length-1; i>0; i--) {
		obj.deleteRow(i);
		}
	}

},

DatasheetWidget.prototype.getAllData = function(){
	
	var eTable = this.table;
	var theadrow = eTable.tHead.childNodes[0]; 
	var tableColCount = theadrow.childNodes.length;
	//var tableString = "[";
	var rowString = "[";
	if(eTable != null){
		
		for(var i=eTable.rows.length-1; i>0; i--) {
		var trElem = eTable.rows[i];
		var tdString = "{";
		for(var j = 0 ; j < tableColCount ; j++){
			var tdElem = trElem.childNodes[j];
			var col = tdElem.getAttribute("column"); 
			var coltype = tdElem.getAttribute("coltype");
			var val = "";
			if(coltype == "none"){
			   val = tdElem.firstChild.innerHTML;
			}else if(coltype == "input"){
				val = tdElem.firstChild.getElementsByTagName("input")[0].value;
			}else if(coltype == "select"){
				
			}else{
				val = tdElem.firstChild.innerHTML;
			}

			  if(col!='operation'){
				  tdString = tdString + col+":\""+val+"\",";
			  }	
			}
		rowString=rowString + jadl.utils.handlerHasLastComma(tdString) +"},";
		 //console.log(tdString);
		 //rowString = tdString +"";
		
		}
		 //rowString = tdString +"";
		rowString = jadl.utils.handlerHasLastComma(rowString) ; 
		// console.log(rowString);
	}
	rowString = rowString + "]";
  return rowString;
},

DatasheetWidget.prototype.getAllDataSize = function(){
	
	var eTable_data = this.getAllData();
	var dataObj=eval("("+eTable_data+")");
	if(dataObj!=null && typeof(dataObj)!="undefine" ){
		return dataObj.length;
	}else{
		return 0;
	}
},

DatasheetWidget.prototype.getColValDataSize = function(col,val){
	var eTable_data = this.getAllData();
	var dataObj=eval("("+eTable_data+")");
    var count = 0 ;
   	for(var i = 0 ; i <= dataObj.length ; i++){
   		var dataO = dataObj[i];
   		if(dataO!=null && typeof(dataO)!="undefine" ){
   			for (var key in dataO)
   			{
   			  if(key == col){
   				if(dataO[key]==val){
   					count = count + 1;
   				}
   			  }
   			}
   		}		  	
   	}
  return count;
},

 DatasheetWidget.prototype.getTableHeight = function(){
 var h = this.table.offsetHeight;
 return h;
 },
 DatasheetWidget.prototype.getTableWidth = function(){
 var w = this.table.offsetWidth;
 return w;
 },
 
 DatasheetWidget.prototype.addDataRow = function(valueArray,key){
         var row = document.createElement ("tr");
         row.style.height=this.rowHeight;
         row.style.backgroundcolor = this.bodyBackGroundColor;
		 row.style.fontFamily = this.bodyFontFamily;
		 row.style.color =this.bodyFontColor;
		 row.style.fontWeight=this.bodyFontWeight;
        for(var i = 0 ; i < valueArray.length ; i++){
			cell = document.createElement ("td");
			var textDiv = document.createElement("div");	
				textDiv.id = "div"+this.rowNumber+i;
				// alert(this.table.offsetWidth/this.columns.length);
				 if(this.optionSwitch&&i==0){
				textDiv.style.width = this.optionWidth;
				}else{
				 if(this.widthSwitch){ 
				 
				     var width = parseFloat(this.columnWidth[i]);
				        
				        if(width=="-1"){     
				        textDiv.style.width = this.transformAveWidth();
				       
				        }else if(width>1 ){
				        
				        textDiv.style.width = this.columnWidth[i];
				        
				        }else if(width>0&&width<1){
				        
				         
				        textDiv.style.width = parseFloat(this.tableWidth)*width+"px";
				      
				        }else{
				        alert("your setup is error!");
				        }

				    }else{		    
				        var initTdWidth = this.calcuAveWidth(); 
				        this.initTdWidth = initTdWidth;
				        textDiv.style.width = initTdWidth;
				    }
				}
				
				textDiv.style.overflow = "hidden";
				textDiv.style.fontSize = this.bodyFontSize;
			
				 if(document.all&&document.getElementById){
			
			    textDiv.className = "nowrapsh";
			    }
		
				var  text = valueArray[i];
				textDiv.innerHTML = text ;
				
				cell.appendChild(textDiv);
			  var column = this.ecolumns[i];
			  var columnType = this.columnType[i];
			cell.style.padding="2px";
			cell.style.fontsize="2px";
			cell.style.fontFamily="Tahoma, Arial";
			cell.style.textAlign=this.bodyColumnAlign[i];
			cell.setAttribute("nowrap","true");
			cell.setAttribute("column",column);
			cell.setAttribute("coltype", columnType);
			row.appendChild(cell);
		
			}
			
		var tbody = this.tbody;
		
		if(parseInt(this.rowNumber)%2 != 0 ){
		row.className="bodyBackGroundFirstColor";
				}else{
		row.className="bodyBackGroundSecondColor";
				}
		row.setAttribute("id",key);
		tbody.appendChild(row);
		this.addEv(row,"mouseover",this.highLightRow);
	    this.addEv(row,"mouseout",this.lowLightRow);
		this.rowNumber = this.rowNumber + 1;
},

DatasheetWidget.prototype.addFirstDataRow = function(valueArray,key){
    var row=  this.table.insertRow(1) ;
     row.style.height=this.rowHeight;
     row.style.backgroundcolor = this.bodyBackGroundColor;
	 row.style.fontFamily = this.bodyFontFamily;
	 row.style.color =this.bodyFontColor;
	 row.style.fontWeight=this.bodyFontWeight;
   for(var i = 0 ; i < valueArray.length ; i++){
		cell = document.createElement ("td");
		var textDiv = document.createElement("div");	
			textDiv.id = "div"+this.rowNumber+i;
			// alert(this.table.offsetWidth/this.columns.length);
			 if(this.optionSwitch&&i==0){
			textDiv.style.width = this.optionWidth;
			}else{
			 if(this.widthSwitch){ 
			 
			     var width = parseFloat(this.columnWidth[i]);
			        
			        if(width=="-1"){     
			        textDiv.style.width = this.transformAveWidth();
			       
			        }else if(width>1 ){
			        
			        textDiv.style.width = this.columnWidth[i];
			        
			        }else if(width>0&&width<1){
			        
			         
			        textDiv.style.width = parseFloat(this.tableWidth)*width+"px";
			      
			        }else{
			        alert("your setup is error!");
			        }

			    }else{		    
			        var initTdWidth = this.calcuAveWidth(); 
			        this.initTdWidth = initTdWidth;
			        textDiv.style.width = initTdWidth;
			    }
			}
			
			textDiv.style.overflow = "hidden";
			textDiv.style.fontSize = this.bodyFontSize;
		
			 if(document.all&&document.getElementById){
		
		    textDiv.className = "nowrapsh";
		    }
	
			var  text = valueArray[i];
			textDiv.innerHTML = text ;
			
			cell.appendChild(textDiv);
		  var column = this.ecolumns[i];
		  var columnType = this.columnType[i];
		cell.style.padding="2px";
		cell.style.fontsize="2px";
		cell.style.fontFamily="Tahoma, Arial";
		cell.style.textAlign=this.bodyColumnAlign[i];
		cell.setAttribute("nowrap","true");
		cell.setAttribute("column",column);
		cell.setAttribute("coltype", columnType);
		row.appendChild(cell);
	
		}
		
	var tbody = this.tbody;
	
	if(parseInt(this.rowNumber)%2 != 0 ){
	row.className="bodyBackGroundFirstColor";
			}else{
	row.className="bodyBackGroundSecondColor";
			}
	row.setAttribute("id",key);
	//tbody.appendChild(row);
	this.addEv(row,"mouseover",this.highLightRow);
    this.addEv(row,"mouseout",this.lowLightRow);
	this.rowNumber = this.rowNumber + 1;
},	

/**************high light part******************************************/
DatasheetWidget.prototype.highLightRow = function(ev){
       var srcElem =  ev.srcElement || ev.target ;
       while(srcElem.tagName!="TR"&&srcElem.tagName!="TABLE"){
       srcElem = srcElem.parentNode;
       }
       if (srcElem.tagName != "TR") return;
       this.mouseOverRowBgColor = srcElem.style.backgroundColor;
	   srcElem.style.backgroundColor = "#FFFFBB";		
},
DatasheetWidget.prototype.lowLightRow = function(ev){
       var srcElem =  ev.srcElement || ev.target ;
       while(srcElem.tagName!="TR"&&srcElem.tagName!="TABLE"){
       srcElem = srcElem.parentNode;
       }
       if (srcElem.tagName != "TR") return;
	   srcElem.style.backgroundColor =  this.mouseOverRowBgColor ;
},

  
DatasheetWidget.prototype.getEvRow = function(ev){
      var srcElem =  ev.srcElement || ev.target ;
      while(srcElem.tagName!="TR"&&srcElem.tagName!="TABLE"){
      srcElem = srcElem.parentNode;
       }
      return srcElem;
},

DatasheetWidget.prototype.calcuAveWidth = function(){
   if(this.tableWidth==null||this.tableWidth=='undefined'){
    alert("you must setup the table width!");
    return false;
   }
   if(this.columns.length == 0){
    alert("you must setup the table head columns");
    return false;
    }
   var averageWidth = 0;
   if(this.columnWidth.length>0&&this.columns.length>0&&this.columns.length==this.columnWidth.length){
      averageWidth = parseFloat(this.tableWidth)/this.columns.length;

   }
   return averageWidth+"px";

},

/*transform width setup   new Array("-1","-1","20px","50px","-1","30%")  */
DatasheetWidget.prototype.transformAveWidth = function(){

  if(this.tableWidth==null||this.tableWidth=='undefined'){
    alert("you must setup the table width!");
    return false;
  }
  if(this.columns.length == 0){
    alert("you must setup the table head columns");
    return false;
   }
   var count = 0 ;
   var headP = 0 ;
   var headN = 0 ;
   var tableWidthLeft = 0;
   var averageWidth = 0;
  if(this.columnWidth.length>0&&this.columns.length>0&&this.columns.length==this.columnWidth.length){
    for(var i = 0 ;  i < this.columnWidth.length ; i++){
     try{
     var head = parseFloat(this.columnWidth[i]);
      if(head=="-1"){
       count = count + 1;
      }
      if(0<head&&head<1){
       headP = headP + parseInt(this.tableWidth)*head;
      }
      if(head>=1){
       headN =  headN + head ;
      }

      }catch(e){
         alert(e.message);
      }
    }
       
  }else{
    alert("you must setup your tableWidth!");
    return false;
  }
   
  tableWidthLeft = parseFloat(this.tableWidth)-headP-headN;
  averageWidth = tableWidthLeft/count;
  return averageWidth+"px" ;   
};

	
	

	
  
 


    
	
	
	