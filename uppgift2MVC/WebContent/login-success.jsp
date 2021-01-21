
<%@page import="java.util.ArrayList"%>
<%@page import = "mvc.LoginBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
	</head>
	<body>

		<p>You are logged in</p>
		
		<%
		response.setContentType("text/html");
		LoginBean bean = (LoginBean)request.getAttribute("bean");
		
		if (bean != null) {
			
			Cookie cookie[] = request.getCookies();
			String username = cookie[1].getValue(); 
			out.print("Welcome " + username);
			
			String userTask = bean.getUserTask();
			
			if (userTask != null) {
				out.print("<p>Your goal for today is: " + userTask + "</p>");
			}
			
		} else {
			response.sendRedirect("index.jsp");
		}
		%>
		
		<form action="<%= request.getContextPath() %>/TodoServlet" method="post">
			
			What is your tasks for today: <input type="text" name="userTask">
			<input type="submit" value="Submit">
		
		</form>
	</body>
</html>
