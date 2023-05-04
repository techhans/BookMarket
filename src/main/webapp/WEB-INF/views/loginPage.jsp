<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form class="px-4 py-3" action="/login" method="post">
    ...
    <input type="text" class="form-control" name="loginId" placeholder="example">
    ...
    <input type="password" class="form-control" name="loginPwd" placeholder="Password">
    ...
    <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-primary">Sign in</button>
</form>

</body>
</html>