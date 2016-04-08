<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.green.he.domain.User" %>
<%@ page isELIgnored="false" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello</title>
</head>
<body>

	<%-- <% 
	User user = (User)request.getAttribute("user");
	%>
	name :<%=user.getName() %> --%>
    <h1>Name: ${user.name}</h1>
    <h1>job:${user.address}</h1>
    <h1>con :${connection}</h1>
    <h1>DIR :${baseDir}</h1>
    
    <h1>upload</h1>
	<form action="/upload/image">
		select file:<input type="file" id="file"/>
		<input type="submit" value="Submit" />
	</form>    
</body>
</html>