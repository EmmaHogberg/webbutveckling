package slutprojektTrip;

public class Line {
	private String name;
	private String departure;
	private String stopPoint;
	private String transportType;
	private String towards;
	private String track;
	// String publicNote;
	
	
	public Line() {}
	
	public Line(String name, String departure, String transportType, String towards, String track, String stopPoint) {
		this.name = name;
		this.departure = departure;
		this.stopPoint = stopPoint;
		this.transportType = transportType;
		this.towards = towards;
		this.track = track;
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

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}
}
