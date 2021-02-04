package slutprojektTrip;

import java.io.IOException;
import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ApiCallMethods {

	// Method to call Query station-API and return a ArrayList with all the info of
	// departures
	public static String getStationIdFromApi(String stationInput) throws IOException {

		// Build the API call by adding station name into URL
		String url = "http://www.labs.skanetrafiken.se/v2.2/querystation.asp?inpPointfr=" + stationInput;
		String stationId = null;

		NodeList stationSearchNodeList = StationMethods.getNodeListFromApi(url, "Point");

		Node node = stationSearchNodeList.item(0);
		if (node.getNodeType() == Node.ELEMENT_NODE) {

			// Set the current node as an Element
			Element eElement = (Element) node;
			stationId = eElement.getElementsByTagName("Id").item(0).getTextContent();
		}
		return stationId;
	}

	
	// Method to call Station result-API and return a ArrayList with all the info of departures
	public static ArrayList<Line> getLinesFromApi(String stationId) throws IOException {
		ArrayList<Line> lines = new ArrayList<>();

		// Build the API call by adding station id into URL
		String url = "http://www.labs.skanetrafiken.se/v2.2/stationresults.asp?selPointFrKey=" + stationId;

		NodeList stationDepartureNodeList = StationMethods.getNodeListFromApi(url, "Line");

		// Loop to get all of the lines that matches id
		for (int i = 0; i < stationDepartureNodeList.getLength(); i++) {

			// Save a node of the current list of line-tag
			Node node = stationDepartureNodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				// Set the current node as an Element
				Element eElement = (Element) node;

				// Get all of the information that will be displayed
				String name = eElement.getElementsByTagName("Name").item(0).getTextContent();
				String transportType = eElement.getElementsByTagName("LineTypeName").item(0).getTextContent();
				String towards = eElement.getElementsByTagName("Towards").item(0).getTextContent();
				String track = "";
				String stopPoint = "";
				stopPoint = eElement.getElementsByTagName("StopPoint").item(0).getTextContent();
				String departure = eElement.getElementsByTagName("JourneyDateTime").item(0).getTextContent();
				departure = departure.substring(departure.length() - 8, 16);

				// Get the NewDepPoint tag to NodeList
				NodeList newDepPoint = eElement.getElementsByTagName("NewDepPoint");

				// Merge track and stop point info and add error message if there is none
				if (newDepPoint.getLength() > 0) {
					track = newDepPoint.item(0).getTextContent();
				}

				if (stopPoint.equals("") || stopPoint.equals(track)) {
					stopPoint = track;

					if (stopPoint.equals("")) {
						stopPoint = "unknown, see more info about traffic disruptions";
					}
				}

				// Add info to returning ArrayList
				Line line = new Line(name, departure, transportType, towards, stopPoint);
				lines.add(line);
			}
		}
		return lines;
	}
}
