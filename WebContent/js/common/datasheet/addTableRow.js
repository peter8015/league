/**
 * 表格中的表单失败焦点后，自动添加一行。
 * 潘少华添加：2010.06.07
 */
function AddTableRow(obj, headRow)
{
	this.curRow = null;		// 当前行
	this.addedRow = null;	// 添加的行
	this.table = null;		// 表格
	this.isLastRow = false;	// 是否是最后一行
	this.isInTable = false;	// 是否在表格中
	this.headRowCount = 1;	// 表头个数
	
	var oTr = obj.parentNode;
	while(oTr.tagName.toUpperCase() != "TR" && oTr.tagName.toUpperCase() != "HTML")
		oTr = oTr.parentNode;
	if(oTr.tagName.toUpperCase() != "TR")
		return;
	
	this.isInTable = true;

	// 0取得表格对象、当前行
	this.curRow = oTr;
	this.table = oTr.parentNode;

	if(typeof headRow != "undefined")
		this.headRowCount = headRow;
	
	// 是否是最后一行。
	if(this.curRow.rowIndex - this.headRowCount == this.curRow.parentNode.rows.length - 1)
		this.isLastRow = true;
}
AddTableRow.prototype.blur = function(obj)
{
	if(!this.isInTable)
		return false;
	
	// 1 如果不是最后一行
	if(!this.isLastRow)
		return false;

	// 添加一行。
	{
		var r1 = this.curRow.cloneNode(true);

		var inputNameArr = ["input", "select"];
		for(var ai=0; ai<inputNameArr.length; ai++)
		{
			// 修改input名字（下标）
			var arr = r1.getElementsByTagName(inputNameArr[ai]);
			for(var i=0; i<arr.length; i++)
			{
				arr[i].name = arr[i].name.replace(/\[\d+\]/, "[" + (this.curRow.rowIndex - this.headRowCount + 1) + "]");
				arr[i].value="";
			}
		}
		
		// 去年有“clearCon”属性的中的内容span div。
		var clearStrArr = ["span", "div"];
		for(var si=0; si<clearStrArr.length; si++)
		{
			var spanArr = r1.getElementsByTagName(clearStrArr[si]);
			for(var i=0; i<spanArr.length; i++)
			{
				var att = spanArr[i].getAttribute("clearCon");
				if(null != att)
					spanArr[i].innerHTML = "";
			}
		}

		this.addedRow = r1;
	}
	
	return true;
}