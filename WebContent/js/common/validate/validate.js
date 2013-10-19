/* WebUI-Validate version 1.2.0 */
function ui_validate(frmName) {
	this.frmName = frmName;
	this.paramList = [];
	this.ErrorMsgType = 1;
	this.ErrorPause = false;
	this.SameIdErrorPause = false;
	this.ChildErrorShow = true;
	this.FocusBackFlag = false;
	this.Focusing = function() {
		this.Obj = null;
		this.Flag = false;
	};
	this._BindToEle = true;
	this._Submit = false;
	this._SubmitFun = null;
	this._Reset = false;
	this._ResetFun = null;
}

ui_validate.prototype.add = function(targetObj, errorstr, chrarray, profun,
		aftfun) {
	// --------------------------
	var checkelementall = function(targetObj, errorstr, checkstring, profun,
			aftfun) {
		var checkreturn = true;
		if (typeof (checkstring) == "object") {
			for ( var i = 0; i < checkstring.length; i++) {
				if (checkelement(targetObj, errorstr, checkstring[i], profun,
						aftfun, i) == false)
					checkreturn = false;
				if ((SameIdErrorPause == false) && (checkreturn == false))
					break;
			}
		} else {
			checkreturn = checkelement(targetObj, errorstr, checkstring,
					profun, aftfun, 0);
		}
		return checkreturn;
	}
	// --------------------------
	var checkelement = function(targetObj, errorstr, checkstring, profun,
			aftfun, doId) {
		function newDate(dateStr) {
			if (!((dateStr
					.match(/^((((1[0-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29))$/) != null)
					|| (dateStr
							.match(/^((((1[0-9]|[2-9]\d)\d{2})\/(0?[13578]|1[02])\/(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})\/(0?[13456789]|1[012])\/(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})\/0?2\/(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))\/0?2\/29))$/) != null)
					|| (dateStr
							.match(/^((((1[0-9]|[2-9]\d)\d{2})(0?[13578]|1[02])(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})(0?[13456789]|1[012])(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})0?2(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))0?229))$/) != null) || (dateStr
					.match(/^((((1[0-9]|[2-9]\d)\d{2})\.(0?[13578]|1[02])\.(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})\.(0?[13456789]|1[012])\.(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})\.0?2\.(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))\.0?2\.29))$/) != null)))
				return NaN;
			if (dateStr.split(".").length == 3)
				var arr = dateStr.split(".");
			else if (dateStr.split("/").length == 3)
				var arr = dateStr.split("/");
			else if (dateStr.split("-").length == 3)
				var arr = dateStr.split("-");
			else
				var arr = new Array(dateStr.substr(0, 4), dateStr.substr(4, 4),
						dateStr.substr(6, 4));
			return new Date(arr.join("/"));
		}
		var elevalue = "";
		var i = 0;
		var j = 0;
		var checkstr = checkstring.toString();
		var eleObj = targetObj;
		if (typeof (targetObj) == "string")
			eleObj = document.getElementById(targetObj);
		if ((focusbackflag == true) && (focusing.Flag == true)
				&& (focusing.Obj != eleObj)) {
			focusing.Flag = false;
			return;
		}
		if (focusbackflag == true) {
			focusing.Flag = true;
			focusing.Obj = eleObj;
		} else {
			focusing.Flag = false;
			focusing.Obj = null;
		}
		if (typeof (profun) == "function") {
			try {
				profunobj = eval(profun);
			} catch (e) {
				alert("Profunction error!");
				return false;
			}
			profunobj(eleObj);
		}
		switch (eleObj.tagName.toLowerCase()) {
		case "input":
			switch (eleObj.type.toLowerCase()) {
			case "text":
				elevalue = eleObj.value;
				break;
			case "password":
				elevalue = eleObj.value;
				break;
			case "file":
				elevalue = eleObj.value;
				break;
			case "hidden":
				elevalue = eleObj.value;
				break;
			case "checkbox":
				elevalue = eleObj.checked;
				break;
			case "radio":
				elevalue = eleObj.checked;
				break;
			}
			break;
		case "textarea":
			elevalue = eleObj.value;
			break;
		}
		;
		errmsgList = [];
		while (true) {
			ErrStr = "";
			i = checkstr.indexOf("[", 0);
			if (i < 0)
				break;
			j = checkstr.indexOf("]", i)
			if ((j < 0) && (j - i <= 1))
				break;
			argarray = checkstr.slice(i + 1, j).split(",");
			checkreturn = false;
			switch (argarray[0].toString().toLowerCase()) {
			case "checkintno10":
				ErrStr = "Not integer10 input";
				var re = new RegExp("^(([0]{1})|([1-9]{1}[0-9]{0,9}))$", "g");
				checkreturn = re.test(elevalue);
				;
				break;
			case "checkno10":
				ErrStr = "Not integer10 input";
				var re = new RegExp(
						"^(([0]{1})|([1-9]{1}[0-9]{0,9})|([0]{1}[.][0-9]{1,2})|([1-9]{1}[0-9]{0,9}[.][0-9]{1,2}))$",
						"g");
				checkreturn = re.test(elevalue);
				;
				break;
			case "checkno_10":
				ErrStr = "Not integer10 input";
				var re = new RegExp(
						"^(([0]{1}[.][0-9]{1,2})|([1-9]{1}[0-9]{0,9}[.][0-9]{1,2}))$",
						"g");
				checkreturn = re.test(elevalue);
				;
				break;
			case "checkintno6":
				ErrStr = "Not integer6 input";
				var re = new RegExp("^(([0]{1})|([1-9]{1}[0-9]{0,5}))$", "g");
				checkreturn = re.test(elevalue);
				;
				break;
			case "checkno6":
				ErrStr = "Not integer6 input";
				var re = new RegExp(
						"^(([0]{1})|([1-9]{1}[0-9]{0,5})|([0]{1}[.][0-9]{1,2})|([1-9]{1}[0-9]{0,5}[.][0-9]{1,2}))$",
						"g");
				checkreturn = re.test(elevalue);
				;
				break;
			case "checkno_6":
				ErrStr = "Not integer60 input";
				var re = new RegExp(
						"^(([0]{1}[.][0-9]{1,2})|([1-9]{1}[0-9]{0,5}[.][0-9]{1,2}))$",
						"g");
				checkreturn = re.test(elevalue);
				;
				break;
			case "checkintno3":
				ErrStr = "Not integer3 input";
				var re = new RegExp("^(([0]{1})|([1-9]{1}[0-9]{0,2}))$", "g");
				checkreturn = re.test(elevalue);
				;
				break;
			case "checkno3":
				ErrStr = "Not integer10 input";
				var re = new RegExp(
						"^(([0]{1})|([1-9]{1}[0-9]{0,2})|([0]{1}[.][0-9]{1,2})|([1-9]{1}[0-9]{0,2}[.][0-9]{1,2}))$",
						"g");
				checkreturn = re.test(elevalue);
				;
				break;
			case "checkno_3":
				ErrStr = "Not integer3 input";
				var re = new RegExp(
						"^(([0]{1}[.][0-9]{1,2})|([1-9]{1}[0-9]{0,2}[.][0-9]{1,2}))$",
						"g");
				checkreturn = re.test(elevalue);
				;
				break;
			case "int": // Integer
				ErrStr = "Not integer input";
				checkreturn = ((elevalue.toString() == '') || (elevalue
						.match(/^-?\d+$/) != null && elevalue
						.match(/^-?[0]\d+$/) == null)) ? true : false;
				break;
			case "float": // Decimal
				ErrStr = "Not for the input decimal value";
				checkreturn = ((elevalue.toString() == '') || (elevalue
						.match(/^(-?\d+)(\.\d+)$/) != null && elevalue
						.match(/^(-?[0]\d+)(\.\d+)?$/) == null)) ? true : false;
				break;
			case "floatlength": // Decimal Part Length
				ErrStr = "Not for the input decimal part value";
				checkreturn = ((elevalue.toString() == '') || (elevalue
						.match(/^(-?\d+)(\.\d+)$/) != null && elevalue
						.match(/^(-?[0]\d+)(\.\d+)?$/) == null)) ? true : false;
				if (!checkreturn) {
					checkreturn = false;
					break;
				}
				checkreturn = false;
				var ev = elevalue.length - elevalue.indexOf(".") - 1;
				if (isNaN(ev) == true)
					break;
				var cv = parseFloat(argarray[2].toString());
				if (isNaN(cv) == true)
					break;
				switch (argarray[1].toString()) {
				case "=":
					if (ev == cv)
						checkreturn = true;
					break;
				case ">":
					if (ev > cv)
						checkreturn = true;
					break;
				case "<":
					if (ev < cv)
						checkreturn = true;
					break;
				case ">=":
					if (ev >= cv)
						checkreturn = true;
					break;
				case "<=":
					if (ev <= cv)
						checkreturn = true;
					break;
				case "!=":
					if (ev != cv)
						checkreturn = true;
					break;
				default:
					alert("unexpected error(0002)");
					break;
				}
				break;
			case "scale": // Numerical scope
				ErrStr = "Import value is not of the scope";
				if (argarray.length < 3)
					break;
				if (elevalue.toString() == '') {
					checkreturn == true;
					break;
				}
				if (((elevalue.match(/^-?\d+$/) != null && elevalue
						.match(/^-?[0]\d+$/) == null) || (elevalue
						.match(/^(-?\d+)(\.\d+)$/) != null && elevalue
						.match(/^(-?[0]\d+)(\.\d+)?$/) == null)) == false)
					break;
				ev = parseFloat(elevalue.toString());
				if (isNaN(ev) == true)
					break;
				cv = parseFloat(argarray[2].toString());
				if (isNaN(cv) == true)
					break;
				switch (argarray[1].toString()) {
				case "=":
					if (ev == cv)
						checkreturn = true;
					break;
				case ">":
					if (ev > cv)
						checkreturn = true;
					break;
				case "<":
					if (ev < cv)
						checkreturn = true;
					break;
				case ">=":
					if (ev >= cv)
						checkreturn = true;
					break;
				case "<=":
					if (ev <= cv)
						checkreturn = true;
					break;
				case "!=":
					if (ev != cv)
						checkreturn = true;
					break;
				default:
					alert("unexpected error(0002)");
					break;
				}
				break;
			case "null": // Empty string
				ErrStr = "Import value is not empty string";
				checkreturn = (elevalue.toString() == '') ? true : false;
				break;
			case "notnull": // Non-empty string
				ErrStr = "Import value is not a non-empty string";
				checkreturn = (!(elevalue.toString() == '')) ? true : false;
				break;
			case "numstring": // Number string
				ErrStr = "Import value is not a Number string";
				if (elevalue.match(/^([0-9]+)$/) != null)
					checkreturn = true;
				break;
			case "length": // Fixed-length string
				ErrStr = "Import value not specified length";
				if (argarray.length < 3)
					break;
				lenv = parseInt(argarray[2].toString());
				if (isNaN(lenv) == true)
					break;
				switch (argarray[1].toString()) {
				case "=":
					if (elevalue.length == lenv)
						checkreturn = true;
					break;
				case "!=":
					if (elevalue.length != lenv)
						checkreturn = true;
					break;
				case ">":
					if (elevalue.length > lenv)
						checkreturn = true;
					break;
				case ">=":
					if (elevalue.length >= lenv)
						checkreturn = true;
					break;
				case "<":
					if (elevalue.length < lenv)
						checkreturn = true;
					break;
				case "<=":
					if (elevalue.length <= lenv)
						checkreturn = true;
					break;
				default:
					alert("unexpected error(0003)");
					break;
				}
				break;
			case "date": // Date format yyyy-mm-dd
				ErrStr = "No entry date format";
				if (elevalue.toString() == '') {
					checkreturn = true;
					break;
				}
				if (argarray.length < 2)
					break;
				switch (argarray[1].toString()) {
				case "yyyy-mm-dd":
					if (elevalue
							.match(/^((((1[0-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29))$/) != null)
						checkreturn = true;
					break;
				case "yyyy/mm/dd":
					if (elevalue
							.match(/^((((1[0-9]|[2-9]\d)\d{2})\/(0?[13578]|1[02])\/(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})\/(0?[13456789]|1[012])\/(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})\/0?2\/(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))\/0?2\/29))$/) != null)
						checkreturn = true;
					break;
				case "yyyymmdd":
					if (elevalue
							.match(/^((((1[0-9]|[2-9]\d)\d{2})(0?[13578]|1[02])(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})(0?[13456789]|1[012])(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})0?2(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))0?229))$/) != null)
						checkreturn = true;
					break;
				case "yyyy.mm.dd":
					if (elevalue
							.match(/^((((1[0-9]|[2-9]\d)\d{2})\.(0?[13578]|1[02])\.(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})\.(0?[13456789]|1[012])\.(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})\.0?2\.(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))\.0?2\.29))$/) != null)
						checkreturn = true;
					break;
				case "*":
					if ((elevalue
							.match(/^((((1[0-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29))$/) != null)
							|| (elevalue
									.match(/^((((1[0-9]|[2-9]\d)\d{2})\/(0?[13578]|1[02])\/(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})\/(0?[13456789]|1[012])\/(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})\/0?2\/(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))\/0?2\/29))$/) != null)
							|| (elevalue
									.match(/^((((1[0-9]|[2-9]\d)\d{2})(0?[13578]|1[02])(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})(0?[13456789]|1[012])(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})0?2(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))0?229))$/) != null)
							|| (elevalue
									.match(/^((((1[0-9]|[2-9]\d)\d{2})\.(0?[13578]|1[02])\.(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})\.(0?[13456789]|1[012])\.(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})\.0?2\.(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))\.0?2\.29))$/) != null))
						checkreturn = true;
					break;
				default:
					alert("unexpected error(0004)");
					break;
				}
				break;
			case "time": // Time format,hh:mm:ss
				ErrStr = "Entry not the time format";
				if ((elevalue.toString() == '')
						|| (elevalue
								.match(/^([0-1]\d|2[0-3]):[0-5]\d:[0-5]\d$/) != null))
					checkreturn = true;
				break;
			case "datetime": // Date Time Format,yyyy-mm-dd hh:mm:ss
				ErrStr = "Import value is not the time for the date format";
				if ((elevalue.toString() == '')
						|| (elevalue
								.match(/^((((1[0-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29))(\s)(([0-1]\d|2[0-3]):[0-5]\d:[0-5]\d)$/) != null))
					checkreturn = true;
				break;
			case "comparedate": // Comparison date
				ErrStr = "Enter the date does not meet conditions";
				if (argarray.length == 2) {
					var d1 = newDate(elevalue.toString());
					var d2 = newDate(document.getElementById(argarray[1]
							.toString()).value);
					if (isNaN(d1) || isNaN(d2)) {
						checkreturn = true;
						break;
					}
					if (Date.parse(d1) - Date.parse(d2) == 0)
						checkreturn = true;
					break;
				}
				if (argarray.length > 2) {
					var d1 = newDate(elevalue.toString());
					var d2 = newDate(document.getElementById(argarray[2]
							.toString()).value);
					if (isNaN(d1) || isNaN(d2)) {
						checkreturn = true;
						break;
					}
					switch (argarray[1].toString()) {
					case "=":
						if (Date.parse(d1) - Date.parse(d2) == 0)
							checkreturn = true;
						break;
					case "!=":
						if (Date.parse(d1) - Date.parse(d2) != 0)
							checkreturn = true;
						break;
					case ">":
						if (Date.parse(d1) - Date.parse(d2) > 0)
							checkreturn = true;
						break;
					case ">=":
						if (Date.parse(d1) - Date.parse(d2) >= 0)
							checkreturn = true;
						break;
					case "<":
						if (Date.parse(d1) - Date.parse(d2) < 0)
							checkreturn = true;
						break;
					case "<=":
						if (Date.parse(d1) - Date.parse(d2) <= 0)
							checkreturn = true;
						break;
					default:
						alert("unexpected error(0009)");
						break;
					}
					break;
				}
			case "email": // E-mail format whitezdm@163.com
				ErrStr = "Entry format is not for E-mail format";
				if ((elevalue.toString() == '')
						|| (elevalue
								.match(/\w{1,}[@][\w\-]{1,}([.]([\w\-]{1,})){1,3}$/) != null))
					checkreturn = true;
				break;
			case "equaltext": // Equivalent to the text of other cells
				ErrStr = "Import value is not equal to other cells";
				if (elevalue.toString() == '') {
					checkreturn = true;
					break;
				}
				if (argarray.length < 2)
					break;
				if (elevalue.toString() == document.getElementById(argarray[1]
						.toString()).value)
					checkreturn = true;
				break;
			case "compare": // Enter text comparison
				ErrStr = "Entry does not meet the requirements";
				if (argarray.length == 2) {
					if (elevalue.toString() == argarray[1].toString())
						checkreturn = true;
					break;
				}
				if (argarray.length > 2) {
					cmpValue = argarray[2].toString();
					switch (argarray[1].toString()) {
					case "=":
						if (elevalue.toString() == cmpValue)
							checkreturn = true;
						break;
					case "!=":
						if (elevalue.toString() != cmpValue)
							checkreturn = true;
						break;
					case ">":
						if (elevalue.toString() > cmpValue)
							checkreturn = true;
						break;
					case ">=":
						if (elevalue.toString() >= cmpValue)
							checkreturn = true;
						break;
					case "<":
						if (elevalue.toString() < cmpValue)
							checkreturn = true;
						break;
					case "<=":
						if (elevalue.toString() <= cmpValue)
							checkreturn = true;
						break;
					default:
						alert("unexpected error(0008)");
						break;
					}
					break;
				}
			case "mobilenumber": // Mobile phone format
				ErrStr = "Import value is not as mobile phone format";
				if ((elevalue.toString() == '')
						|| (elevalue.match(/^(13|15)\d{9}$/) != null))
					checkreturn = true;
				break;
			case "phonenumber": // Fixed-line format 010-1234567
				ErrStr = "Import value is not a fixed telephone format";
				if ((elevalue.toString() == '')
						|| (elevalue.match(/^\d+-\d+$/) != null))
					checkreturn = true;
				break;
			case "moblileorphone": // 电话或者移动电话
				if ((elevalue.toString() == '')
						|| (elevalue.match(/^(13|15)\d{9}$/) != null)
						|| (elevalue.match(/^\d+-\d+$/) != null))
					checkreturn = true;
				break;
			case "idcardcode": // 身份证15位或者18位最后可以带小写或者大写的x
				if ((elevalue.toString() == '')
						|| (elevalue
								.match(/^(\d{6})(18|19|20)?(\d{2})([01]\d)([0123]\d)(\d{3})(\d|x|X)?$/)) != null)
					checkreturn = true;
				break;
			case "zipcode": // Postcode format
				ErrStr = "Import value is not the Zip postcode format";
				if ((elevalue.toString() == '')
						|| (elevalue.match(/^\d{6}$/) != null))
					checkreturn = true;
				break;
			case "ascchar": // ASC list characters
				ErrStr = "Import value is not within the ASC list characters";
				if ((elevalue.toString() == '')
						|| (elevalue.match(/^[\x00-\xff]+$/) != null))
					checkreturn = true;
				break;
			case "ipaddress": // IP address format
				ErrStr = "Import value is not an IP address format";
				if ((elevalue.toString() == '')
						|| (elevalue
								.match(/^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$/) != null))
					checkreturn = true;
				break;
			case "selected": // Select the choice, what is the value
				ErrStr = "Select values do not meet the requirement";
				if (eleObj.selectedIndex < 0)
					break;
				if (argarray.length == 1) {
					checkreturn = true;
					break;
				}
				if (argarray.length == 2) {
					if (eleObj.options[eleObj.selectedIndex].value == argarray[1]
							.toString())
						checkreturn = true;
					break;
				}
				if (argarray.length > 2) {
					selectedValue = eleObj.options[eleObj.selectedIndex].value;
					cmpValue = argarray[2].toString();
					switch (argarray[1].toString()) {
					case "=":
						if (selectedValue == cmpValue)
							checkreturn = true;
						break;
					case "!=":
						if (selectedValue != cmpValue)
							checkreturn = true;
						break;
					case ">":
						if (selectedValue > cmpValue)
							checkreturn = true;
						break;
					case ">=":
						if (selectedValue >= cmpValue)
							checkreturn = true;
						break;
					case "<":
						if (selectedValue < cmpValue)
							checkreturn = true;
						break;
					case "<=":
						if (elevalue.length <= cmpValue)
							checkreturn = true;
						break;
					default:
						alert("unexpected error(0007)");
						break;
					}
					break;
				}
			case "checked": // checked
				ErrStr = "Choose an error";
				var cmpvalue = "";
				if (argarray[1].toString() == "true")
					cmpvalue = true;
				if (argarray[1].toString() == "false")
					cmpvalue = false;
				if (elevalue == cmpvalue)
					checkreturn = true;
				else
					checkreturn = false;
				break;
			default:
				var args = new function() {
					this.element = document.getElementById(targetObj);
					this.list = new Array();
					this.listcount = 0;
					for ( var k = 1; k < argarray.length; k++) {
						this.list[this.list.length] = argarray[k];
						this.listcount = this.list.length;
					}
				};
				try {
					funobj = eval(argarray[0].toString());
				} catch (e) {
					checkreturn = false;
					alert("tag function error!");
					break;
				}
				checkreturn = funobj(args) ? true : false;
				break;
			}
			if ((errorflag == true) && (checkreturn == false) && (ErrStr != ""))
				errmsgList
						.push( [ argarray[0].toString().toLowerCase(), ErrStr ]);
			midStr = (checkreturn == true) ? "true" : "false";
			preStr = aftStr = "";
			if (i > 0)
				preStr = checkstr.slice(0, i);
			if (j < checkstr.length - 1)
				aftStr = checkstr.slice(j + 1);
			checkstr = preStr + midStr + aftStr;
		}
		try {
			evalvalue = eval(checkstr);
		} catch (e) {
			evalvalue = false;
		}
		checkstr = "";
		if ((focusbackflag == true) && (evalvalue == false))
			eleObj.focus();
		else {
			focusing.Flag = false;
			focusing.Obj = null;
		}
		if (typeof (errorstr) == "function") {
			try {
				funerrorobj = eval(errorstr);
			} catch (e) {
				alert("error message function error!");
				return;
			}
			var args = new function() {
				this.element = eleObj;
				this.sign = evalvalue;
				this.errorid = doId;
				this.errmsgList = errmsgList;
			};
			funerrorobj(args);
		} else {
			switch (msgtype) {
			case 1:
				if (eleObj.validate == false)
					if (window.ActiveXObject)
						eleObj.nextSibling.removeNode(true);
					else
						eleObj.parentNode.removeChild(eleObj.nextSibling);
				if (evalvalue == false) {
					var oNewNode = document.createElement("div");
					oNewNode.className = "msgerror";
					if (eleObj.parentNode.lastChild == eleObj)
						eleObj.parentNode.appendChild(oNewNode);
					else
						eleObj.parentNode.insertBefore(oNewNode,
								eleObj.nextSibling);
					ErrorString = "";
					for (i = 0; i < errmsgList.length; i++)
						ErrorString += "<br/>" + errmsgList[i][1];
					oNewNode.innerHTML = errorstr + ErrorString;
					eleObj.className = "fail";
				} else
					eleObj.className = "passed";
				eleObj.validate = evalvalue;
				break;
			case 2:
				if (evalvalue == false) {
					eleObj.className = "fail";
					ErrorString = "";
					for (i = 0; i < errmsgList.length; i++)
						ErrorString += "\n" + errmsgList[i][1];
					alert(errorstr.replace(/\<br\/\>/g, "\n") + ErrorString);
				} else
					eleObj.className = "passed";
				break;
			}
		}
		if (typeof (aftfun) == "function") {
			try {
				aftfunobj = eval(aftfun);
			} catch (e) {
				alert("Aftfunction error!");
				return false;
			}
			aftfunobj(eleObj);
		}
		return evalvalue;
	}
	this.chkelement = checkelement;
	this.checkelementall = checkelementall;
	var msgtype = this.ErrorMsgType;
	var errorflag = this.ChildErrorShow;
	var focusbackflag = this.FocusBackFlag;
	var focusing = this.Focusing;
	var SameIdErrorPause = this.SameIdErrorPause;
	if (this.paramList.length == 0)
		this.paramList.push( [
				targetObj,
				errorstr,
				chrarray,
				profun,
				aftfun,
				function() {
					checkelementall(targetObj, errorstr, chrarray, profun,
							aftfun)
				} ]);
	else
		for ( var i = 0; i < this.paramList.length; i++) {
			if (((typeof (targetObj) == "string") && (this.paramList[i][0]
					.toString().toLowerCase() == targetObj.toLowerCase()))
					|| ((typeof (targetObj) == "object") && (this.paramList[i][0] == targetObj))) {
				alert("error 0005");
				return;
			}
			if (i == this.paramList.length - 1) {
				this.paramList.push( [
						targetObj,
						errorstr,
						chrarray,
						profun,
						aftfun,
						function() {
							checkelementall(targetObj, errorstr, chrarray,
									profun, aftfun)
						} ]);
				break;
			}
		}
	if (this._BindToEle == true)
		this.bindelement(this.paramList.length - 1);
}

