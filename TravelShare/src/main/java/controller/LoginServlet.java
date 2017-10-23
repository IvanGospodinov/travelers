package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserException;
import model.dbConnection.UserDAO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		// Copying all the input parameters in to local variables
		//				String user_email = request.getParameter("user_email");
		//				String user_password = request.getParameter("user_password");

		//				LoginBean loginBean = new LoginBean();
		// Using Java Beans - An easiest way to play with group of related data

		//				loginBean.setUser_email(user_email);
		//				loginBean.setUser_password(user_password);
		User user = new User(request.getParameter("user_email"),request.getParameter("user_password"));
		UserDAO userDao = new UserDAO();


		int userLogin = 0;	
		try {
			userLogin = userDao.loginUser(user);
		} catch (UserException e) {
			e.printStackTrace();
		}
		if (userLogin == 1) {
			// On success, you can display a message to user on Home page
			request.getRequestDispatcher("/Home.html").forward(request, response);
		} else {
			// On Failure, display a meaningful message to the User.
			request.setAttribute("0", userLogin);
			request.getRequestDispatcher("/Error.html").forward(request, response);	

		}
	}


}