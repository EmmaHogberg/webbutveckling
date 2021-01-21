package mvc;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
		
		String userTaskInput = request.getParameter("userTask");
		
		LoginBean bean = new LoginBean();
		bean.setUserTask(userTaskInput);
//		ArrayList<String> taskList = new ArrayList<String>(bean.getTodoList());
//		taskList.add(userTaskInput);
//		bean.setTodoList(taskList);
		request.setAttribute("bean", bean);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("login-success.jsp");
		rd.forward(request, response);
		
		
		
		
//		PrintWriter out = response.getWriter();
//		out.print("<html><body>");
//		
//		out.print(userTaskInput);
//	
//		
//		
//		
//		
//		out.print("</body></html>");
//		
//		
		
//		if(!new File(username + "List.txt").exists())
//		{
//		   File myfile = new File(username + "List.txt");
//		    myfile.createNewFile();
//		}
//		
//		
//		FileWriter writer = new FileWriter(username + "List.txt");
//		writer.write(userTaskInput);
//		writer.close();


		
//		String userTask = request.getParameter("userTask");
//		bean.setUserTask(userTask);
//		request.setAttribute("bean", bean);
	}

}
