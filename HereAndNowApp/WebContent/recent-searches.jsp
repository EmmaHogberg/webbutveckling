<%@page import="java.util.ArrayList"%>
<%@page import="slutprojektTrip.StationBean"%>
<section id="recent" class="bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 mx-auto">
				<h2>Your recent searches</h2>
				<p class="lead">
				
				
					<form class="lead" action="<%=request.getContextPath()%>/StationServlet"
							method="get">
						<%StationBean stationBean = (StationBean) request.getAttribute("bean");
							
						if (stationBean.getRecentStationsArrayList() != null) {
							for (String stationName : stationBean.getRecentStationsArrayList())
								out.println("<input type=submit name=station value=" + stationName + " />");
						}
						
						%>
						
					</form>
				</p>
			</div>
		</div>
	</div>
</section>