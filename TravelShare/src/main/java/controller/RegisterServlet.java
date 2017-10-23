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

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String uname = request.getParameter("uname");
		String password = request.getParameter("user_password");
		String email = request.getParameter("user_email");
		String user_firstname = request.getParameter("user_firstname");
		String user_lastname = request.getParameter("user_lastname");
		String user_pictureURL = request.getParameter("user_pictureURL");

		
		

//		RegisterBean registerBean = new RegisterBean();
//		// Using Java Beans - An easiest way to play with group of related data
//
//		registerBean.setUname(uname);
//		registerBean.setUser_password(password);
//		registerBean.setUser_email(email);
//		registerBean.setUser_firstname(user_firstname);
//		registerBean.setUser_lastname(user_lastname);
//		registerBean.setPictureURL(user_pictureURL);
		User user = new User(uname,password,email,user_firstname,user_lastname,user_pictureURL);
		

		
		UserDAO userDao = new UserDAO();

		// The core Logic of the Registration application is present here. We are going
		// to insert user data in to the database.
		String userRegistered = null;
		try {
			userRegistered = userDao.registerUser(user);
		} catch (UserException e) {
			e.printStackTrace();
		}
		if (userRegistered.equals("SUCCESS")) // On success, you can display a message to user on Home page
		{
			request.getRequestDispatcher("/Home.html").forward(request, response);
		} else // On Failure, display a meaningful message to the User.
		{
			request.setAttribute("FAIL", userRegistered);
			request.getRequestDispatcher("/Error.html").forward(request, response);	
			
		}
	}


}