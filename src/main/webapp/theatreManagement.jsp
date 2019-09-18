<html>
<head>
    <title>Theatre Management</title>
    <style> 
      
   
      a {
        text-decoration: none;
        display: inline-block;
        padding: 8px 16px;
      }

      a:hover {
        background-color: #ddd;
        color: black;
      }

      .previous {
        background-color: lavenderBlush;
        color: black;
      }

      .next {
        background-color: #4CAF50;
        color: white;
      }

      .round {
        border-radius: 50%;
      }
    </style>
    <div style="position: absolute; width: 250px;">
            <a href="cinemax.jsp" class="previous round">&#8249;</a>
     </div>
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <center>
        <h1>Theatre Management</h1>
        <h2>
            <form action="registerTheatre" method="post">
                <button type="submit">Register Theatre</button>
            </form>
            &nbsp;&nbsp;&nbsp;
            <form action="displayTheatres" method="post">    
                <button type="submit">Display Theatres </button>
            </form>
            &nbsp;&nbsp;&nbsp;
           <a href="cinemax.jsp">  <button class="btn" type = "submit"><i class="fa fa-home"></i></button></a>
        </h2>
    </center>
</body>
</html>
