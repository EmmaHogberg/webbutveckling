package slutprojektTrip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;

public class CookieConvertingMethods {
	
	
	
	// Method to check if there is a cookie with cookie-consent that is true
	public static Boolean checkCookieConsent(Cookie cookies[]) {
		
		Boolean cookieConsent = false;
		
		if (cookies != null) {
			
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				
				if (name.equals("cookie-consent")) {
					String cookieString = cookie.getValue();
					
					if (cookieString.equals("true")) {
						cookieConsent = true;
					}
				}
			}
		}
		return cookieConsent;
	}
	
	
	
	// Method to convert cookie string to ArrayList
	public static List<String> convertCookieStringToArrayList(Cookie cookies[]) {
		List<String> cookieList = new ArrayList<String>();
		
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			
			// Check if there is a cookie with recent searches
			if (name.equals("recentSearch")) {
				String cookieString = cookie.getValue();
						
				// Convert from string to ArrayList
				String splitCookieString[] = cookieString.split("!");
				cookieList = Arrays.asList(splitCookieString);
			}
		}
		return cookieList;
	}
			

			
	// Method to update the ArrayList with recent searches 	
	public static ArrayList<String> replaceStations(ArrayList<String> cookieArrayList,String stationName) {
		
		// Check if the latest station name already exists in list and remove the oldest one
		for (int i = 0; i < cookieArrayList.size(); i++) {
			
			if (cookieArrayList.get(i).equals(stationName)) {
				cookieArrayList.remove(i);
			}
		}
		
		// Remove oldest station search from cookieArrayList if there is more than 3
		if (cookieArrayList != null && cookieArrayList.size() >= 3) {
				cookieArrayList.remove(0);	
		}
					
		// Add most recent stationName from search to cookieArrayList
		if (stationName != null) {
			cookieArrayList.add(stationName);
		}	
		return cookieArrayList;
	}
	
	
	// Method to convert ArrayList to cookie string
	public static String convertArrayListToCookieString(ArrayList<String> cookieArrayList) {
		
		// Convert from ArrayList to string		
		String cookieString = "";
		for (String station : cookieArrayList) {
			cookieString += station + "!";
		}
		
		// Remove last semicolon
		if (!cookieString.isEmpty()) {
			cookieString = cookieString.substring(0, cookieString.length()-1);
		}
		return cookieString;
	}		
}

			

		
			
			
			


