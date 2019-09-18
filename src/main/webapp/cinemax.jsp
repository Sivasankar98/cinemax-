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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
 <link rel="stylesheet" type="text/css" href="/css/cinemax.css">
<style>
body {
background-image: linear-gradient(to right, #000428, #004e92);
}
</style>
</head>
<body>

<div class="navbar">
<form action="cinemax.jsp">
<button class="button" type="submit"><i class="fa fa-home"></i></button>
</form>
<form action="displayUser" method="post">
<button class="button" type="submit"><i style="font-family:verdana;">User Management</i></button>
</form>
<form action="displayTheatres">
<button class="button" type="submit"><i style="font-family:verdana;">Theatre Management</i></button>
</form>
<form action="displayMovies">
<button class="button" type="submit"><i style="font-family:verdana;">Movie Management</i></button>
</form>


<form method="post" action="logout">
    <button style="height:45px;width:100px" type="submit" value="Logout">Logout</button>
</form>

</div>
<div class="fixed-footer">
        <div class="containers">Copyright &copy; 2019 ideas2it</div>        
</div> 

</body>
</html>

