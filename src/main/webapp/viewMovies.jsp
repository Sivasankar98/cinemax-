<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Movie Management</title>
 <link rel="stylesheet" type="text/css" href="/css/viewMovies.css">
 <link rel="stylesheet" type="text/css" href="/css/bottom.css">
<style>

</style>
</head>
<body>

<div class="navbar">
<form action="cinemax.jsp">
<button class="button" type="submit"><i class="fa fa-home"></i></button>
</form>
<form action="registerMovie" method="post">
<button class="button" type="submit"><i style="font-family:verdana;">Add Movie</i></button>
</form>
<form action="displayUser">
<button class="button" type="submit"><i style="font-family:verdana;">User Management</i></button>
</form>
<form action="displayTheatres">
<button class="button" type="submit"><i style="font-family:verdana;">Theatre Management</i></button>
</form>


<form method="post" action="logout">
    <button style="height:45px;width:100px" type="submit" value="Logout">Logout</button>
</form>

</div>

 <div class="move" align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Movies</h2></caption>

            <tr>
                <th>MovieID</th>
                <th>Movie</th>
                <th>Language</th>
                <th>Director</th>
                <th>Release Date</th>
                <th>Status</th>
                <th>Action</th>
                <th>Distribute</th>
            </tr>
           <c:forEach items="${movies}" var="movie">
                <tr>
                    <td><c:out value="${movie.movieId}" /></td>
                    <td><c:out value="${movie.movieName}" /></td>
                    <td><c:out value="${movie.language}" /></td>
                    <td><c:out value="${movie.directorName}" /></td> 
                    <td><c:out value="${movie.showDate}"/></td>
                    <td><c:out value="${movie.status}"/></td>
                    <td>
                       <form action = "getMovie" method = "post">
                       <input type = "hidden" name = "movieId" value = '${movie.movieId}'/>
                       <button class="btn" type = "submit"><i class="fa fa-edit"></i></button>
                       </form>
                       <form action = "deleteMovie" method = "post">
                       <input type = "hidden" name = "movieId" value = '${movie.movieId}'/>
                       <button class="btn" type = "submit"><i class="fa fa-trash"></i></button>
                       </form>
                     </td>
                      <th>
                       <form:form action = "selectTheatres" method = "post">
                       <input type = "hidden" name = "movieId" value = '${movie.movieId}'/>
                       <button class="btn" type = "submit"><i class="fa fa-share"></i></button>
                       </form:form>
                    </th>
                </tr>
            </c:forEach>
        </table>
    </div>  
<div class="fixed-footer">
        <div class="containers">Copyright &copy; 2019 ideas2it</div>        
</div>  
</body>
</html>
