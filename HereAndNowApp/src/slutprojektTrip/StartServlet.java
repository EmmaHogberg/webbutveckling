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

@WebServlet("/start")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StationBean stationBean = new StationBean();

		// Get cookies
		Cookie cookies[] = request.getCookies();

		if (CookieConvertingMethods.checkCookieConsent(cookies)) {

			// Get info from cookie if there is one
			ArrayList<String> cookieArrayList = new ArrayList<>(
					CookieConvertingMethods.convertCookieStringToArrayList(cookies));

			stationBean.setRecentStationsArrayList(cookieArrayList);
		}

		request.setAttribute("bean", stationBean);
		RequestDispatcher rd = request.getRequestDispatcher("start.jsp");
		rd.forward(request, response);
	}
}
