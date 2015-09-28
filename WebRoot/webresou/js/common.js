/**
 * Created by Chenxj on 15/9/27.
 */

$("form").click(function (e) {
    var target=$(e.target);
    var submit=$("button[type='submit']");
    if(target.is(submit)){
        eventPrevent(e);
        var form=target.closest("form");
        submitForm(form);
    }
});
//将FORM表单转成JS对象serialize()方法依赖于JQuery
function form2obj(f) {
	var obj = {};
	var farray = f.serialize().split("&");
	for ( var i in farray) {
		var a = farray[i].split("=");
		obj[a[0]] = a[1];
	}
	return obj;
}
// 将FORM表单转成JSON字符串
function form2jsonString(f){
	return JSON.stringify(form2obj(f));
}
// 阻止事件冒泡和默认事件
function eventPrevent(e){
    e.preventDefault();
    e.stopPropagation();
};
function targetResult(data){
    if(data.code==0){
        swal("成功",data.info,"success");
    }else{
        swal("失败",data.info,"error");
    }
};
function submitForm(form){
    var action=form.attr("action");
    var obj=form2obj(form);
    $.post(action,obj,targetResult,"json");
};