<!-- head -->
<jsp:include page="head.jsp" />

<!-- Navigation -->
<jsp:include page="navigation.jsp" />

<!-- Header -->
<jsp:include page="header.jsp" />


<section id="search">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 mx-auto">
				<h2>Search departures from specific stop</h2>
				<form class="lead"
					action="<%=request.getContextPath()%>/StationServlet" method="get">
					<p>
						View departures from stop: <input type="text" name="station"
							required />
					</p>

					<input type="submit" value="Search" />
				</form>
			</div>
		</div>
	</div>
</section>


<!-- Latest searches -->
<jsp:include page="recent-searches.jsp" />

<!-- Contact -->
<jsp:include page="contact.jsp" />

<!-- Cookie consent pop up -->
<div id="consent-popup" class="hidden">
	<input type="submit" id="close-button" value="close x" />
	<p>
		We use cookies to enhance your experience in our web site. 
	</p>
	<p>
		Please <input type="submit" id="accept" value="accept" /> these for a better experience.
	</p>
</div>


<!-- Footer -->
<jsp:include page="footer.jsp" />

