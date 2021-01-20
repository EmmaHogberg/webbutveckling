<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@page import = "mvc.LoginBean" %>


<p>You are logged in</p>


<%
response.setContentType("text/html");
LoginBean bean = (LoginBean)request.getAttribute("bean");

if (bean != null) {
	out.print("Welcome " + bean.getUsername());
	
	String userTask = bean.getUserTask();
	
	if (userTask != null) {
	out.print("<p>Your goal for today is: " + userTask + "</p>");
	}
	
} else {
	response.sendRedirect("index.jsp");
}

%>

<form action="<%= request.getContextPath() %>/ControllerServlet" method="get">
	
	What is your tasks for today: <input type="text" name="userTask">
	<input type="submit" value="Submit">

</form>
