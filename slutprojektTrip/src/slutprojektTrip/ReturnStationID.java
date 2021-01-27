package slutprojektTrip;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@WebServlet("/ReturnStationID")
public class ReturnStationID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public String URL = "";

	public ReturnStationID() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String stationInput = request.getParameter("station");
		

		// Build the API call by adding city+country into a URL
		String URL = "http://www.labs.skanetrafiken.se/v2.2/querystation.asp?inpPointfr=" + stationInput;

		// Set the URL that will be sent
		URL line_api_url = new URL(URL);

		// Create a HTTP connection to sent the GET request over
		HttpURLConnection linec = (HttpURLConnection) line_api_url.openConnection();
		linec.setDoInput(true);
		linec.setDoOutput(true);
		linec.setRequestMethod("GET");

		// Make a Buffer to read the response from the API
		BufferedReader in = new BufferedReader(new InputStreamReader(linec.getInputStream()));

		// a String to temp save each line in the response
		String inputLine;

		// a String to save the full response to use later
		String apiResponse = "";

		// loop through the whole response
		while ((inputLine = in.readLine()) != null) {

			// Save the temp line into the full response
			apiResponse += inputLine;
		}
		in.close();
		

		// Call a method to make a XMLdoc out of the full response
		Document doc = convertStringToXMLDocument(apiResponse);

		// normalize the XML response
		doc.getDocumentElement().normalize();

		// Create a Node list that gets everything in and under the "Point" tag
		NodeList stationNodeList = doc.getElementsByTagName("Point");

		Node node = stationNodeList.item(0);
		if (node.getNodeType() == Node.ELEMENT_NODE) {

			// set the current node as an Element
			Element eElement = (Element) node;
			// get the content of an attribute in element
			// and print it out to the client

//			System.out.println(eElement.getAttribute("Id"));
//			out.print("The ID of " + stationInput + " is "
//					+ eElement.getElementsByTagName("Id").item(0).getTextContent());

		}
		
		
		StationBean stationBean = new StationBean();
		stationBean.setStationName(stationInput);
		request.setAttribute("bean", stationBean);
		RequestDispatcher rd = request.getRequestDispatcher("search-result.jsp");
		rd.forward(request, response);
		
	}

////////////////////////////////////////////////////////////////////////////////////

		// SPARA TILL SEDAN
		// Loop to get all of the stations id that match input
//		for (int i = 0; i < stationNodeList.getLength(); i++) {
//			// Save a node of the current list id 
//			Node node = stationNodeList.item(i);
//			if (node.getNodeType() == Node.ELEMENT_NODE) {
//
//				// set the current node as an Element
//				Element eElement = (Element) node;
//				// get the content of an attribute in element
//				// and print it out to the client 
//				
//				System.out.println(eElement.getAttribute("Id"));
//				out.print("The ID of " + stationInput + " is " + eElement.getElementsByTagName("Id").item(0).getTextContent());
//
//			}
//		}

///////////////////////////////////////////////////////////////////

	
	
	
	
		
	
	
	
	
	
	

// Method the makes a XML doc out of a string, if it is in a XML format. 	
	private static Document convertStringToXMLDocument(String xmlString) {
		// Parser that produces DOM object trees from XML content
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// API to obtain DOM Document instance
		DocumentBuilder builder = null;
		try {
			// Create DocumentBuilder with default configuration
			builder = factory.newDocumentBuilder();

			// Parse the content to Document object
			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
