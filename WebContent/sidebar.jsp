<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form class="header-buttons" action="categories.jsp"> 
		<h5>Choose Category</h5>
		<br/>
				<select>
					<option value="1">Nature</option>
					<option value="2">Animals</option>
					<option value="3">Food</option>
					<option value="4">People</option>
				</select> <br><br><br/>
			</form>
	<form class="header-buttons" id="addNewPost" action="newPost.jsp">
				<input type="submit" value="Add New Post">
			</form> <br/>
</body>
</html>