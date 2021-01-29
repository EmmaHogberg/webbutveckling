package slutprojektTrip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class StationMethods {
	
	
	
	// Method to get NodeList from Api
	
	public static NodeList getNodeListFromApi(String url, String tagName) throws IOException {
		
		
		// Set the URL that will be sent
				URL line_api_url = new URL(url);

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
				NodeList stationNodeList = null;
				
				stationNodeList = doc.getElementsByTagName(tagName);
				

				return stationNodeList;
		
		
	}
	
	
	
	
	
	
	
	
	
	// Method the makes a XML doc out of a string, if it is in a XML format. 	
		public static Document convertStringToXMLDocument(String xmlString) {
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
