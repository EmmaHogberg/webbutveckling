<section id="services" class="bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 mx-auto">
				<h2>Your recent searches</h2>
				<p class="lead">
				
				
					<form class="lead" action="<%=request.getContextPath()%>/StationServlet"
							method="get">
					
						<input type="submit" name="station" value="Lund" />
						<input type="submit" name="station"value="Helsingborg" />
						<input type="submit" name="station" value="Svedala" />
					</form>
	
				</p>
			</div>
		</div>
	</div>
</section>