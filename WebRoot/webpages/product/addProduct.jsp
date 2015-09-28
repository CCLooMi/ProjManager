<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<cc:head title="Insert title here"/>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">添加产品</h3>
			</div>
			<div class="panel-body">
				<form action="product/add" method="post" class="form-horizontal">
					<cc:input label="产品名称" name="name"/>
					<cc:input label="产品代号" name="code"/>
					<cc:userSelect label="产品负责人" name="productPIC"/>
					<cc:userSelect label="测试负责人" name="testPIC"/>
					<cc:userSelect label="发布负责人" name="releasePIC"/>
					<cc:input label="产品描述" name="desc" type="textarea"/>
					<cc:input name="accessType" type="radio" key="accessType"/>
					<cc:input name="btn-default" value="保存" type="submit"/>
				</form>
			</div>
		</div>
	</div>
</body>
</html>