package slutprojektTrip;

import java.util.ArrayList;
import java.util.List;




public class StationBean {
	
	private String stationName;
	private String stationId;
	private List<String> lines = new ArrayList<>();
	
	

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public List<String> getLines() {
		return lines;
	}

	public void setLines(List<String> lines) {
		this.lines = lines;
	}




}
