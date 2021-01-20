package mvc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TodoServlet")
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public TodoServlet() {
        super();
     
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		
		
		if(!new File("title.txt").exists())
		{
		   File myfile = new File("title.txt");
		    myfile.createNewFile();
		}
		
		
		FileWriter writer = new FileWriter("title.txt");
		writer.write("No God But Allah");
		writer.close();

		
		LoginBean bean = new LoginBean();
		String userTask = request.getParameter("userTask");
		bean.setUserTask(userTask);
		request.setAttribute("bean", bean);
	}

}
