package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConnection.PostDAO;
import dbConnection.UserDAO;
import model.Post;
import model.UserException;

@WebServlet("/CreatePost")
@MultipartConfig

public class CreatePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String FILE_URL = "/Users/Desktop/USERS_FILES/";

    public CreatePost() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.getWriter().append("Served AAAAA at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		String category = request.getParameter("category");
		int category_id=Integer.parseInt(category);
		//int user_id=(int) request.getSession().getAttribute("userID");
		
		int user_id=3;
	
		
		String title = request.getParameter("title");
		String location = request.getParameter("location");
		String description = request.getParameter("description");
		
		//private Post postTest = new Post("AAABBB","AAABBB", LocalDate.now(),  LocalDate.now(), 1,1,"sofia");

		Post post = new Post(title, description, LocalDate.now(),  LocalDate.now(), user_id,category_id,location);
		
		int result =0;
		try {
			result = PostDAO.getInstance().createPost(post);
		} catch (UserException e) {
			e.printStackTrace();
		}
		//req.getRequestDispatcher("").forward(req, resp);
		return;
	
		//doGet(request, response);
		
		
		///////
		
		
	
//
//		try {
//			userDao.registerUser(user);
//			if(user.getUserID() != 0) {
//				request.getSession().setAttribute("userID", user.getUserID());
//				request.getSession().setAttribute("user", user);
//				request.getRequestDispatcher("index.jsp").forward(request, response);
//				String username = request.getParameter("name");
//				response.addCookie(new Cookie("username", user.getFirstName()));
//			
//			} else {
//				request.setAttribute("user", null);
//				request.getRequestDispatcher("/Error.html").forward(request, response);			
//			}
//		} catch (UserException e) {
//			e.printStackTrace();
//		}
//	}
		
		
		
	}

}
