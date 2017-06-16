<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Application</title>
</head>
<body>
    <form name="LoginForm" action="loginServlet" method="post">
        <fieldset style="width: 300px">
            <legend> Login to App </legend>
            <table>
                <tr>
                    <td>User ID</td>
                    <td><input type="text" name="username" required="required" onKeyPress="checkEnter()" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="userpass" required="required" onKeyPress="checkEnter()" /></td>
                </tr>
                <tr>
                    <td><input type="button" onClick="submitValues()" value="Login" /></td>
                </tr>
            </table>
        </fieldset>
    </form>
    New user? Register <a href="/SignInProject/register.jsp">here</a>
    <br>
    <a href="/SignInProject/newpage.jsp">Protected page</a>
    
</body>
<script language="javascript">
function submitValues(){	
	var uname = document.forms["LoginForm"].elements["username"].value;
	var upass = document.forms["LoginForm"].elements["userpass"].value;
	
	if( (uname == null) || (uname =="") ){
		alert("Username cannot be null");
		document.forms["LoginForm"].elements["username"].focus();
		return;
		
	}
	/*
	if ((uname.indexof('/')>-1) || (uname.indexof('>')>-1) || (uname.indexof('<')>-1) || (uname.indexof('&')>-1) || (uname.indexof('\"')>-1) ){
		alert("Invalid character in username");
		document.forms["LoginForm"].elements["username"].focus();
		return;
	}
	*/
	if( (upass == null) || (upass =="") ){
		alert("Password cannot be null");
		document.forms["LoginForm"].elements["userpass"].focus();
		return;
		
	}
	/*
	if ((upass.indexof('/')>-1) || (upass.indexof('>')>-1) || (upass.indexof('<')>-1) || (upass.indexof('&')>-1) || (upass.indexof('\"')>-1) ){
		alert("Invalid character in password");
		document.forms["LoginForm"].elements["userpass"].focus();
		return;
	}
	*/
	document.forms["LoginForm"].method = "post";
	document.forms["LoginForm"].submit();
}
function checkEnter(){
	var nKeyCode = window.event.keyCode;
	
	//Check for enter key
	if (nKeyCode == 13)
		submitValues();
	
}
</script>
</html>