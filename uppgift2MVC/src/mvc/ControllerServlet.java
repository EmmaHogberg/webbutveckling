package mvc;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public ControllerServlet() {
        super();
       
    }
    
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
	Cookie cookie[] = request.getCookies();
	String username = cookie[1].getValue();

	
	if (username != null) {
		LoginBean bean = new LoginBean();
		bean.setUsername(username);
//		String userTask = request.getParameter("userTask");
//		bean.setUserTask(userTask);
		request.setAttribute("bean", bean);
		RequestDispatcher rd = request.getRequestDispatcher("login-success.jsp");
		rd.forward(request, response);
	} else {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (username.isEmpty()) {
				Cookie cookie[] = request.getCookies();
				username = cookie[1].getValue();
		}
		
		
		LoginBean bean = new LoginBean();
		bean.setUsername(username);
		bean.setPassword(password);
		request.setAttribute("bean", bean);
		boolean loginOk = bean.validate();
		
		
		if (loginOk) {
			Cookie ck = new Cookie("username", username);  
            response.addCookie(ck);  
			RequestDispatcher rd = request.getRequestDispatcher("login-success.jsp");
			rd.forward(request, response);
		} 
		
		else {
			RequestDispatcher rd = request.getRequestDispatcher("login-error.jsp");
			rd.forward(request, response);
			
		}

	}
	
}
