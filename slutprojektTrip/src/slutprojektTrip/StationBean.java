package slutprojektTrip;

import java.util.ArrayList;
import java.util.List;




public class StationBean {
	
	private String stationName;
	private List<Line> lines = new ArrayList<>();
	
	

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

}
