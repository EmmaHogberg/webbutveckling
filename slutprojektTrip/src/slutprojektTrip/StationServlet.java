package slutprojektTrip;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;





@WebServlet("/StationServlet")
public class StationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public String url = "";

	public StationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		// Get station parameter and set StationName in bean
		String stationInput = request.getParameter("station");
		StationBean stationBean = new StationBean();
		stationBean.setStationName(stationInput);
		
		
		
//////////////////////////// TEST //////////////////////////////////
		// Get cookie
//		String [] recentStationsList = null;
//		String recentSearch = null;
//		Cookie cookies[] = request.getCookies();
//		
//		for (Cookie cookie : cookies) {
//			String name = cookie.getName();
//			
//			if (name.equals("recentSearch")) {
//				recentSearch = cookie.getValue();
//				recentStationsList = recentSearch.split(",");
//				System.out.print(recentStationsList);
//			}
//		}
//		
//		recentSearch = String.join(",", recentStationsList);
		
		
		
		
		
		// Cookie
		Cookie ck = new Cookie("recentSearch", stationInput);  
        response.addCookie(ck);  
		
		// Get station id
		String stationId = getStationIdFromApi(stationInput);
		
		// Call API, get arraylist with result and set it to StationResult in bean
		ArrayList<Line> stationResults = getLinesFromApi(stationId);
		stationBean.setStationResults(stationResults);
		
		
		request.setAttribute("bean", stationBean);
		RequestDispatcher rd = request.getRequestDispatcher("search-result.jsp");
		rd.forward(request, response);
	
	}
	
	
	
	// Method to call Querystation-API and return a arraylist with all the info of departures
	private static String getStationIdFromApi(String stationInput) throws IOException {
		
		// Build the API call by adding station name into URL
		String url = "http://www.labs.skanetrafiken.se/v2.2/querystation.asp?inpPointfr=" + stationInput;
		String stationId = null;
				
		NodeList stationSearchNodeList = StationMethods.getNodeListFromApi(url, "Point");
				
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
		String url = "http://www.labs.skanetrafiken.se/v2.2/stationresults.asp?selPointFrKey=" + stationId;
	
		NodeList stationDepartureNodeList = StationMethods.getNodeListFromApi(url, "Line");
		
		//Loop to get all of the lines that matches id
		for (int i = 0; i < stationDepartureNodeList.getLength(); i++) {
			
			// Save a node of the current list of line-tag 
			Node node = stationDepartureNodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
	
				// Set the current node as an Element
				Element eElement = (Element) node;
				
				
				String name = eElement.getElementsByTagName("Name").item(0).getTextContent();
				String transportType = eElement.getElementsByTagName("LineTypeName").item(0).getTextContent();
				String towards = eElement.getElementsByTagName("Towards").item(0).getTextContent();
				String track = "";
				String stopPoint = "";
				stopPoint = eElement.getElementsByTagName("StopPoint").item(0).getTextContent();
				String departure = eElement.getElementsByTagName("JourneyDateTime").item(0).getTextContent();
				departure = departure.substring(departure.length() - 8, 16);
				
				NodeList newDepPoint = eElement.getElementsByTagName("NewDepPoint");
				if (newDepPoint.getLength() > 0) {
					track = newDepPoint.item(0).getTextContent();
				}
				
				if (stopPoint.equals("") || stopPoint.equals(track)) {
					stopPoint = track;
					
					if(stopPoint.equals("")) {
						stopPoint = "track unknown, see more info about traffic disruptions";
					}
				}
				
				// Add info to returning arraylist
				Line line = new Line(name, departure, transportType, towards, track, stopPoint);
				lines.add(line);
			}
		}
		return lines;
	}
}
