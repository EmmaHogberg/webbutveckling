<!-- head -->
<jsp:include page="head.jsp" />

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
	id="mainNav">
	<div class="container">
		<a class="navbar-brand js-scroll-trigger" href="index.jsp">Start</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#search">Search</a></li>
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
					<h2>Search departures from specific stop</h2>
						<form class="lead" action="<%=request.getContextPath()%>/StationServlet"
							method="get">
							<p>
								View departures from stop: <input type="text" name="station" required />
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

<div id="consent-popup" class="hidden">
    <p>We use cookies to enhance your experience in our web site.
       Please <input type="submit" id="accept" value="accept"/> these for a better experience.</p>
</div>

	
<!-- Footer -->
<jsp:include page="footer.jsp" />

