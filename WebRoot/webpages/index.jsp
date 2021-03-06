<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<cc:head title="欢迎使用CCLOOMI集成运行环境！"/>
</head>
<body>

    <div class="container">
        <div class="panel panel-group panel-dialog">
            <div class="panel-body">
                <div class="row">
                    <div class="col-xs-4 text-center logo">
                    	<img src="res/img/leaf.svg" class="img-responsive" width="100%" height="100%">
                    </div>
                    <div class="col-xs-8 border-left">
                        <h3>欢迎使用CCLOOMI集成运行环境！</h3>
                        <a target="_self" href="login" class="btn btn-success">正式版</a>
                    </div>
                </div>
            </div>
            <div class="panel-body border-top">
                <ul class="pull-left nav nav-pills">
                    <li class="active">
                        <a href="?lang=cn">简体</a>
                    </li>
                    <li>
                        <a href="?lang=en">English</a>
                    </li>
                </ul>
                <ul class="pull-right nav nav-pills">
                    <li><a target="_blank" href="http://www.ccloomi.com">CCLOOMI官网</a></li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>