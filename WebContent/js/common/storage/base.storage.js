/**
 * platform JS 
 * 
 * summary:the collections storage module
 * 
 * @author Pan Shao Hua;
 * @date 2011.10.21
 */


base.ns("base").collections = {

	storage : function(tablekey) {
    	 this._this = this;
         var _this = this._this;
        this.tablekey = tablekey;
        this._arrayOfAllItems = [];
       
    }
};

base.collections.storage.prototype = {

    _this : this,
    
    _forceLoad : function () {
    	var _this = this._this;
 		var url = base.webRootPath + "/sys/cache/cachedMap/getCachedDictMap.do";
 		var postData = {
 					"tablekey": _this.tablekey
 			};
 		var options = {
 			"url": url,
 			"type": "GET",
 			"data": postData,
 			"dataType": "json",
 			"async": false,
 			"success": function(data, textStatus, jqXHR){
 				var items = data;
 				for(var i = 0 ; i <  items.length ; i++){
 					var item = items[i];	
 					_this._arrayOfAllItems.push(item);
 				}
 			}	
 		};
 		$.ajax(options);
    },

    getAllItems : function() {
    	 var _this = this._this;
    	return _this._arrayOfAllItems;
    }

 
};