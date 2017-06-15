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

import com.tbo.dao.LoginDao;


import com.tbo.password_management.*;

public class LoginServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
              
        String n=request.getParameter("username");  
        String p=request.getParameter("userpass"); 
        

        HttpSession session = request.getSession(false);
        /*
        if(session!=null)
        session.setAttribute("name", n);
 */
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

        out.close();  
    }  
} 