package com.servlet;

import java.io.IOException;  
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.beanclass.vechiclepojo;
import com.dao.vechicleDao;  
//@WebServlet("/SaveVechicle")  
public class SaveVechicle extends HttpServlet {  
    /**
	 *  used to store the  vehicle values to the db
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        RequestDispatcher rd=request.getRequestDispatcher("link.html");  
        rd.include(request, response);//method may be include or forward  
//        String id=request.getParameter("v_id"); 
//        int v_id = Integer.parseInt(id);
        String name=request.getParameter("v_name");  
        String wheels=request.getParameter("wheels");
        int wheelsInt=Integer.parseInt(wheels);
        String seats=request.getParameter("seats");
        int seatsInt=Integer.parseInt(seats);
        String number_plate=request.getParameter("number_plate");  
        vechiclepojo v=new vechiclepojo();  
//        v.setId(v_id);
        v.setName(name);
        v.setWheels(wheelsInt);
        v.setSeats(seatsInt);
        v.setNumber_plate(number_plate);
        int status=0;
		try {
			status = vechicleDao.save(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Save Vehicle: Connection failed");
		}  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("AddVechicle.html").include(request, response);  
            out.print("<a href='ProfileServlet'>Back to Profile</a>");
//            out.print("<a href='ProfileServlet'>Back to Profile</a>");
        }else{  
            out.println("Sorry! unable to save record. Try giving differnt id");  
        }  
          
        out.close();  
    }  
  
}  