ui_validate.prototype.bindelement = function(Listindex) {
	var targetObj = this.paramList[Listindex][0];
	if (typeof (targetObj) == "string") {
		targetObj = document.getElementById(targetObj);
	}
	switch (targetObj.tagName.toLowerCase()) {
	case "input":
		switch (targetObj.type.toLowerCase()) {
		case "text":
			if (window.ActiveXObject)
				targetObj.attachEvent("onblur", this.paramList[Listindex][5]);
			else
				targetObj.addEventListener("blur",
						this.paramList[Listindex][5], false);
			break;
		case "password":
			if (window.ActiveXObject)
				targetObj.attachEvent("onblur", this.paramList[Listindex][5]);
			else
				targetObj.addEventListener("blur",
						this.paramList[Listindex][5], false);
			break;
		case "file":
			if (window.ActiveXObject)
				targetObj.attachEvent("onblur", this.paramList[Listindex][5]);
			else
				targetObj.addEventListener("blur",
						this.paramList[Listindex][5], false);
			break;
		case "hidden":
			if (window.ActiveXObject)
				targetObj.attachEvent("onpropertychange",
						this.paramList[Listindex][5]);
			else
				targetObj.addEventListener("DOMAttrModified",
						this.paramList[Listindex][5], false);
			break;
		case "checkbox":
			if (window.ActiveXObject)
				targetObj.attachEvent("onchange", this.paramList[Listindex][5]);
			else
				targetObj.addEventListener("onchange",
						this.paramList[Listindex][5], false);
			break;
		case "radio":
			if (window.ActiveXObject)
				targetObj.attachEvent("onchange", this.paramList[Listindex][5]);
			else
				targetObj.addEventListener("onchange",
						this.paramList[Listindex][5], false);
			break;
		}
		break;
	case "textarea":
		if (window.ActiveXObject)
			targetObj.attachEvent("onblur", this.paramList[Listindex][5]);
		else
			targetObj.addEventListener("blur", this.paramList[Listindex][5],
					false);
		break;
	case "select":
		if (window.ActiveXObject)
			targetObj.attachEvent("onchange", this.paramList[Listindex][5]);
		else
			targetObj.addEventListener("change", this.paramList[Listindex][5],
					false);
		break;
	}
}

