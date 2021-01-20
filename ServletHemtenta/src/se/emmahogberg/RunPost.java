package se.emmahogberg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RunPost")
public class RunPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RunPost() {
        super();
    }


    // UPPGIFT 3
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		
		
		String password = request.getParameter("password");
		
		if (password.equals("1234")) {
			out.print("<h2>Welcome to todays fantastic yoga position</h2>");
			out.print("<img src=\"img/yogaposition.png\">");
		}
		
		else {
			request.setAttribute("error","Invalid Password, please try again");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");            
			rd.include(request, response);
		}
		
		out.print("</body></html>");
		
		out.close();
	}
}
