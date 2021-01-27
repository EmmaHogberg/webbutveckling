package slutprojektTrip;


import java.io.IOException;
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
		String stationId = null;
		

		// Build the API call by adding city+country into a URL
		String URL = "http://www.labs.skanetrafiken.se/v2.2/querystation.asp?inpPointfr=" + stationInput;

		NodeList stationSearchNodeList = StationMethods.getNodeListFromApi(URL);
		
		
		Node node = stationSearchNodeList.item(0);
		if (node.getNodeType() == Node.ELEMENT_NODE) {

			// set the current node as an Element
			Element eElement = (Element) node;
			stationId = eElement.getElementsByTagName("Id").item(0).getTextContent();
		}
		
		StationBean stationBean = new StationBean();
		stationBean.setStationName(stationInput);
		stationBean.setStationId(stationId);
		stationBean.setLines(Line.printDepartureToArray(stationId));
		
		request.setAttribute("bean", stationBean);
		RequestDispatcher rd = request.getRequestDispatcher("search-result.jsp");
		rd.forward(request, response);
		
	
	
	
	}
	


}
