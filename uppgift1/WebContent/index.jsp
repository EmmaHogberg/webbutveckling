<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css" />
<title>Djurens hemsida</title>
</head>
<body>

	<jsp:include page="header.jsp"/>
	
	<div class="center">

		<form id="form-id" action="/default/page">
		Ange namnet på ditt djur: <input type="text" name="animalName">
		
			<select id="input-animal" name="species">
				
				<option value="dog"> Hund </option>
				<option value="cat"> Katt </option>
				
			</select>
		
		<input type="submit" onclick='this.form.action = species.value + ".jsp"' value="Gå vidare">
		
		</form>
	
	</div>

	<jsp:include page="footer.jsp"/>


</body>
</html>