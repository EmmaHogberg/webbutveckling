package slutprojektTrip;


import java.io.IOException;
import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Line {
	
	public static ArrayList<String> printDepartureToArray(String stationId) throws IOException {
		
		ArrayList<String> stationDeparturesArrayList = new ArrayList<>();
		

		// Build the API call by adding city+country into a URL
		String URL = "http://www.labs.skanetrafiken.se/v2.2/stationresults.asp?selPointFrKey=" + stationId;

		NodeList stationDepartureNodeList = StationMethods.getNodeListFromApi(URL);
		
		
		
		
		//Loop to get all of the stations id that match input
		for (int i = 0; i < stationDepartureNodeList.getLength(); i++) {
			// Save a node of the current list id 
			Node node = stationDepartureNodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				// set the current node as an Element
				Element eElement = (Element) node;
				
				String name = "<p>Line " + eElement.getElementsByTagName("Name").item(i).getTextContent() + "</p>";
				String departure = "<p>Departure " + eElement.getElementsByTagName("JourneyDateTime").item(i).getTextContent() + "</p>";
				
				
				stationDeparturesArrayList.add(name + departure);
				
				
				System.out.println(name + departure);
				
			}
		}
		
		
		
		
		
		return stationDeparturesArrayList;
	}
}
