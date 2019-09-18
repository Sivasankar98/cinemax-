<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
* {
  box-sizing: border-box;
}

body {
  margin: 0;
}

.navbar {
  overflow: hidden;
  background-color: #444;
  font-family: Arial, Helvetica, sans-serif;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
   background: #ddd;
  color: black;
}

 
.navbar button:hover {
    background-color: red;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  width: 100%;
  left: 0;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content .header {
  background: red;
  padding: 16px;
  color: white;
}

.dropdown:hover .dropdown-content {
  display: block;
}

/* Create three equal columns that floats next to each other */
.column {
  float: left;
  width: 33.33%;
  padding: 10px;
  background-color: #ccc;
  height: 250px;
}

.column a {
  float: none;
  color: black;
  padding: 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.column a:hover {
  background-color: #ddd;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}





.navbar button {
  float: left;
  background-color: #333;
  color: #f2f2f2;
  padding: 14px 16px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 17px;
  position: fixed;
  right: 10px;
  cursor: pointer;
  margin: 1px 1px;
}

</style>
</head>
<body>

<div class="navbar">
  <a href="cinemax.jsp"><i class="fa fa-home"></i></a>
  <a href="userManagement.jsp">User Management</a>
  <a href="theatreManagement.jsp">Theatre Management</a>
  <a href="movieManagement.jsp">MovieManagement</a>
  <form method="post" action="logout">
    <button style="height:45px;width:100px" type="submit" value="Logout">Logout</button>
  </form>
</div>
  <form action="registerUser" method="post">
      <button type="submit">Add New User</button>
    </form>
  <form action="displayUser" method="post">
    <button type="submit">Display User</button>
   </form>


<div style="padding:16px">
  <h3> Welcome to Cinemax </h3>
</div>
  

</body>
</html>

