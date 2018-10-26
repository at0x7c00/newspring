<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>
<h1>Login</h1>
<form action="login" method="post">
	<input type="text" name="username" placeholder="Username"/>
	<input type="password" name="password" placeholder="password"/>
	<button type="submit">Login</button>
</form>
<font color="red">${error }</font>
</body>
</html>