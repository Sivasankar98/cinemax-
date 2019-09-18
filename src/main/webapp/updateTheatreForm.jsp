<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> Update Theatre Form </title>
 <link rel="stylesheet" type="text/css" href="/css/bottom.css">
 <link rel="stylesheet" type="text/css" href="/css/theatreForm.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

</style>
</head>
<body>

<h2>Update  Theatre Form</h2>
<div class="row">
  <div class="col-75">
    <div class="container">
    <form:form method="post" action="updateTheatre" modelAttribute="theatre">
        <div class="row">
          <div class="col-50">
            <h3>Theatre Details </h3>
            <label><i class="fa fa-user"></i> Theatre Name</label>
           <form:input type="text" path="theatreName" value="${theatre.theatreName}" required="true"/>
            <label><i class="fa fa-map"></i> Location</label>
           <form:input type="text" path="theatreLocation" value="${theatre.theatreLocation}" maxlength="25" placeholder=" Doe" required="true"/>
            <label><i class="fa fa-envelope"></i> Email</label>
            <form:input type="email" path="emailId" value="${theatre.emailId}" maxlength="25" placeholder="john@gmail.com" required="true"/> 
            <label><i class="fa fa-edit"></i> Phone Number</label>
           <form:input type="text" path="phoneNumber" value="${theatre.phoneNumber}" pattern="[6-9]{1}[0-9]{9}" maxlength="12"  placeholder="9685741230" required="true"/>
            <h3>Theatre Address </h3>
            <label><i class="fa fa-address-card-o"></i> Address</label>
            <input type="text" name="doorNumber" value="${theatre.address.get(0).doorNumber}"placeholder="542 W" required="true"/>
            <label><i class="fa fa-address-card-o"></i> Street</label>
            <input type="text" name="streetName"  value="${theatre.address.get(0).streetName}" placeholder="15th Street" required="true"/>
            <label><i class="fa fa-address-card-o"></i> Area</label>
            <input type="text" name="areaName" value="${theatre.address.get(0).areaName}" placeholder="Area " required="true"/>
            <label><i class="fa fa-institution"></i> City</label>
            <input type="text" name="cityName"  value="${theatre.address.get(0).cityName}" placeholder="Chennai" required="true"/>
            <form:hidden path="theatreId" value="${theatre.theatreId}"/>
            <form:hidden path="status" value="${theatre.status}"/>

            <div class="row">
             <div class="col-50">
                <label for="state">State</label>
                <input type="text" id="state" name="state" placeholder="TN">
              </div>
              <div class="col-50">
                <label>Zip</label>
                <input type="text" name="pincode" value="${theatre.address.get(0).pinCode}" placeholder="500001" required="true"/>
              </div>
            </div>
          </div>

          <div class="col-50">
            <h3>Manager Detail</h3>
            <label for="fname">Manager Detail</label>
            <label><i class="fa fa-user"></i>First Name</label>
            <form:input type="text" path="managerFirstName" value="${theatre.managerFirstName}" required="true"/>
            <label><i class="fa fa-user"></i>Last Name</label>
            <form:input type="text" path="managerLastName" value="${theatre.managerLastName}" maxlength="25" placeholder=" Doe" required="true"/>
            <label><i class="fa fa-envelope"></i> Email</label>
            <form:input type="email" path="managerEmailId" value="${theatre.managerEmailId}" maxlength="25" placeholder="john@gmail.com" required="true"/> 
            <label><i class="fa fa-edit"></i> Phone Number</label>
            <form:input type="text" path="managerPhoneNumber" value="${theatre.managerPhoneNumber}" pattern="[6-9]{1}[0-9]{9}" maxlength="12"  placeholder="9685741230" required="true"/>
          </div>
          
        </div>
        <input type="submit" value="Create" class="btn">
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


