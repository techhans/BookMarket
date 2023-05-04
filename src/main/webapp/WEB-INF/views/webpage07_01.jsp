<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Form Tag</title>
</head>
<body>
	<h3>회원가입</h3>
	<form:form modelAttribute="member" method="post">
		<p>아이디 : <form:input path="id" name="id" />
		<p>비밀번호 : <form:password path="password" />
		<p>거주지 :   
		    <form:select path="city">
			<form:option value="서울시">서울시</form:option>
			<form:option value="경기도">경기도</form:option>
			<form:option value="인천시">인천시</form:option>
			<form:option value="충청도">충청도</form:option>
			<form:option value="전라도">전라도</form:option>
			<form:option value="경상도">경상도</form:option>
			</form:select>
		<p>성별 : <form:radiobutton path="sex" value="남성" />남성
				<form:radiobutton path="sex" value="여성" />여성
		<p>취미 : 독서<form:checkbox path="hobby" value="독서" />
			     운동<form:checkbox path="hobby" value="운동" />
			     영화<form:checkbox path="hobby" value="영화" />
		<p><input type="submit" value="가입하기" />
		   <input type="reset" value="다시쓰기" />
	</form:form>
</body>
</html>