<%@page import="java.util.ArrayList"%>
<%@page import="slutprojektTrip.StationBean"%>


<section id="recent" class="bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 mx-auto">
				<h2>Your recent searches</h2>
				<form class="lead" action="<%=request.getContextPath()%>/StationServlet" method="get">
					<%StationBean stationBean = (StationBean) request.getAttribute("bean");
					out.println("<div class=recent-stations>");	
					
					if (stationBean.getRecentStationsArrayList().isEmpty()) {
						out.println("There are no recent searches");
					}
					
					if (stationBean.getRecentStationsArrayList() != null) {
						for (String stationName : stationBean.getRecentStationsArrayList())
								out.println("<input type=submit name=station value=" + stationName + " />");
					}
					out.println("</div>");	
					%>
				</form>
			</div>
		</div>
	</div>
</section>