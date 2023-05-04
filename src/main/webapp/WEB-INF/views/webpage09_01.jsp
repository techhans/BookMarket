<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>File Upload</title>
</head>
<body>
	<form action="form" method="post" enctype="multipart/form-data">
		<p>이름 : <input type="text" name="name" />
		<p>파일 : <input type="file" name="fileImage" />
		<p><input type="submit" name="전송하기" />
		   <input type="reset" name="다시쓰기" />

	</form>

</body>
</html>