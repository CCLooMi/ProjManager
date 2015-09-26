<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<cc:head/>
</head>
<body>
	<div class="container">
		<form class="form-horizontal">
			<cc:input type="text" name="name" label="名称" value="小米"/>
			<cc:input type="textarea" name="desc" label="产品描述" value="测试产品"/>
			<cc:input type="radio" name="accessType" key="accessType" value="public"/>
			<cc:userSelect name="user" label="产品负责人" value="40289fed4fffdb9d014fffdc46e30001"/>
		</form>
	</div>
</body>
</html>