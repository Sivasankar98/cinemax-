<%@page import="com.i2i.cinemax.exception.CustomException"%>
<html>
<head><title>ERROR PAGE</title></head>
<body>
<div dir="rtl" ><a href="index.jsp">
      <img width="80px" src="jsp/back.png" alt="back to menu"/>
      </a></div>
<%CustomException exception = (CustomException)request.getAttribute("error");%>
<h3>ERROR :<br> <%=exception%></h3>
</body>
</html>
