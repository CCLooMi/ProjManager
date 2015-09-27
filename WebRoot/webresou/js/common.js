/**
 * Created by Chenxj on 15/9/27.
 */
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
function form3jsonString(f){
	return JSON.stringify(form2obj(f));
}