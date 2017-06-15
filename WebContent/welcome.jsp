<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("name")%></title>
</head>
<body>
	<%
	String reg = (String)request.getAttribute("register");
	if("true".equals(reg)){	
	%>
    <h3>Registration successful!!!</h3>
    <%
	}
	else{    
    %>
    <h3>Login successful!!!</h3>
    <%
	}
    %>
    <h4>
        Hello,
        <%=session.getAttribute("name")%></h4>
        <br>
        <a href="/SignInProject/newpage.jsp">Protected page</a><br><br>
        <a href="logout.jsp">Logout</a>
</body>
</html>