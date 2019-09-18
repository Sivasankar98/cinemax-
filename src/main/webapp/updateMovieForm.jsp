<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
    <head>
        <title> Update Movie </title>
 <link rel="stylesheet" type="text/css" href="/css/bottom.css">
       
    </head>
    <body>
        <h1>Update Movie</h1>  
        <form:form method="post" action="updateMovie" modelAttribute="movie"> 
        <table>  
        
            <form:hidden path="movieId" value="${movie.movieId}"/>
            <form:hidden path="status" value="${movie.status}"/>
        
        <tr>
            
            <td><form:label path="movieName">Movie Name</form:label></td>
            <td><form:input type="text" path="movieName" value="${movie.movieName}"/></td> 
           
        </tr>  
        <tr>
            <td><form:label path="language">Movie Language</form:label></td>
                    <td><form:input type="text" path="language" value="${movie.language}"/></td> 
        </tr>  
        <tr>
            <td><form:label path="directorName">Director Name</form:label></td>
                    <td><form:input type="text" path="directorName" value="${movie.directorName}"/></td> 

        </tr>  
        <tr>

            <td><form:label path="showDate">Release Date</form:label></td>
                    <td><form:input type="date" path="showDate" value="${movie.showDate}"/></td> 
          
        </tr>  
        <tr>
           
            <tr>
            <td> <button type = "submit">Update</button>
            </td>
        </tr>
        </table>  
        </form:form>  
<div class="fixed-footer">
        <div class="containers">Copyright &copy; 2019 ideas2it</div>        
</div> 
    </body>
</html>

              
