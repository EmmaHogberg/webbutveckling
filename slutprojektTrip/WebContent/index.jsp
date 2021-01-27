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
					<p class="lead">
					<form action="<%=request.getContextPath()%>/ReturnStationID"
						method="get">
						<p>
							View departures from stop: <input type="text" name="station" required>
						</p>
	
						<input type="submit" value="Search">
					</form>
					</p>
				</div>
			</div>
		</div>
	</section>

	<section id="services" class="bg-light">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<h2>Services we offer</h2>
					<p class="lead">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Aut optio velit inventore, expedita quo
						laboriosam possimus ea consequatur vitae, doloribus consequuntur
						ex. Nemo assumenda laborum vel, labore ut velit dignissimos.</p>
				</div>
			</div>
		</div>
	</section>

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