package com.servlet;

import java.io.IOException;  
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;  
import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {  
    /**
	 * if the login is correct then it enter into vehicle api. 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                          throws ServletException, IOException{  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        request.getRequestDispatcher("link.html").include(request, response);  
          
        Cookie ck[]=request.getCookies();  
        System.out.println(Arrays.toString(ck));
        if(ck!=null){  
        	String userPassword="";
        	 //Displaying User name value from cookie
            
             for(int i=0;i<ck.length;i++) {
            	 System.out.println("Name: "+ck[i].getName()); 
                 //Displaying user password value from cookie
                 System.out.println("Value: "+ck[i].getValue());
            	 if(ck[i].getName().equals("userPassword")) {
            		 userPassword=ck[i].getValue();
            		  System.out.println(userPassword);
            	 }
             }
             
       
        if(userPassword.equals("admin123")){  
            out.print("<b>Welcome to Profile</b>");  
            out.print("<br>Welcome, "+userPassword);  
            try{  
//            	  out.println("<a href='AddAdvertisement.html'>Add New Advertisement</a>");  
            		out.println("<h1>Vehicle</h1><br>  ");
            		out.println("<a href='AddVechicle.html'> Add Vehicle </a> <br>");
            		out.println("<a href='ViewVehicle'>View Vehicle</a><br><br>");
            		out.println("<h1>Advertisement</h1><br>  ");
            		out.println("<a href='AddAdvertisement.html'> Add Advertisement </a><br>");
            		out.println("<a href='ViewAdd'>View Advertisement</a><br><br>");
//            	  request.getRequestDispatcher("/AddVechicle.html").include(request, response);
//                  request.getRequestDispatcher("/AddAdvertisement.html").include(request, response); 
//                  out.println("You are successfully registered...");  
            	}catch (Exception e2) {System.out.println(e2);}
            
        }  
        }else{  
            out.print("Please login first");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
        out.close();  
    }  
}  
