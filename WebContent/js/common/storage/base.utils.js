/**
 * platform JS 
 * 
 * summary:the utils module
 * @author Pan Shao Hua;
 * @date 2011.10.21

 */
(function() {

	var utils = base.ns("base.utils");

	
	
	utils.handlerHasLastComma = function(inputStr) {
		var regex = /.*,\s*$/;
		var lastCommaPos = inputStr.lastIndexOf(",");
		if (regex.test(inputStr)) {
			inputStr = inputStr.substring(0, lastCommaPos);
		}
		return inputStr;
	};

})();
