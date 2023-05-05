<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
<head>
<title>RESTfull 웹 서비스</title>
</head>
<body>
	<h3>RESTfull 웹 서비스</h3>
	<form action="./exam01"	method="post">
		<p>이름 : <input name = "name" />
		<p>나이 : <input name = "age" />
		<p>이메일 : <input name = "email" />
		<p><input type="submit" value="확인" />				
			
	</form>
	
	
</body>
</html>