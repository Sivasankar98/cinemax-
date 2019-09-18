<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" type="text/css" href="/css/bottom.css">
 <link rel="stylesheet" type="text/css" href="/css/distribute.css">
<title>Movie Management</title>
<style>

</style>
</head>
<body>

<div class="navbar">
<form action="cinemax.jsp">
<button class="button" type="submit"><i class="fa fa-home"></i></button>
</form>
<form action="registerTheatre" method="post">
<button class="button" type="submit"><i style="font-family:verdana;">Add Theatre</i></button>
</form>
<form action="displayUser">
<button class="button" type="submit"><i style="font-family:verdana;">User Management</i></button>
</form>
<form action="displayMovies">
<button class="button" type="submit"><i style="font-family:verdana;">Movie Management</i></button>
</form>


<form method="post" action="logout">
    <button style="height:45px;width:100px" type="submit" value="Logout">Logout</button>
</form>

</div>

 <div class="move" align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Theatres</h2></caption>
            <tr>
                <th>TheatreID</th>
                <th>Theatre</th>
                <th>Distribute</th>
            </tr>
           <c:forEach items="${theatres}" var="theatre">
                <tr>
                    <td><c:out value="${theatre.theatreId}" /></td>
                    <td><c:out value="${theatre.theatreName}" /></td> 
                    <td>
                       <form action = "distributeMovie" method = "post">
                       <input type = "hidden" name = "theatre" value = '${theatre.theatreId}'/>
                       <button class="btn" type = "submit"><i class="fa fa-edit"></i></button>
						</form>
                    </td>
                </tr>
          </c:forEach>
        </table>
    </div>  
<div class="fixed-footer">
        <div class="containers">Copyright &copy; 2019 ideas2it</div>        
</div>  
</body>
</html>