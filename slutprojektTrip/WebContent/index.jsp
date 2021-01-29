<!-- head -->
<jsp:include page="head.jsp" />

<!-- Navigation -->
<jsp:include page="navigation-bar.jsp" />

<!-- Header -->
<jsp:include page="header.jsp" />


	<section id="about">
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

	<section id="contact">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<h2>Contact us</h2>
					<p class="lead">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Vero odio fugiat voluptatem dolor, provident
						officiis, id iusto! Obcaecati incidunt, qui nihil beatae magnam et
						repudiandae ipsa exercitationem, in, quo totam.</p>
				</div>
			</div>
		</div>
	</section>

<!-- Footer -->
<jsp:include page="footer.jsp" />