ui_validate.prototype.unbindelement = function(Listindex) {
	var targetObj = this.paramList[Listindex][0];
	if (typeof (targetObj) == "string")
		targetObj = document.getElementById(targetObj);
	switch (targetObj.tagName.toLowerCase()) {
	case "input":
		switch (targetObj.type.toLowerCase()) {
		case "text":
			if (window.ActiveXObject)
				targetObj.detachEvent("onblur", this.paramList[Listindex][5]);
			else
				targetObj.removeEventListener("blur",
						this.paramList[Listindex][5], false);
			break;
		case "password":
			if (window.ActiveXObject)
				targetObj.detachEvent("onblur", this.paramList[Listindex][5]);
			else
				targetObj.removeEventListener("blur",
						this.paramList[Listindex][5], false);
			break;
		case "file":
			if (window.ActiveXObject)
				targetObj.detachEvent("onblur", this.paramList[Listindex][5]);
			else
				targetObj.removeEventListener("blur",
						this.paramList[Listindex][5], false);
			break;
		case "hidden":
			if (window.ActiveXObject)
				targetObj.detachEvent("onpropertychange",
						this.paramList[Listindex][5]);
			else
				targetObj.removeEventListener("DOMAttrModified",
						this.paramList[Listindex][5], false);
			break;
		case "checkbox":
			if (window.ActiveXObject)
				targetObj.detachEvent("onchange", this.paramList[Listindex][5]);
			else
				targetObj.removeEventListener("change",
						this.paramList[Listindex][5], false);
			break;
		case "radio":
			if (window.ActiveXObject)
				targetObj.detachEvent("onchange", this.paramList[Listindex][5]);
			else
				targetObj.removeEventListener("change",
						this.paramList[Listindex][5], false);
			break;
		}
		break;
	case "textarea":
		if (window.ActiveXObject)
			targetObj.attachEvent("onblur", this.paramList[Listindex][5]);
		else
			targetObj.addEventListener("blur", this.paramList[Listindex][5],
					false);
		break;
	case "select":
		if (window.ActiveXObject)
			targetObj.attachEvent("onchange", this.paramList[Listindex][5]);
		else
			targetObj.addEventListener("change", this.paramList[Listindex][5],
					false);
		break;
	}
}

