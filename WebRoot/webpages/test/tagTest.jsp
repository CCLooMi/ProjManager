<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Tag test</title>
    <link rel="stylesheet" href="res/css/bootstrap.css">
    <link rel="stylesheet" href="res/css/bootstrap-theme.css">
    <script src="res/js/jquery-2.1.4.js"></script>
    <script src="res/js/bootstrap.js"></script>
    <script src="res/js/bootlint.min.js"></script>
</head>
<body>
	<div class="container">
		<form class="form-horizontal">
			<cc:input type="text" name="name" label="名称" value="小米"/>
			<cc:input type="textarea" name="desc" label="产品描述" value="测试产品"/>
			<cc:input type="radio" name="accessType" key="accessType"/>
			<cc:userSelect name="user" label="产品负责人"/>
		</form>
	</div>
</body>
</html>