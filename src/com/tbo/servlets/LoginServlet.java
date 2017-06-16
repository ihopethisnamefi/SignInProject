package com.tbo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tbo.dao.CheckUsernameDao;
import com.tbo.dao.LoginDao;


import com.tbo.password_management.*;
import com.tbo.utils.StringUtils;

public class LoginServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
              
        String n=request.getParameter("username");  
        String p=request.getParameter("userpass"); 
        
        boolean XSSDetected = false;
        XSSDetected = (XSSDetected) || (StringUtils.containsXSS(n));
        XSSDetected = (XSSDetected) || (StringUtils.containsXSS(p));
        

        HttpSession session = request.getSession(false);
        /*
        if(session!=null)
        session.setAttribute("name", n);
 */
        if(XSSDetected){
        	out.print("<p style=\"color:red\">Due to the possibility of XSS, do not use the following characters: &, <,>,\",/</p>"); 
        	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
            rd.include(request,response);        
        }
        else{
            if(CheckUsernameDao.validate(n)){
    	        if(Authentication.authenticate(n, p)){  
    	            if(session!=null){
    	                session.setAttribute("name", n);
    	                request.setAttribute("register", "false");
    	            	RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
    	            	rd.forward(request,response); 
    	        	}
    	        } 
    	        else{  
    	            out.print("<p style=\"color:red\">Sorry username or password error</p>");
    	            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
    	            rd.include(request,response);  
    	        }  
            }
            else{
                out.print("<p style=\"color:red\">Username does not exist! Please register</p>");
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
                rd.include(request,response);         	
            }
        	       	
        }
        
        out.close();  
    }  
} 