ui_validate.prototype.del = function(targetObj) {
	var j = -1;
	if (this.paramList.length == 0)
		alert("error 0006");
	else
		for ( var i = 0; i < this.paramList.length; i++) {
			if (((typeof (targetObj) == "string") && (this.paramList[i][0]
					.toString().toLowerCase() == targetObj.toLowerCase()))
					|| ((typeof (targetObj) == "object") && (this.paramList[i][0] == targetObj))) {
				j = i;
				break;
			}
			if (i == this.paramList.length - 1) {
				alert("error 0007");
				return;
			}
		}
	this.unbindelement(j);
	this.paramList.splice(j, 1);
}

ui_validate.prototype.delall = function() {
	for ( var i = 0; i < this.paramList.length; i++)
		this.unbindelement(i);
	this.paramList.splice(0, this.paramList.length);
}

ui_validate.prototype.addsubmit = function() {
	var pList = this.paramList;
	var checkelementall = this.checkelementall;
	var getEvent = function() {
		if (document.all)
			return window.event;
		func = getEvent.caller;
		while (func != null) {
			var arg0 = func.arguments[0];
			if (arg0) {
				if ((arg0.constructor == Event || arg0.constructor == MouseEvent)
						|| (typeof (arg0) == "object" && arg0.preventDefault && arg0.stopPropagation))
					return arg0;
			}
			func = func.caller;
		}
		return null;
	}
	var checksubmit = function(paramList, errorPause) {
		var returnValue = true;
		for ( var i = 0; i < paramList.length; i++) {
			var targetObj = paramList[i][0];
			var errorstr = paramList[i][1];
			var chrarray = paramList[i][2];
			if (checkelementall(targetObj, errorstr, chrarray) == false)
				returnValue = false;
			if ((errorPause == true) && (returnValue == false))
				break;
		}
		if (returnValue == false) {
			var e = getEvent();
			if (e && e.preventDefault)
				e.preventDefault();
		}
		return returnValue;
	}
	var errorPause = this.ErrorPause;
	this._SubmitFun = function() {
		return checksubmit(pList, errorPause);
	};
	if (window.ActiveXObject)
		document.getElementById(this.frmName).attachEvent("onsubmit",
				this._SubmitFun);
	else
		document.forms[this.frmName].addEventListener("submit",
				this._SubmitFun, false);
	this._Submit = true;
}

