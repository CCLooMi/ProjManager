<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<cc:head title="用户登陆－CCLOOMI"/>
</head>
<body>

    <div class="container">
        <div class="panel panel-group panel-dialog">
            <div class="panel-heading">
                <h4 class="panel-title">CCLOOMI项目管理系统</h4>
            </div>
            <div class="panel-body">
                <canvas id="canvas"></canvas>
                <div class="row">
                    <div class="col-xs-4 text-center logo">
                    	<img src="res/img/leaf.svg" class="img-responsive" width="100%" height="100%">
                    </div>
                    <div class="col-xs-8">
                        <form method="post" action="home" name="loginform">
                            <table class="table table-noneborder">
                                <tbody>
                                    <tr>
                                        <td><input class="form-control" type="text" name="username" placeholder="用户名" autofocus></td>
                                    </tr>
                                    <tr>
                                        <td><input class="form-control" type="password" name="password" placeholder="密码"></td>
                                    </tr>
                                <tr>
                                    <td>
                                        <input class="btn btn-default btn-submit" type="button" value="登陆">
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</body>
</html>