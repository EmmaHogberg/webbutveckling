package se.emmahogberg;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/RunGet")
public class RunGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    public RunGet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h1>Welcome!</h1>");
		
		// UPPGIFT 1
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String country = request.getParameter("country");
		
		out.print("<p>Our dear guest " + fname + " " + lname + " from " + country + "</p>");
		
		// UPPGIFT 2
		String firstExercise = request.getParameter("firstExercise");
		Integer firstCount = Integer.parseInt(request.getParameter("firstCount"));
		String secondExercise = request.getParameter("secondExercise");
		Integer secondCount = Integer.parseInt(request.getParameter("secondCount"));
		String thirdExercise = request.getParameter("thirdExercise");
		Integer thirdCount = Integer.parseInt(request.getParameter("thirdCount"));
		
		out.print("<p>This is your list of exercises for to day:</p>");
		out.print("<ul>");
		out.print(printList(firstExercise, firstCount));
		out.print(printList(secondExercise, secondCount));
		out.print(printList(thirdExercise, thirdCount));
		out.print("</ul>");
		out.print("</body></html>");
		
		out.close();
	}
	

	
	static String printList(String exercise, Integer count) {
		String list = "";
		
		for(int i = 0; i <= count; i++) {
			list = list + "<li>" + exercise + "</li>";
		}
		return list;
	}
}

