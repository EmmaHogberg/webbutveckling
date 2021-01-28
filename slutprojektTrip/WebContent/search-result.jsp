<!-- head -->
<%@page import="slutprojektTrip.StationBean"
	import="slutprojektTrip.Line"%>
<jsp:include page="head.jsp" />

<!-- Navigation -->
<jsp:include page="navigation-bar.jsp" />

<!-- Header -->
<jsp:include page="header.jsp" />


<section id="services" class="bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 mx-auto">
				<h2>
					The following departures are available for
					<%
					StationBean stationBean = (StationBean) request.getAttribute("bean");
					out.print(stationBean.getStationName());
					%>
				</h2>

				<p class="lead">
					<%
					for (Line line : stationBean.getStationResults()) {
						out.print("<ul><li>Line " + line.getName() + " towards " + line.getTowards() + "</li>");
						out.print("<li>" + line.getDeparture() + " from stop point " + line.getStopPoint() + "</li>");
						out.print("<li>Means of transport " + line.getTransportType() + "</li></ul>");
						
						
						
						//out.print(String.format("<ul> <li>Line %s</li> <li>Towards %s</li> <li>Departure %s</li> <li>Departure %s</li>", line.getName(), line.getTowards(), line.getDeparture()));
						
					}
					%>
				</p>
			</div>
		</div>
	</div>
</section>

<!-- Footer -->
<jsp:include page="footer.jsp" />
