<%@page import = "mvc.LoginBean" %>


<p>You are logged in</p>


<%
response.setContentType("text/html");
LoginBean bean = (LoginBean)request.getAttribute("bean");

if (bean != null) {
	out.print("Welcome" + bean.getUsername());
	out.print(bean.getUserTask());
}
else {
	response.sendRedirect("index.jsp");
}



try {
	
	Cookie cookie[] = request.getCookies();
	out.print(cookie[1]);
	out.print("<br>");
	out.print(cookie[1].getName());
	out.print(cookie[1].getPath());
	out.print(cookie[1].getValue());
} catch (Exception e) {
	System.out.print(e);
}
%>

<form>
	
	What is your tasks for today: <input type="text" name="userTask">
	<input type="submit" value="Submit">

</form>
