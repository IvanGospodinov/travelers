<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles.css">

<title>Insert title here</title>
</head>
<body>

<body>
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/travel_share"
         user = "root"  password = "BratinDol14"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
      	
         SELECT * from users;
      </sql:query>
 
      <table border = "1" width = "100%">
         <tr>
            <th>user_pictureURL</th>

         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td><img src="<c:out value = "${row.user_pictureURL}"/>"/>
               <h3><c:out value = "${row.user_firstname}"/></h3>
               </td>

            </tr>
         </c:forEach>
      </table>
 
   </body>






<img alt="" src="\images\1.jpg">
</body>
</html>