ui_validate.prototype.delsubmit = function() {
	if (this._Submit == false)
		return;
	if (window.ActiveXObject)
		document.getElementById(this.frmName).detachEvent("onsubmit",
				this._SubmitFun);
	else
		document.forms[this.frmName].removeEventListener("submit",
				this._SubmitFun, false);
	this._Submit = false;
}

ui_validate.prototype.addreset = function() {
	var pList = this.paramList;
	var checkelementall = this.checkelementall;
	var getEvent = function() {
		if (document.all)
			return window.event;
		func = getEvent.caller;
		while (func != null) {
			var arg0 = func.arguments[0];
			if (arg0) {
				if ((arg0.constructor == Event || arg0.constructor == MouseEvent)
						|| (typeof (arg0) == "object" && arg0.preventDefault && arg0.stopPropagation))
					return arg0;
			}
			func = func.caller;
		}
		return null;
	}
	var checkreset = function(paramList) {
		for ( var i = 0; i < paramList.length; i++) {
			targetObj = paramList[i][0];
			if (typeof (targetObj) == "string")
				targetObj = document.getElementById(targetObj);
			if (targetObj.validate == false) {
				if (window.ActiveXObject)
					targetObj.nextSibling.removeNode(true);
				else
					targetObj.parentNode.removeChild(targetObj.nextSibling);
				targetObj.validate = true;
			}
			targetObj.className = "checkcss1";
		}
		var e = getEvent();
		if (e && e.preventDefault)
			e.preventDefault();
		return false;
	}
	this._ResetFun = function() {
		return checkreset(pList);
	};
	if (window.ActiveXObject)
		document.getElementById(this.frmName).attachEvent("onreset",
				this._ResetFun);
	else
		document.forms[this.frmName].addEventListener("reset", this._ResetFun,
				false);
	this._Reset = true;
}

