<%@page language="java" import="java.util.*" %>
<html>
<head>
<title>Data Page</title>
</head>
<body> 
	
	<%Iterator itr;%>
	<% String data= (String)request.getAttribute("data");
	 out.println("Servlet communicated message to JSwP: "+ data);
	%>
	
</body>
</html>
