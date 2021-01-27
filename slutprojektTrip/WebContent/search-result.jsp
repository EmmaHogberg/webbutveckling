<!-- head -->
<%@page import="slutprojektTrip.StationBean"%>
<jsp:include page="head.jsp" />

<!-- Navigation -->
<jsp:include page="navigation-bar.jsp" />
	
<!-- Header -->
<jsp:include page="header.jsp" />
	

	<section id="services" class="bg-light">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<h2>The following departures are available for 
					<%
				
					StationBean stationBean = (StationBean)request.getAttribute("bean");
					out.print(stationBean.getStationName());
					%></h2>
					
					<p class="lead">
						
						<%
						out.print(stationBean.getLines());
						%>
					
					
					</p>
				</div>
			</div>
		</div>
	</section>

<!-- Footer -->
<jsp:include page="footer.jsp" />