ui_validate.prototype.delreset = function() {
	if (this._Reset == false)
		return;
	if (window.ActiveXObject)
		document.getElementById(this.frmName).detachEvent("onreset",
				this._ResetFun);
	else
		document.forms[this.frmName].removeEventListener("reset",
				this._ResetFun, false);
	this._Submit = false;
}

ui_validate.prototype.groupcheck = function() {
	var ListArray = [];
	for (i = 0; i < arguments.length; i++) {
		for (j = 0; j < this.paramList.length; j++) {
			if (arguments[i] == this.paramList[j][0]) {
				if (ListArray.length == 0)
					ListArray.push( [ arguments[i], j ]);
				else
					for (k = 0; k < ListArray.length; k++) {
						if (arguments[i] == ListArray[k][0])
							break;
						if (k == ListArray.length - 1) {
							ListArray.push( [ arguments[i], j ]);
							break;
						}
					}
				break;
			}
		}
	}
	var returnValue = true;
	var checkelementall = this.checkelementall;
	for ( var i = 0; i < ListArray.length; i++) {
		targetObj = this.paramList[ListArray[i][1]][0];
		errorstr = this.paramList[ListArray[i][1]][1];
		chrarray = this.paramList[ListArray[i][1]][2];
		if (checkelementall(targetObj, errorstr, chrarray) == false)
			returnValue = false;
		if ((this.ErrorPause == true) && (returnValue == false))
			break;
	}
	return returnValue;
}

