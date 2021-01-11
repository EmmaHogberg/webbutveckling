<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css" />
<title>Hundsidan</title>
</head>
<body>

	<jsp:include page="header.jsp"/>
	
	<div class="center">
	
		<h2>Välkommen till sidan för dig som har hund</h2>
		
		<h4>
			Roligt att du och din hund <%
			String animalName = request.getParameter("animalName");
			out.println(animalName);%>
			har hittat hit!
		</h4>
		
		<img src="https://medisera.se/wp-content/uploads/valpar-palsdjusallergi.jpg" alt="Fyra hundar på rad">
	
	</div>
	
	<jsp:include page="footer.jsp"/>
	
</body>
</html>