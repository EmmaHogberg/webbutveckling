package slutprojektTrip;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


@WebServlet("/StationServlet")
public class StationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public String URL = "";

	public StationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String stationInput = request.getParameter("station");
		StationBean stationBean = new StationBean();
		stationBean.setStationName(stationInput);
		
		String stationId = getStationIdFromApi(stationInput);
		ArrayList<Line> stationResults = getLinesFromApi(stationId);
		stationBean.setStationResults(stationResults);
		
		
		request.setAttribute("bean", stationBean);
		RequestDispatcher rd = request.getRequestDispatcher("search-result.jsp");
		rd.forward(request, response);
	
	}
	
	
	
	// Method to call Querystation-API and return a arraylist with all the info of departures
	private static String getStationIdFromApi(String stationInput) throws IOException {
		
		// Build the API call by adding station name into URL
				String URL = "http://www.labs.skanetrafiken.se/v2.2/querystation.asp?inpPointfr=" + stationInput;
				String stationId = null;
				
				NodeList stationSearchNodeList = StationMethods.getNodeListFromApi(URL);
				
				Node node = stationSearchNodeList.item(0);
				if (node.getNodeType() == Node.ELEMENT_NODE) {

					// set the current node as an Element
					Element eElement = (Element) node;
					stationId = eElement.getElementsByTagName("Id").item(0).getTextContent();
				}
			return stationId;
	}
	
	
	
	
	
	// Method to call Stationresult-API and return a arraylist with all the info of departures
	private static ArrayList<Line> getLinesFromApi(String stationId) throws IOException {
		ArrayList<Line> lines = new ArrayList<>();
		
		// Build the API call by adding station id into URL
		String URL = "http://www.labs.skanetrafiken.se/v2.2/stationresults.asp?selPointFrKey=" + stationId;
	
		NodeList stationDepartureNodeList = StationMethods.getNodeListFromApi(URL);
		
		
		//Loop to get all of the lines that matches id
		for (int i = 0; i < stationDepartureNodeList.getLength(); i++) {
			
			// Save a node of the current list of line-tag 
			Node node = stationDepartureNodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
	
				// Set the current node as an Element
				Element eElement = (Element) node;
				
				
				String name = eElement.getElementsByTagName("Name").item(0).getTextContent();
				String departure = eElement.getElementsByTagName("JourneyDateTime").item(0).getTextContent();
				departure = departure.substring(departure.length() - 8);
				String stopPoint = eElement.getElementsByTagName("StopPoint").item(0).getTextContent();
				String transportType = eElement.getElementsByTagName("LineTypeName").item(0).getTextContent();
				String towards = eElement.getElementsByTagName("Towards").item(0).getTextContent();
			
				
				
				// Add info to returning arraylist
				Line line = new Line(name, departure, stopPoint, transportType, towards);
				lines.add(line);
			}
		}
		return lines;
	}
}