ui_validate.prototype.groupclear = function() {
	var ListArray = [];
	for (i = 0; i < arguments.length; i++) {
		for (j = 0; j < this.paramList.length; j++) {
			if (arguments[i] == this.paramList[j][0]) {
				if (ListArray.length == 0)
					ListArray.push( [ arguments[i], j ]);
				else
					for (k = 0; k < ListArray.length; k++) {
						if (arguments[i] == ListArray[k][0])
							break;
						if (k == ListArray.length - 1) {
							ListArray.push( [ arguments[i], j ]);
							break;
						}
					}
				break;
			}
		}
	}
	var returnValue = true;
	var checkelementall = this.checkelementall;
	for ( var i = 0; i < ListArray.length; i++) {
		targetObj = this.paramList[ListArray[i][1]][0];
		if (targetObj.validate == false)
			if (window.ActiveXObject)
				targetObj.nextSibling.removeNode(true);
			else
				targetObj.parentNode.removeChild(targetObj.nextSibling);
		targetObj.className = "checkcss1";
	}
}

ui_validate.prototype.groupcheckall = function() {
	var returnValue = true;
	var checkelementall = this.checkelementall;
	for ( var i = 0; i < this.paramList.length; i++) {
		targetObj = this.paramList[i][0];
		errorstr = this.paramList[i][1];
		chrarray = this.paramList[i][2];
		if (checkelementall(targetObj, errorstr, chrarray) == false)
			returnValue = false;
		if ((this.ErrorPause == true) && (returnValue == false))
			break;
	}
	return returnValue;
}

