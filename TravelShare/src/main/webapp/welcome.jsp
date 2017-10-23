<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-16">
<title>Insert title here</title>
</head>
<body>

	<form action="./CreatePost" metod="post" enctype="multipart/form-data">
		<fieldset>
			<legend>Create post</legend>


			<table align="left">

				<tr>
					<td>Category</td>
					<td><select name="category">
							<option value="SEA">Sea</option>
							<option value="MAUNTAIN">Mountain</option>
							<option value="CAVE">Cave</option>
							<option value="CITY">City</option>

					</select></td>


				</tr>

				<tr>
					<td>Title</td>
					<td><input type="text" name="title"></td>
				</tr>
				
				<tr>
					<td>Location</td>
					<td><input type="text" name="location"></td>
				</tr>
				

				<tr>
					<td>Description</td>
					<td><textarea name="description" rows="5" cols="20"></textarea></td>
				</tr>
<!-- 

				<tr>
					<td>Select files</td>
					<td><input type="file" name="file"></td>

				</tr>
				
				<tr>
					<td></td>
					<td><input type="file" name="file"></td>

				</tr>
				
				<tr>
					<td></td>
					<td><input type="file" name="file"></td>

				</tr>
				
	-->			

				<tr>
					<td></td>
					<td><input type="submit" value="submit" ></td>

				</tr>

			</table>
	</form>






</body>
</html>