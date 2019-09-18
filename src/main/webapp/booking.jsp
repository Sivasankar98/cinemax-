<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cinemax Application</title>
 <link rel="stylesheet" type="text/css" href="/css/bottom.css">
 <link rel="stylesheet" type="text/css" href="/css/booking.css">
    <style>
    
   
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <div style="position: absolute; width: 250px;">
      <a href="userManagement.jsp" class="previous round">&#8249;</a>
    </div>
    <center>
        <h1>User Management</h1>
        <h2>
            <a href="jsp/userForm.jsp">Add New User</a>
            &nbsp;&nbsp;&nbsp;
             <a href="jsp/cinemax.jsp">  <button class="btn" type = "submit"><i class="fa fa-home"></i></button></a>
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>UserID</th>
                <th>FirstName</th>
                <th>EmailId</th>
                <th>PhoneNumber</th> 
                <th>Action</th>
            </tr>
           <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.userId}" /></td>
                    <td><c:out value="${user.firstName}" /></td>
                    <td><c:out value="${user.emailId}" /></td>
                    <td><c:out value="${user.phoneNumber}" /></td>
                    <td>
                       <form action = "updateUser" method = "get">
                       <input type = "hidden" name = "userId" value = '${user.userId}'/>
                       <button class="btn" type = "submit"><i class="fa fa-edit"></i></button>
                       </form>  
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   

</body>
</html>
