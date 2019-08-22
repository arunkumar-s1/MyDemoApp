package com.servlet;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.beanclass.AddPojo;
import com.dao.AddDao;
@WebServlet("/UpdateAdd2")  
public class UpdateAdd2 extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String id=request.getParameter("id");  
        int v_id=Integer.parseInt(id);  
        String name=request.getParameter("name"); 
        System.out.println("update 2"+ name);
        String kilometer=request.getParameter("kilometer");  
//        int wheelsInt=Integer.parseInt(wheels);  
        String user_posted=request.getParameter("user_posted");
//        int seatsInt =Integer.parseInt(seats);  
//        String number_plate=request.getParameter("number_plate");  
          
        AddPojo e=new AddPojo();  
        e.setId(v_id);  
        e.setName(name);  
        e.setKilometer(kilometer);
        e.setUser_posted(user_posted);
//        e.setNumber_plate(number_plate);  
          
        int status=AddDao.update(e);  
        if(status>0){  
            response.sendRedirect("ViewAdd");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  