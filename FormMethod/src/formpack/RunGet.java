package formpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RunPost
 */
@WebServlet("/RunGet")
public class RunGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RunGet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<html> <body>");
		
		out.print("<h1>Hej på dig</h1>");
		
		
		
		
		
		String djur = request.getParameter("stuff");
		
		if (djur.equals("Hund")) {
			
			out.print("<img src=\"img/hund.jpg\">");
			
		}
		
		else if (djur.equals("Katt")) {
			
			out.print("<img src=\"img/katt.jpg\">");
			
		}
		
		else if (djur.equals("Bird")) {
			
			out.print("<img src=\"img/blames.jpg\">");
		}
		
		
		out.print("</body> </html>");
		
		out.close();
		
	}

}
