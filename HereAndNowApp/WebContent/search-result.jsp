<%@page import="slutprojektTrip.StationBean"
	import="slutprojektTrip.Line"%>

<!-- head -->
<jsp:include page="head.jsp" />

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
	id="mainNav">
	<div class="container">
		<a class="navbar-brand js-scroll-trigger" href="<%=request.getContextPath()%>/start">Start</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#search">Search result</a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#recent">Recent searches</a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#contact">Contact</a></li>
			</ul>
		</div>
	</div>
</nav>

<!-- Header -->
<jsp:include page="header.jsp" />


<section id="search">
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
						
						out.print("<ul class=line-list><li class=line-header>Line " + line.getName() + " <span class=arrow>&#8594;</span> " + line.getTowards() + "</li>");
						out.print("<li class=line-stop>" + "<span class=line-time>" + line.getDeparture() + "</span>" + " stop point " + line.getStopPoint() + "</li>");
						out.print("<li class=transport-type>With " + line.getTransportType() + "</li></ul>");					
					}
					%>
				</p>
			</div>
		</div>
	</div>
</section>


<!-- Latest searches -->
<jsp:include page="recent-searches.jsp" />

<!-- Contact -->
<jsp:include page="contact.jsp" />

<!-- Footer -->
<jsp:include page="footer.jsp" />
