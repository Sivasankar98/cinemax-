<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> User Form </title>
 <link rel="stylesheet" type="text/css" href="/css/bottom.css">
 <link rel="stylesheet" type="text/css" href="/css/updateUserForm.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

</style>
</head>
<body>

<h2>Create User Form</h2>
<div class="row">
  <div class="col-75">
    <div class="container">
    <form:form method="post" action="updateUser" modelAttribute="user">
        <div class="row">
          <div class="col-50">
            <h3>User Details </h3>
            <label><i class="fa fa-user"></i> First Name</label>
           <form:input type="text" path="firstName" value="${user.firstName}" required="true" />
            <label><i class="fa fa-user"></i> Last Name</label>
           <form:input type="text" path="lastName" value="${user.lastName}" maxlength="25" placeholder=" Doe" required="true"/>
            <label><i class="fa fa-envelope"></i> Email</label>
            <form:input type="email" path="emailId" value="${user.emailId}" maxlength="25" placeholder="john@gmail.com" required="true"/> 
            <label><i class="fa fa-edit"></i> Phone Number</label>
           <form:input type="text" path="phoneNumber"  value="${user.phoneNumber}" pattern="[6-9]{1}[0-9]{9}"  maxlength="12"  placeholder="9685741230" required="true"/>
           
            <form:hidden path="userId" value="${user.userId}"/>
            <form:hidden path="status" value="${user.status}"/>

          <div class="col-50">
            <td><b>Present Address:</b></td>
        <tr>
              <label><i class="fa fa-address-card-o"></i> DoorNumber</label>
            <td>
                <input type = "text" name="presentDoorNumber" maxlength="25" c:out value="${user.address.get(1).doorNumber}" required="true"/>
            </td>
        </tr>
        <tr>
            <label><i class="fa fa-address-card-o"></i> Street</label>
            <td>
                <input type = "text" name="presentStreetName" maxlength="25" c:out value="${user.address.get(1).streetName}"required="true"/>
            </td>
        </tr>
        <tr>
             <label><i class="fa fa-address-card-o"></i> Area</label>
            <td>
                <input type = "text" name="presentAreaName" maxlength="25"  c:out value="${user.address.get(1).areaName}" required="true"/>
            </td>
        </tr>
        <tr>
            <label><i class="fa fa-institution"></i> City</label>
            <td>
                <input type = "text" name="presentCityName" maxlength="25" c:out value="${user.address.get(1).cityName}" required="true"/>
            </td>
        </tr>
        <tr>
            <td> Pincode:</td>
            <td>
                <input type = "text" name="presentPincode" maxlength="6" c:out value="${user.address.get(1).pinCode}" required="true"/>
            </td>
        </tr>
          
        </div>
        <input type="submit" value="Update" class="btn">
        &nbsp&nbsp&nbsp
        <input type="reset" value="cancel" class="cancelbtn">
      </form:form>
    </div>
  </div>
<div class="fixed-footer">
        <div class="containers">Copyright &copy; 2019 ideas2it</div>        
</div> 
</body>
</html>

              
