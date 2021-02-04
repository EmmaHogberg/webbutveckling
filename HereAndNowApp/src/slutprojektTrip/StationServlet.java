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



@WebServlet("/StationServlet")
public class StationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public String url = "";

	public StationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// Get station parameter and set StationName in bean
		String stationInput = request.getParameter("station");
		StationBean stationBean = new StationBean();
		stationBean.setStationName(stationInput);
	
		// Get cookies
		Cookie cookies[] = request.getCookies();
		
		if (CookieConvertingMethods.checkCookieConsent(cookies)) {
			
			// Get info from cookie if there is one
			ArrayList<String> cookieArrayList = new ArrayList<>(CookieConvertingMethods.convertCookieStringToArrayList(cookies));
			 
			
			// Remove the oldest search and adding the newest search
			cookieArrayList = CookieConvertingMethods.replaceStations(cookieArrayList, stationInput);
			stationBean.setRecentStationsArrayList(cookieArrayList);

			// Convert cookieArrayList to cookieString 
			String cookieString = CookieConvertingMethods.convertArrayListToCookieString(cookieArrayList);
			

			// Cookie
			Cookie cookie = new Cookie("recentSearch", cookieString);  
			cookie.setMaxAge(7 * 24 * 60 * 60);
	        response.addCookie(cookie);  
		}
		
		
		// Get station id
		String stationId = ApiCallMethods.getStationIdFromApi(stationInput);
		
		// Call API, get ArrayList with result and set it to StationResult in bean
		ArrayList<Line> stationResults = ApiCallMethods.getLinesFromApi(stationId);
		stationBean.setStationResults(stationResults);
		
		
		
		request.setAttribute("bean", stationBean);
		RequestDispatcher rd = request.getRequestDispatcher("search-result.jsp");
		rd.forward(request, response);
	}
	
}
