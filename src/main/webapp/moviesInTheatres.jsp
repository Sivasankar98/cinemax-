<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="stylesheet" type="text/css" href="/css/bottom.css">
 <link rel="stylesheet" type="text/css" href="/css/moviesInTheatres.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>

</style>
</head>
<body>

<div class="navbar">
<form action="userPage">
<button class="button" type="submit"><i class="fa fa-home"></i></button>
</form>

<form method="post" action="logout">
    <button style="height:45px;width:100px" type="submit" value="Logout">Logout</button>
</form>

</div>

 <div class="move" align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Running Movies</h2></caption>
            <tr>
                <th>Movie</th>
                <th>TheatreName</th>
                <th>Booking</th>
            </tr>
           <c:forEach items="${movies}" var="movie">
                <tr>
                    <td><c:out value="${movie.movieName}" /></td>
                   <td><c:forEach var="theatre" items="${movie.getTheatres()}">
                    <c:if test="${null != theatre}">
                       <c:out value="${theatre.theatreName}"/><br>
                   </c:if>
                    </c:forEach> </td>
                    <td><c:forEach items="${movie.getTheatres()}" var="theatre">
                       <form action = "bookingMovie" method = "post">
                       <input type = "hidden" name = "movieId" value = '${movie.movieId}'/>
                       <input type = "hidden" name = "theatreId" value = '${theatre.theatreId}'/>
                       <button class="btn" type = "submit"><i class="fa fa-edit"></i></button>
                       </form>
                    </c:forEach> </td>
                </tr>
            </c:forEach>
        </table>
    </div>  
<div class="fixed-footer">
        <div class="containers">Copyright &copy; 2019 ideas2it</div>        
</div>  
</body>
</html>
