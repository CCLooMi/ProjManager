<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>AllRAUvisData</title>
	
    <link rel="stylesheet" href="res/css/bootstrap.css">
    <link rel="stylesheet" href="res/css/bootstrap-theme.css">
    <link rel="stylesheet" href="res/widget/vis/4.7.0/vis.css">
    <link rel="stylesheet" href="res/css/view/allRAUvisData.css">
    <script src="res/js/jquery-2.1.4.js"></script>
    <script src="res/js/bootstrap.js"></script>
    <script src="res/widget/vis/4.7.0/vis.js"></script>
    <script src="res/js/view/allRAUvisData.js"></script>
    
</head>
<body>
    <div id="network" class="vis-network"></div>
    <button class="btn btn-default" id="INFO">INFO</button>
</body>
</html>