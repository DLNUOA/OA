toastr.options = {
    "closeButton": true,
    "debug": false,
    "progressBar": false,
    "positionClass": "toast-top-center",
    "onclick": null,
    "showDuration": "400",
    "hideDuration": "1000",
    "timeOut": "2500",
    "extendedTimeOut": "1000",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut"
};
function addDept() {
    let name =  $("#bmmz").val();
    let address = $("#bmdz").val();
    let describe = $("#bmms").val();
    if (name==false){
        toastr.error('部门名字不能为空！！');
        return;
    }
    $.ajax({
        type: "POST",
        url: "/api/dept",
        contentType: "application/json;charset=UTF-8",
        dataType: "json",
        data:JSON.stringify({
            "name" : name,
            "address" : address,
            "describe" : describe
        }),
        success:function (result){
            if (result){
                toastr.success('添加部门数据成功');
            } else{
                toastr.error("部门信息无效","增加失败！");
            }
        }
    })
}