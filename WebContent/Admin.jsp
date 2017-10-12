<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page language="java" import="java.util.*" %>
    
    <%@ page import="java.sql.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="bootstrap/js/bootstrap.min.css"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#tabs" ).tabs();
  });
  

  </script>
<title>Insert title here</title>
</head>

<body>
<%! String driverName = "oracle.jdbc.driver.OracleDriver";%>
<%!String url = "jdbc:oracle:thin:mpatekar/YCsBUo3.uK3Y@fourier.cs.iit.edu:1521:orcl";%>
<%!String user = "mpatekar";%>
<%!String psw = "YCsBUo3.uK3Y";%>


<%
  String message = (String)request.getAttribute("data");
  out.println("Servlet communicated message to JSwP: "+ message);

 // Vector vecObj = (Vector) request.getAttribute("vecBean");
//  out.println("Servlet to JSP communication of an object: "+vecObj.get(0));
%>

<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Movies</a>
    </div>
	<div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Person</a>
    </div>
	

  </div><!-- /.container-fluid -->
</nav>

<div id="tabs">
  <ul>
    <li><a href="#Movies">Movies</a></li>
    <li><a href="#Rooms">Rooms</a></li>
    <li><a href="#Persons">Persons</a></li>
     <li><a href="#Showing">Showing</a></li>
  </ul>
  
  
   <!-- MOVIES  -->
  <div id="Movies" style="height:500px">
    <p>Movies  
    
<form action="indexServelet">			
			 Welcome Admin
			
<form class="form-horizontal" role="form">
  <div class="form-group">
    <label for="MovieName" class="col-sm-2 control-label">Movie Title</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  name="MovieTittle" id="MovieTittle" placeholder="MovieName">
    </div>
  </div>
  <div class="form-group">
    <label for="MovieLength" class="col-sm-2 control-label">Movie Length</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="MovieLength" id="MovieLength" placeholder="MovieLength">
    </div>
  </div>
 <div class="form-group">
    <label for="Year" class="col-sm-2 control-label">Year</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="Year" id="Year" placeholder="Year">
    </div>
  </div>
 
 <p>
    PG Rating
    
    <select name="Rating" id="MovieLength">
  <option value="ua">UA</option>
  <option value="A">A</option>
  <option value="Pgrating">Pgrating</option>
</select>
  </p>
 
  <p>
    Genre
   
    <select form-control" name="Genre" id="genre">
  <option value="Action">Action</option>
<option value="Thrilling">Thrilling</option>
  <option value="Romantic">Romantic</option>
  <option value="Animation">Animation</option>
</select>
   
  </p>
  
  
 
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">AddMovie</button>
    </div>
  </div>
</form>				
		</form>
    </p>
  </div>
  
  
  
  <!-- ROOMS  -->
  <div id="Rooms" style="height:500px">
    <p>ROOMS</p>
    <form action="RoomServlet">			
			 Welcome Admin
<form class="form-horizontal" role="form">
  <div class="form-group">
    <label for="RoomName" class="col-sm-2 control-label">Room Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  name="RoomName" id="RoomName" placeholder="Room Name">
    </div>
  </div>
  
  
  <div class="form-group">
    <label for="Capacity" class="col-sm-2 control-label">Capacity</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  name="Capacity" id="Capacity" placeholder="Capacity">
    </div>
  </div>
 
  <div class="form-group">
    <label for="FloorNo" class="col-sm-2 control-label">Floor No</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  name="FloorNo" id="FloorNo" placeholder="Floor no">
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Add Room</button>
    </div>
  </div>
  </form>
  </form>
  </div>
  
  
  <!-- PERSONS -->
  <div id="Persons" style="height:500px">
    <p>Persons</p>
    <form action="PersonsServlet" name="Person">
    <form class="form-horizontal" role="form">
  <div class="form-group">
    <label for="Name" class="col-sm-2 control-label">Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  name="Name" id="Name" placeholder="Name">
    </div>
  </div>
  <div class="form-group">
    <label for="DOB" class="col-sm-2 control-label">Date of Birth</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="DOB" id="DOB" placeholder="mm/dd/yyyy">
    </div>
  </div>
 
 <div class="form-group">
    <label for="EmailID" class="col-sm-2 control-label">Email ID</label>
    <div class="col-sm-10">
    <input type="text" class="form-control" name="EmailID" id="EmailID" placeholder="EmailID">
    </div>
  </div>
 
 <div class="form-group">
    <label for="Year" class="col-sm-2 control-label">Address</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="Address" id="Address" placeholder="Address">
    </div>
  </div>
 
 <div class="form-group">
    <label for="Gender" class="col-sm-2 control-label">Gender</label>
    <div class="col-sm-10">
    <select form-control" name="Gender" id="Gender">
  <option value="male">Male</option>
  <option value="female">Female</option>
</select>
    </div>
  </div>
 <p>
 </p>
 
    <label for="Type" class="col-sm-2 control-label">Person Type</label>
    <select form-control" name="Type" id="Type">
  <option value="Actor">Actor</option>
  <option value="Director">Director</option>
  <option value="Writer">Writer</option>
</select>
    
 
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Add Person</button>
    </div>
  </div>
</form>				
    </form>
  </div>
  
   <!-- SHOWING  -->
<div id="Showing" style="height:500px">
    <p>Showing</p>
    <form action="ShowingServlet">
    
    <%
Connection con = null;
PreparedStatement ps = null;
try
{
Class.forName(driverName);
con = DriverManager.getConnection(url,user,psw);
String sql = "SELECT * FROM MOVIES";
ps = con.prepareStatement(sql);
ResultSet rsMovies = ps.executeQuery(); 
String sqlRoom="SELECT * FROM ROOM";
ps = con.prepareStatement(sqlRoom);
ResultSet rsRoom = ps.executeQuery(); 

%>
<p>Select Movie :
<select name="MovieId" id="MovieId" >
<%
while(rsMovies.next())
{
String fname = rsMovies.getString("TITLE");
int id=rsMovies.getInt("MOVIEID");
//out.println(id);
%>
<option value="<%=id %>"><%=fname %></option>
<%
}
%>
</select>
</p>

<p>Select Room :
<select name="RoomId" id="RoomId">
<%
while(rsRoom.next())
{
String RoomName = rsRoom.getString("ROOMNAME");
int roomId=rsRoom.getInt("ROOMID");
%>
<option value="<%=roomId %>"><%=RoomName %></option>
<%
}
%>
</select>
</p>
<%
}
catch(SQLException sqe)
{ 
out.println(sqe);
}
%>

  <div class="form-group">
    <label for="ShowDate" class="col-sm-2 control-label">Show Date</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  name="ShowDate" id="ShowDate" placeholder="MM/dd/yyy">
    </div>
  </div>
  
  <div class="form-group">
    <label for="ShowTime" class="col-sm-2 control-label">Show Time</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  name="ShowTime" id="ShowTime" placeholder="">
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Add Shows</button>
    </div>
  </div>
</form>
</div>
</div>
</body>
</html>