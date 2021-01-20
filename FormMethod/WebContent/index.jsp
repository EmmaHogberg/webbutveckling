<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<div>

		<form action="<%= request.getContextPath()%>/RunGet" method="get">
	
			Name with GET <input name="fname" type="text"> 
			
			<select name="stuff">
	
				<option value="Hund">Hund</option>
				<option value="Katt">Katt</option>
				<option value="Bird">Fågel</option>
				
	
			</select> <input type="submit" value="Submit as GET">
	
		</form>
		
	</div>
	

</body>
</html>