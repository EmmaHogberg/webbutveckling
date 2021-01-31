<!-- head -->
<%@page import="slutprojektTrip.StationBean"
	import="slutprojektTrip.Line"%>
<jsp:include page="head.jsp" />

<!-- Navigation -->
<jsp:include page="navigation-bar.jsp" />

<!-- Header -->
<jsp:include page="header.jsp" />


<section id="about" class="bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 mx-auto">
				<h2>
					The following departures are available for
					<%
					StationBean stationBean = (StationBean) request.getAttribute("bean");
					%>
				</h2>

				<p class="lead">
					<%
					for (Line line : stationBean.getStationResults()) {
						
						out.print("<ul class=line-list><li class=line-header>Line " + line.getName() + " towards " + line.getTowards() + "</li>");
						out.print("<li>" + "<span class=line-time>" + line.getDeparture() + "</span>" + " from stop point " + line.getStopPoint() + "</li>");
						out.print("<li>With " + line.getTransportType() + "</li></ul>");
											
					}
					%>
				</p>
			</div>
		</div>
	</div>
</section>


<!-- Latest searches -->
<jsp:include page="recent-searches.jsp" />

<!-- Footer -->
<jsp:include page="footer.jsp" />