ui_validate.prototype.groupclearall = function() {
	var checkelementall = this.checkelementall;
	for ( var i = 0; i < this.paramList.length; i++) {
		targetObj = this.paramList[i][0];
		if (typeof (targetObj) == "string")
			targetObj = document.getElementById(targetObj);
		if (targetObj.validate == false) {
			if (window.ActiveXObject)
				targetObj.nextSibling.removeNode(true);
			else
				targetObj.parentNode.removeChild(targetObj.nextSibling);
			targetObj.validate == "";
		}
		targetObj.className = "checkcss1";
	}
}

ui_validate.prototype.bindtoelement = function(tfvalue) {
	if ((this._BindToEle == false) && (tfvalue == true))
		for ( var i = 0; i < this.paramList.length; i++)
			this.bindelement(i);
	if ((this._BindToEle == true) && (tfvalue == false))
		for ( var i = 0; i < this.paramList.length; i++)
			this.unbindelement(i);
	this._BindToEle = tfvalue;
}

ui_validate.prototype.seterror = function(targetObj, errorstr) {
	var checkelementall = this.checkelementall;
	for ( var i = 0; i < this.paramList.length; i++) {
		if (this.paramList[i][0] == targetObj) {
			chrarray = this.paramList[i][2].toString();
			this.unbindelement(i);
			this.paramList[i][1] = errorstr;
			this.paramList[i][5] = function() {
				checkelementall(targetObj, errorstr, chrarray)
			};
			pList = this.paramList;
			if (this._BindToEle == true)
				this.bindelement(i);
			break;
		}
	}
}

ui_validate.prototype.setparam = function(targetObj, chrarray) {
	var checkelementall = this.checkelementall;
	for ( var i = 0; i < this.paramList.length; i++) {
		if (this.paramList[i][0] == targetObj) {
			errorstr = this.paramList[i][1];
			this.unbindelement(i);
			this.paramList[i][2] = chrarray;
			this.paramList[i][5] = function() {
				checkelementall(targetObj, errorstr, chrarray)
			};
			if (this._BindToEle == true)
				this.bindelement(i);
			if (this._Reset == true) {
				this.delreset();
				this.addreset();
			}
			break;
		}
	}
}