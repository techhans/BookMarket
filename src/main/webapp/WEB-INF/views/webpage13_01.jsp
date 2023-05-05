<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
<head>
<title>Validation</title>
</head>
<body>
	<h3>유효성 검사</h3>
	<form:form modelAttribute="product" method="post">
		<p>품명 : <form:input path="name"/><form:errors path="name"/>
		<p>가격 : <form:input path="price"/><form:errors path="price"/>

		<p><input type="submit" value="확인" />
		<input type="reset" value="취소" />	
	</form:form>
	
</body>
</html>