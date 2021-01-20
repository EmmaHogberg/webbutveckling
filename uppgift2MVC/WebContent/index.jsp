<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
	</head>
	<body>
	
		<h1>The web's most amazing meeting place</h1>
		
		<form action="<%= request.getContextPath() %>/ControllerServlet" method="post">
			<p>Username: <input type="text" name="username" required></p>
			<p>Password: <input type="password" name="password" required></p>
			
			<input type="submit" value="Login">
		</form>
	</body>
</html>