package slutprojektTrip;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.Cookie;

public class CookieConvertingMethods {
	
	// Get info from cookie if there is one
			String cookieString = "";
			ArrayList<String> cookieArrayList = new ArrayList<>();
			
			Cookie cookies[] = request.getCookies();
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				
				if (name.equals("recentSearch")) {
					cookieString = cookie.getValue();
					
					// Convert from string to ArrayList
					ArrayList<String> outputStations = (ArrayList<String>) Arrays.asList(cookieString.split(";"));
					cookieArrayList = outputStations;
				}
			}
			
			
			// Remove oldest station search from cookieArrayList
			if (!cookieArrayList.isEmpty() && cookieArrayList.size() >= 2) {
				cookieArrayList.remove(0);	
			}
				
			// Add most recent station search to cookieArrayList
			if (!stationInput.isEmpty())
			cookieArrayList.add(stationInput);

			
			stationBean.setFirstRecentStation(cookieArrayList.get(2));
			stationBean.setSecondRecentStation(cookieArrayList.get(1));
			stationBean.setThirdRecentStation(cookieArrayList.get(0));
		
			
			
			// Convert from ArrayList to string		
			cookieString = "";
			for (String station : cookieArrayList) {
				cookieString += station + ";";
			}
				// Remove last semicolon
				if (!cookieString.isEmpty()) {
					cookieString = cookieString.substring(0, cookieString.length()-1);
			}

}
