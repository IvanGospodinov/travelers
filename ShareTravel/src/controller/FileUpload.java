package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringEscapeUtils;

import model.User;


/**
 * Servlet implementation class SignUpServlet
 */
// @WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pr = response.getWriter();
		String uname = request.getParameter("uname");
		String password = request.getParameter("user_password");
		String email = request.getParameter("user_email");
		String user_firstname = request.getParameter("user_firstname");
		String user_lastname = request.getParameter("user_lastname");
		String user_pictureURL = request.getParameter("user_pictureURL");
		// byte[] file =request.getParameter("profilpic").getBytes();
//		pr.println(fname);
//		pr.println(lname);
//		pr.println(email);
//		pr.println(pass);
		pr.println("dsfvdvdfsv");

		// if (!UserDAO.checkIfExists(email)) {
		User user = new User(uname, password, email, user_firstname, user_lastname, user_pictureURL);
		PrintWriter out = response.getWriter();

		if (!ServletFileUpload.isMultipartContent(request)) {
			out.println("Nothing to upload");
			return;
		}
		FileItemFactory itemfactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(itemfactory);
		try {
			HttpServletRequest request2 = request;
			List<FileItem> items = upload.parseRequest(request2);
			for (FileItem item : items) {

				String contentType = item.getContentType();
				
					if (!item.getFieldName().equals("profilpic")) {
						out.println("only png format image files supported");
						continue;
					}
				
				// 10275942_797222240295519_2409051625224068118_n.jpg
				File uploadDir = new File(
						"C:/Users/Ivan/Desktop/Java EE/ShareTravel/WebContent/Images/");
				// if(!uploadDir.exists()){
				// uploadDir.createNewFile();
				// }
				out.println("name: " + item.getName());
				out.println("size: " + item.getSize());
				out.println("formfield: " + item.isFormField());
				out.println("Content type: " + item.getContentType());
				// out.println("name: "+item.);

				File file = File.createTempFile(item.getFieldName(), ".jpg", uploadDir);
				item.write(file);
				out.println("file name uploadet: "+file.getName());
				out.println("File Saved Successfully");
			}
		} catch (FileUploadException e) {
			out.println(e.getMessage());
			out.println("upload fail");
		} catch (Exception ex) {
			out.println(ex.getMessage());
			ex.printStackTrace();
			out.println("can't save");
		}
		// long userID = UserDAO.insertUser(user);
		// request.getSession().setAttribute("email", email);
		// request.getSession().setAttribute("id", (long) userID);
		// response.sendRedirect("./index.jsp");
		// } else {
		// response.sendRedirect("./index.html?error=userEmailExists");
		// }
		// response.setContentType("text/html");

	}
}