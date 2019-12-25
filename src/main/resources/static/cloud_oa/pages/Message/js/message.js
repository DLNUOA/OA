
//全选
function selectAll(e){
	if($(e).prop("checked") == true){
		$('input[name="selected"]').prop("checked", true);
	}else{
		$('input[name="selected"]').prop("checked", false);
	}
}
//检查是不是全选
function checkAll(){
	if($('input[name="selected"]').length==$('input[name="selected"]:checked').length){
		$('input[name="selectAll"]').prop("checked", true);
	}else{
		$('input[name="selectAll"]').prop("checked", false);
	}
}

function submitList(e){
	//遍历循环所有已选项目
	$('input[name="selected"]:checked').each(function(i){					
					//成功后该条淡出
					$(this).parent().parent().fadeOut("slow",function(){
						layer.msg('成功');
						$(this).remove();//淡出之后彻底删除
						if($('tr').length<5){
							window.location.reload();
						}
					});
	});
}

//补齐表格空列
$(document).ready(function(e){
	while ($('tr').length<10)
	{
		$('tr').last().after('<tr><th>&nbsp;</th><th></th><th></th><th></th></tr>');
	}
});
