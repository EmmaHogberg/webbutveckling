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

	// Method to get NodeList from API

	public static NodeList getNodeListFromApi(String url, String tagName) throws IOException {

		// Set the URL that will be sent
		URL line_api_url = new URL(url);

		// Create a HTTP connection to sent the GET request over
		HttpURLConnection linec = (HttpURLConnection) line_api_url.openConnection();
		linec.setDoInput(true);
		linec.setDoOutput(true);
		linec.setRequestMethod("GET");

		// Make a Buffer to read the response from the API
		BufferedReader in = new BufferedReader(new InputStreamReader(linec.getInputStream(), "UTF-8"));

		String inputLine;
		String apiResponse = "";

		// Loop through the whole response and save to apiResponse
		while ((inputLine = in.readLine()) != null) {
			apiResponse += inputLine;
		}
		in.close();

		// Call a method to make a XMLdoc out of the full response
		Document doc = convertStringToXMLDocument(apiResponse);

		// Normalize the XML response
		doc.getDocumentElement().normalize();

		// Create a Node list that gets everything in the "Point" tag
		NodeList stationNodeList = null;
		stationNodeList = doc.getElementsByTagName(tagName);

		return stationNodeList;
	}

	// Method the makes a XML doc out of a string, if it is in a XML format.
	public static Document convertStringToXMLDocument(String xmlString) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();

			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			return doc;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
