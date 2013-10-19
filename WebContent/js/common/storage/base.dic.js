/**
 * platform JS 
 * 
 * summary:the dic module
 * @author Pan Shao Hua;
 * @date 2011.10.21
 */

(function(){
	
var dicVar = base.ns("base.dic");




dicVar.getEnvVarOptions = function(tablekey){

	if (tablekey == null || typeof(tablekey) == "undefined" ) {
		alert("input parameter is null!");
		return null;
	}
	var envVarStore = dicVar.getSynEnvVarStore(tablekey);
	if (envVarStore != undefined && envVarStore != null ) {
		var envVarOptions = "";
		for ( var j = 0; j < envVarStore._arrayOfAllItems.length; j++) {
			var item = envVarStore._arrayOfAllItems[j];
			if (item != null) {
				var key = item['key'];
				var value =  item['value'];
				envVarOptions = envVarOptions + key+":"+value+";";
			}
		}
		return base.utils.handlerHasLastComma(envVarOptions);
	}
	
	
};

dicVar.addEnvVarOptions = function(_selectId,tablekey,defaultOptId){

	if (tablekey == null || typeof(tablekey) == "undefined" || _selectId == null
			|| typeof(_selectId) == "undefined") {
		alert("input parameter is null!");
		return null;
	}
	var select = $("#"+_selectId); //document.getElementById(_selectId);//$('#'+_selectId); 
	if(!select){
		return false;
	}
	select.empty();
	//select.options.length = 0;
	var envVarStore = dicVar.getSynEnvVarStore(tablekey);

	if (envVarStore != undefined && envVarStore != null ) {
		for ( var j = 0; j < envVarStore._arrayOfAllItems.length; j++) {
			var item = envVarStore._arrayOfAllItems[j];
			if (item != null) {
				var key = item['key'];
				var value =  item['value'];
				//var opt = document.createElement("option");
				// TODO 根据返回的对象设置 option 的属性值.
				//opt.innerHTML = value;
				//opt.value = key;
				if($.trim(defaultOptId) == $.trim(key)){
					select.append($("<option/>").attr("selected","selected").html(value).val(key));
				}else{
					select.append($("<option/>").html(value).val(key));
				}
				
			}
		}
	}
	
	
	
};
/*
 * summary:synchronously get the client dic variable store 
 */
dicVar.getSynEnvVarStore = function(tablekey) {
	var envvarStore = new base.collections.storage(tablekey);
	envvarStore._forceLoad();
	return envvarStore;
};

/*
 * summary:get the client dic variable value by the value. 
 */
dicVar.getEnvVarkeyByvalue = function(tablekey, _propvalue) {


	if (tablekey == null || typeof(tablekey) == "undefined" || _propvalue == null
			|| typeof(_propvalue) == "undefined") {
		alert("input parameter is null!");
		return null;
	}
	var envVarStore = dicVar.getSynEnvVarStore(tablekey);
	var dm = "";
	if (envVarStore != undefined && envVarStore != null ) {
		for ( var j = 0; j < envVarStore._arrayOfAllItems.length; j++) {
			var item = envVarStore._arrayOfAllItems[j];
			if (item != null) {
				var key = item['key'];
				var value =  item['value'];
				if (value == $.trim(_propvalue)) {
					dm = key;
					break;
				}
			}
		}
	}
	return dm;

};
	
/*
 * summary:get the client dic variable value by the keys. 
 */
dicVar.getEnvVarvalueBykey = function(tablekey, _propkey) {
  
	if (tablekey == null || typeof(tablekey) == "undefined" || _propkey == null
			|| typeof(_propkey) == "undefined") {
		alert("input parameter is null!");
		return null;
	}
	var envVarStore = dicVar.getSynEnvVarStore(tablekey);
	var value = "";
	if (envVarStore != undefined && envVarStore != null ) {
		for ( var j = 0; j < envVarStore._arrayOfAllItems.length; j++) {
			var item = envVarStore._arrayOfAllItems[j];
			if (item != null) {
				var key = item['key'];
				var mc =  item['value'];
				if (key == $.trim(_propkey)) {
					value = mc;
					break;
				}
			}
		}
	}
	return value;

};
/*
 * summary:get the client dic variable value by the Store and the value. 
 */
dicVar.getEnvVarkeyByStorevalue = function(envVarStore, _propvalue) {


	if (envVarStore == null || typeof(envVarStore) == "undefined" || _propvalue == null
			|| typeof(_propvalue) == "undefined") {
		alert("input parameter is null!");
		return null;
	}
	var dm = "";
	if (envVarStore != undefined && envVarStore != null ) {

		for ( var j = 0; j < envVarStore._arrayOfAllItems.length; j++) {
			var item = envVarStore._arrayOfAllItems[j];
			
			if (item != null) {
				var key = item['key'];
				var value = item['value'];
				if (value == $.trim(_propvalue)) {
      				dm = key;
      				break;
      			}

			}
		}
	}
	return dm;
};
/*
 * summary:get the client dic variable value by the Store and the value. 
 */
dicVar.getEnvVarvalueByStorekey = function(envVarStore, _propkey) {


	if (envVarStore == null || typeof(envVarStore) == "undefined" || _propkey == null
			|| typeof(_propkey) == "undefined") {
		alert("input parameter is null!");
		return null;
	}
	var dm = "";
	if (envVarStore != undefined && envVarStore != null ) {

		for ( var j = 0; j < envVarStore._arrayOfAllItems.length; j++) {
			var item = envVarStore._arrayOfAllItems[j];
			
			if (item != null) {
				var key = item['key'];
				//var value = item['value'];
				if (key == $.trim(_propkey)) {
      				dm = key;
      				break;
      			}

			}
		}
	}
	return dm;
};
})();
