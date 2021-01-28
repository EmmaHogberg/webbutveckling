package slutprojektTrip;

public class Line {
	private String name;
	private String departure;
	private String stopPoint;
	private String transportType;
	private String towards;
	// String publicNote;
	
	
	public Line() {}
	
	public Line(String name, String departure, String stopPoint, String transportType, String towards) {
		this.name = name;
		this.departure = departure;
		this.stopPoint = stopPoint;
		this.transportType = transportType;
		this.towards = towards;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getStopPoint() {
		return stopPoint;
	}

	public void setStopPoint(String stopPoint) {
		this.stopPoint = stopPoint;
	}

	public String getTransportType() {
		return transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public String getTowards() {
		return towards;
	}

	public void setTowards(String towards) {
		this.towards = towards;
	}
}
