package com.servlet;

import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;  
import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.beanclass.vechiclepojo;  
public class ProfileServlet extends HttpServlet {  
    /**
	 * 
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
            	Class.forName("oracle.jdbc.driver.OracleDriver");  
            	Connection con=DriverManager.getConnection(  
            	"jdbc:oracle:thin:@localhost:1521:xe","system","password");  
            	  
//            	PreparedStatement ps=con.prepareStatement(  
//            	"insert into user1 values(?)");  
//            	  
//            	ps.setString(1,"B");  
//            	          
//            	int i=ps.executeUpdate();  
//            	if(i>0)  
            	List<vechiclepojo> list=new ArrayList<vechiclepojo>();  
            	  PreparedStatement ps=con.prepareStatement("select * from user1");  
//                PreparedStatement ps=con.prepareStatement("select * from user905");  
                  ResultSet rs=ps.executeQuery();  
                  while(rs.next()){  
                	  vechiclepojo v= new vechiclepojo();
                      v.setName(rs.getString(1));  
                      list.add(v);  
                  }  
                  System.out.println("Hi: "+list.get(0));
                  for(vechiclepojo e:list){  
                  System.out.println(e.getName());
                  }
                  request.getRequestDispatcher("AddVechicle.html").include(request, response);  
                  request.getRequestDispatcher("AddAdvertisement.html").include(request, response); 
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
