package mvc;

public class LoginBean {
	
	
	private String username, password, userTask;
	// private ArrayList<String> todoList = new ArrayList<String>();
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserTask() {
		return userTask;
	}

	public void setUserTask(String userTask) {
		this.userTask = userTask;
	}

//	public ArrayList<String> getTodoList() {
//		return todoList;
//	}
//
//	public void setTodoList(ArrayList<String> todoList) {
//		this.todoList = todoList;
//	}
	
	

	
	
	public boolean validate() {
		
		if (username.equals("Marcus") && password.equals("admin") || username.equals("Marcus")) {
			return true;
		} 
		
		else if (username.equals("Emma") && password.equals("admin") || username.equals("Emma")) {
			return true;
		}
		
		else {
			return false;
		}
		
	}
	
	
	
	
	



}
