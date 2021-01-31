<%@page import="slutprojektTrip.StationBean"%>
<section id="services" class="bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 mx-auto">
				<h2>Your recent searches</h2>
				<p class="lead">
				
				
					<form class="lead" action="<%=request.getContextPath()%>/StationServlet"
							method="get">
						<%StationBean stationBean = (StationBean) request.getAttribute("bean");%>
						<input type="submit" name="<%stationBean.getFirstRecentStation();%>" value="<%stationBean.getFirstRecentStation();%>" />
						<input type="submit" name="<%stationBean.getSecondRecentStation();%>"value="<%stationBean.getSecondRecentStation();%>" />
						<input type="submit" name="<%stationBean.getThirdRecentStation();%>" value="<%stationBean.getThirdRecentStation();%>" />
					</form>
	
				</p>
			</div>
		</div>
	</div>
</section>