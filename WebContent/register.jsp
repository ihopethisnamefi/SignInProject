<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
    <form name="RegisterForm" action="RegistrationServlet" method="post">
        <fieldset style="width: 300px">
            <legend> Register to App </legend>
            <table>
                <tr>
                    <td>User ID</td>
                    <td><input type="text" name="username" required="required" onKeyPress="checkEnter()" /></td>
                </tr>
                <tr>
                    <td>Full Name</td>
                    <td><input type="text" name="fullname" required="required" onKeyPress="checkEnter()" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="userpass" required="required" onKeyPress="checkEnter()" /></td>
                </tr>
                <tr>
                    <td>Confirm Password</td>
                    <td><input type="password" name="confirmpass" required="required" onKeyPress="checkEnter()" /></td>
                </tr>
                <tr>
                    <td><input type="button" onClick="selectedValues()" value="Register" /></td>
                </tr>
            </table>
        </fieldset>
    </form>

</body>
<script language="javascript">
function selectedValues(){
	
	var uname = document.forms["RegisterForm"].elements["username"].value;
	var fname = document.forms["RegisterForm"].elements["fullname"].value;
	var p1 = document.forms["RegisterForm"].elements["userpass"].value;
	var p2 = document.forms["RegisterForm"].elements["confirmpass"].value;
	
	if( (uname == null) || (uname =="") ){
		alert("Username cannot be null");
		document.forms["RegisterForm"].elements["username"].focus();
		return;
		
	}
	/*
	if ((uname.indexof('/')>-1) || (uname.indexof('>')>-1) || (uname.indexof('<')>-1) || (uname.indexof('&')>-1) || (uname.indexof('\"')>-1) ){
		alert("Invalid character in username");
		document.forms["RegisterForm"].elements["username"].focus();
		return;
	}
	*/
	if( (fname == null) || (fname =="") ){
		alert("Full name cannot be null");
		document.forms["RegisterForm"].elements["fullname"].focus();
		return;
		
	}
	/*
	if ((fname.indexof('/')>-1) || (fname.indexof('>')>-1) || (fname.indexof('<')>-1) || (fname.indexof('&')>-1) || (fname.indexof('\"')>-1) ){
		alert("Invalid character in fullname");
		document.forms["RegisterForm"].elements["fullname"].focus();
		return;
	}
	*/
	
	if( (p1 == null) || (p1 =="") ){
		alert("Password cannot be null");
		document.forms["RegisterForm"].elements["userpass"].focus();
		return;
		
	}
	/*
	if ((p1.indexof('/')>-1) || (p1.indexof('>')>-1) || (p1.indexof('<')>-1) || (p1.indexof('&')>-1) || (p1.indexof('\"')>-1) ){
		alert("Invalid character in password");
		document.forms["RegisterForm"].elements["userpass"].focus();
		return;
	}
	*/
	if( (p2 == null) || (p2 =="") ){
		alert("Confirm password cannot be null");
		document.forms["RegisterForm"].elements["confirmpass"].focus();
		return;
		
	}
	/*
	if ((p2.indexof('/')>-1) || (p2.indexof('>')>-1) || (p2.indexof('<')>-1) || (p2.indexof('&')>-1) || (p2.indexof('\"')>-1) ){
		alert("Invalid character in confirm password");
		document.forms["RegisterForm"].elements["confirmpass"].focus();
		return;
	}
	*/
	
	if( p1 != p2){		
		alert("Password fields must match");
		document.forms["RegisterForm"].elements["userpass"].focus();
		return;			
	}
	
	document.RegisterForm.method ="post";
	document.RegisterForm.submit();
	
}

function checkEnter(){
	var nKeyCode = window.event.keyCode;
	
	//Check for enter key
	if (nKeyCode == 13)
		selectedValues();
	
}
</script>
</html>