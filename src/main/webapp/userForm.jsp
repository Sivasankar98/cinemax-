<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> User Form </title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="stylesheet" type="text/css" href="/css/bottom.css">
 <link rel="stylesheet" type="text/css" href="/css/userForm.css">
<style>

</style>
</head>
<body>

<h2>Create User Form</h2>
<div class="row">
  <div class="col-75">
    <div class="container">
    <form:form method="post" action="createUser" modelAttribute="user">
        <div class="row">
          <div class="col-50">
            <h3>User Details </h3>
            <label><i class="fa fa-user"></i> First Name</label>
           <form:input type="text" path="firstName" required="true"/>
            <label><i class="fa fa-user"></i> Last Name</label>
           <form:input type="text" path="lastName" maxlength="25" placeholder=" Doe" required="true"/>
            <label><i class="fa fa-envelope"></i> Email</label>
            <form:input type="email" path="emailId" maxlength="25" placeholder="john@gmail.com" required="true"/> 
            <label><i class="fa fa-edit"></i> Phone Number</label>
            <form:input type="text" path="phoneNumber" pattern="[6-9]{1}[0-9]{9}" maxlength="10" placeholder="9685741230" required="true"/>
            <h3>Permanent Address </h3>
            <label><i class="fa fa-address-card-o"></i> Address</label>
            <input type="text" name="permanentDoorNumber" placeholder="542 W" required="true"/>
            <label><i class="fa fa-address-card-o"></i> Street</label>
            <input type="text" name="permanentStreetName" placeholder="15th Street" required="true"/>
            <label><i class="fa fa-address-card-o"></i> Area</label>
            <input type="text" name="permanentAreaName" placeholder="Area " required="true"/>
            <label><i class="fa fa-institution"></i> City</label>
            <input type="text" name="permanentCityName" placeholder="Chennai" required="true"/>

            <div class="row">
             <div class="col-50">
                <label for="state">State</label>
                <input type="text" id="state" name="state" placeholder="TN" required="true"/>
              </div>
              <div class="col-50">
                <label>Zip</label>
                <input type="text" name="permanentPincode" placeholder="500001" required="true"/>
              </div>
            </div>
          </div>

          <div class="col-50">
            <h3>Address</h3>
            <label for="fname">Present Address</label>
            <label><i class="fa fa-address-card-o"></i> Address</label>
            <input type="text" name="presentDoorNumber" placeholder="542 W" required="true" />
            <label><i class="fa fa-address-card-o"></i> Street</label>
            <input type="text" name="presentStreetName" placeholder="15th Street" required="true"/>
            <label><i class="fa fa-address-card-o"></i> Area</label>
            <input type="text" name="presentAreaName" placeholder="Area " required="true"/>
            <label><i class="fa fa-institution"></i> City</label>
            <input type="text"name="presentCityName" placeholder="Chennai" required="true"/>

            <div class="row">
             <div class="col-50">
                <label for="state">State</label>
                <input type="text" id="state" name="state" placeholder="TN" required="true"/>
              </div>
              <div class="col-50">
                <label>Zip</label>
                <input type="text" name="presentPincode" placeholder="600408" rrequired="true"/>
              </div>
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

