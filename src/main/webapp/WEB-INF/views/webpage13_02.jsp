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
	<form:form modelAttribute="member" method="post">
		<p>아이디 : <form:input path="Id"/><form:errors path="Id"/>
		<p><input type="submit" value="확인" />
		<input type="submit" value="취소" />		

	</form:form>
	
</body>
</html>