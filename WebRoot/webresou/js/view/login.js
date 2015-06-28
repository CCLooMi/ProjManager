/**
 * Created by chenxianjun on 15/6/26.
 */
$(document).ready(function () {
    $("table").click(function (e) {
        var target=$(e.target);
        var login=$(".btn-submit");
        var d={};
        if(target.is(login)){
            target.parent().parent().prevAll().find("input").each(function () {
                var $this=$(this);
                d[$this.attr("name")]=$this.val();
            });
            //alert(JSON.stringify(d));
            $.ajax({
            	async:false,//非异步请求
                url:"http://localhost:8080/ProjManager/testUser/checkUser.do",
                method:"POST",
                contentType:"application/json",
                dataType:"json",
                data:JSON.stringify(d),
                error:function(e){
                    alert(JSON.stringify(e));
                },
                success:function(data){
                    $("body").fadeOut(1000);
                    $("form").submit();
                }
            });
        }
    });
});