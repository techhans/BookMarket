<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>File Upload</title>
</head>
<body>
	<h3>파일업로드</h3>
	<form:form action="form" modelAttribute="member" method="post" enctype="multipart/form-data">
		<p>이름 : <input type="text" name="name" />
		<p>파일 : <input type="file" name="fileImage" />
		<p><input type="submit" name="전송하기" />
		   <input type="reset" name="다시쓰기" />

	</form:form>

</body>
</html>