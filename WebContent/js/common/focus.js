/*******************************************************************************
 * 选择第一个输入做为焦点
 ******************************************************************************/
$(function() {
	focusFirst();
});

function focusFirst() {
	if ($(':text').length > 0) {
		$(':text').first().focus();
	}
}

/**
 * 将焦点定位到第一个出错的输入框
 * 
 * @return
 */
function focusFirstError() {
	var focusId = '';
	$('span:[class="mustSpan"]')
			.each(
					function() {
						var idValue = $(this).attr('id');
						if (idValue.indexOf('Validate') != -1
								&& $("#" + idValue).text() != '√') {
							idValue = idValue.substring(0, idValue
									.indexOf('Validate'));

							if ($('#' + idValue).is(':text')) {
								focusId = idValue;
								return false;
							}
						}
					});
	if (focusId != '') {
		$('#' + focusId).focus();
	} else {
		focusFirst();
	}
}