package slutprojektTrip;

import java.util.ArrayList;


public class StationBean {
	
	private String stationName;
	private String stationId;
	private ArrayList<String> recentStationsArrayList = new ArrayList<>();
	private ArrayList<Line> stationResults = new ArrayList<>();
	

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

	public ArrayList<Line> getStationResults() {
		return stationResults;
	}

	public void setStationResults(ArrayList<Line> lineInfos) {
		this.stationResults = lineInfos;
	}


	public ArrayList<String> getRecentStationsArrayList() {
		return recentStationsArrayList;
	}

	public void setRecentStationsArrayList(ArrayList<String> recentStationsArrayList) {
		this.recentStationsArrayList = recentStationsArrayList;
	}




}
