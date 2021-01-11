<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css" />
<title>Kattsida</title>
</head>
<body>

	<jsp:include page="header.jsp"/>
	
	<div class="center">

		<h2>Välkommen till sidan för dig som har katt</h2>
		
		<h4>
			Roligt att du och din katt <%
			String animalName = request.getParameter("animalName");
			out.println(animalName);%>
			har hittat hit!
		</h4>
		
		<img src="https://images.ctfassets.net/bi9pvs2ayg6b/5L1cADo5pYsOuA0IosAwOg/808f0cfacb89d74654fb065a3c726970/Kopa_katt.jpg?w=1200" alt="kattunge">
	
	</div>

	<jsp:include page="footer.jsp"/>

</body>
</html>