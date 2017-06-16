package com.tbo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tbo.dao.LoginDao;
import com.tbo.dao.RegisterDao;
import com.tbo.dao.CheckUsernameDao;

import com.tbo.password_management.*;
import com.tbo.utils.StringUtils;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        SaltHash sh = null ;
        
        String n=request.getParameter("username");
        String f=request.getParameter("fullname");
        String p=request.getParameter("userpass"); 
        
        boolean XSSDetected = false;
        XSSDetected = (XSSDetected) || (StringUtils.containsXSS(n));
        XSSDetected = (XSSDetected) || (StringUtils.containsXSS(f));
        XSSDetected = (XSSDetected) || (StringUtils.containsXSS(p));
        
        sh = PasswordStorage.computePassword(p);                
        
        String salt = sh.getsaltObject();
        String hash = sh.getpasswordObject();
        
        HttpSession session = request.getSession(false);
        /*
        if(session!=null)
        session.setAttribute("name", n);
 */
        if(CheckUsernameDao.validate(n)){  
        	out.print("<p style=\"color:red\">Sorry username already exists.</p>"); 
        	RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
            rd.include(request,response);
        } 
        else if(XSSDetected){
        	out.print("<p style=\"color:red\">Due to the possibility of XSS, do not use the following characters: &, <,>,\",/</p>"); 
        	RequestDispatcher rd=request.getRequestDispatcher("register.jsp");  
            rd.include(request,response);        
        }
        else{  
            RegisterDao.insert(n,f,hash, salt);
            out.print("<p style=\"color:red\">User has been created.</p>");
            session.setAttribute("name", n);
            request.setAttribute("register", "true");
        	RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
        	rd.forward(request,response);
        }  

        out.close();  
    }  
} 