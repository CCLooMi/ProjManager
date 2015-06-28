<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户登陆－CCLOOMI</title>
    <link rel="stylesheet" href="http://localhost:8080/ProjManager/res/css/bootstrap-theme.css">
    <link rel="stylesheet" href="http://localhost:8080/ProjManager/res/css/bootstrap.css">
    <link rel="stylesheet" href="http://localhost:8080/ProjManager/res/css/view/login.css">
    <script src="http://localhost:8080/ProjManager/res/js/jquery-2.1.4.min.js"></script>
    <script src="http://localhost:8080/ProjManager/res/js/bootstrap.js"></script>
    <script src="http://localhost:8080/ProjManager/res/js/view/login.js"></script>
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
                        <img src="http://localhost:8080/ProjManager/res/img/leaf.svg" class="img-responsive">
                    </div>
                    <div class="col-xs-8">
                        <form method="post" action="http://localhost:8080/ProjManager/home.do" name="loginform">
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