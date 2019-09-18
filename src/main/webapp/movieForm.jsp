<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
    <title>Add New Movie</title>
 <link rel="stylesheet" type="text/css" href="/css/bottom.css">
 <link rel="stylesheet" type="text/css" href="/css/movieForm.css">
    <style>
 
</style>
    <div style="position: absolute; width: 250px;">
            <a href="movieManagement.jsp" class="previous round">&#8249;</a>
     </div>
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
    <body>
        <div align="center">
        <table border="1" cellpadding="5">
        <h1>
            Add New User
        </h1>  
        <form:form method="post" action="createMovie" modelAttribute="movie"> 
            <table>  
            <tr>
                
                  <td><form:label path="movieName">MovieName</form:label></td>
                    <td><form:input type="text" path="movieName"/></td> 
            </tr>  
                <tr>
                
                  <td><form:label path="language">Movie Language</form:label></td>
                    <td><form:input type="text" path="language"/></td> 
            </tr>  
            <tr> 
                
                  <td><form:label path="directorName">Director Name</form:label></td>
                    <td><form:input type="text" path="directorName"/></td> 
            </tr>  
            <tr>
                
                  <td><form:label path="showDate">Release Date</form:label></td>
                    <td><form:input type="date" path="showDate"/></td> 
            </tr>  
           
            <tr> 
                <td>
                    <input type="submit" value="Add Movie"/>
                </td>
            </tr>  
            </table>  
        </form:form>
        </div>
<div class="fixed-footer">
        <div class="containers">Copyright &copy; 2019 ideas2it</div>        
</div> 
    </body>
</html>
