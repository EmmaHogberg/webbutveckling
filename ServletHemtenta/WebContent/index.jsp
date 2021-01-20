<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tenta</title>
</head>
<body>


	<form action="<%= request.getContextPath()%>/RunGet" method="get">
		
		<!-- UPPGIFT 1 -->
		<h4>Who are you?</h4>
		<p> 
		First name: <input name="fname" type="text">
		Last name: <input name="lname" type="text">
		Country: <input name="country" type="text">
		</p>
		
		
		
		<!-- UPPGIFT 2 -->	
		<h4>Type in 3 types of exercises you want and how many for your training to day</h4>
		
		<p>	
		First exercise: <input name="firstExercise" type="text">
		Count: <input name="firstCount" type="text">
		</p>
	
		<p>
		Second exercise: <input name="secondExercise" type="text">
		Count: <input name="secondCount" type="text">
		</p>
		
		<p>
		Third exercise: <input name="thirdExercise" type="text">
		Count: <input name="thirdCount" type="text">
		</p>
		
		<input type="submit" value="Submit">

	</form>
	
	
	
	<!-- UPPGIFT 3 -->	
	<form action="<%= request.getContextPath()%>/RunPost" method="post">
		
		<h4>Log in to get our special training tip for to day</h4>
		Password: <input name="password" type="password" required>
		
		<input type="submit" value="Get the tip">
		(Hint: 1234)
		<%
		String loginMessage = (String)request.getAttribute("error");  
		if(loginMessage!=null)
		out.println("<h5> <font color=red>" + loginMessage + "</font></h5>");
		%>
	
	</form>

</body>
</html>