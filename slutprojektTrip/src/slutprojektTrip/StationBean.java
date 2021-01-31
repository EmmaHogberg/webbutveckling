package slutprojektTrip;

import java.util.ArrayList;




public class StationBean {
	
	private String stationName;
	private String firstRecentStation;
	private String secondRecentStation;
	private String thirdRecentStation;
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

	public String getFirstRecentStation() {
		return firstRecentStation;
	}

	public void setFirstRecentStation(String recentStation) {
		this.firstRecentStation = recentStation;
	}

	public String getSecondRecentStation() {
		return secondRecentStation;
	}

	public void setSecondRecentStation(String secondRecentStation) {
		this.secondRecentStation = secondRecentStation;
	}

	public String getThirdRecentStation() {
		return thirdRecentStation;
	}

	public void setThirdRecentStation(String thirdRecentStation) {
		this.thirdRecentStation = thirdRecentStation;
	}

	public ArrayList<String> getRecentStationsArrayList() {
		return recentStationsArrayList;
	}

	public void setRecentStationsArrayList(ArrayList<String> recentStationsArrayList) {
		this.recentStationsArrayList = recentStationsArrayList;
	}




}
