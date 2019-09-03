package com.servlet;

import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.beanclass.vechiclepojo;
import com.dao.vechicleDao;  
@WebServlet("/UpdateVehicle2")  
public class UpdateVehicle2 extends HttpServlet {  
	   /**
		 * get the values and update in the db 
		 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        int status = 0;
		try {
			 	String id=request.getParameter("id");  
		        int v_id=Integer.parseInt(id);  
		        String name=request.getParameter("name"); 
		        System.out.println("update 2"+ name);
		        String wheels=request.getParameter("wheels");  
		        int wheelsInt=Integer.parseInt(wheels);  
		        String seats=request.getParameter("seats");
		        int seatsInt =Integer.parseInt(seats);  
		        String number_plate=request.getParameter("number_plate");  
		        String date_of_purchase=request.getParameter("date_of_purchase");  
		        Date date_of_purchase1=new SimpleDateFormat("yyyy-MM-dd").parse(date_of_purchase);  
		        System.out.println("date_of_purchase update: "+date_of_purchase1);
		          
		        vechiclepojo e=new vechiclepojo();  
		        e.setId(v_id);  
		        e.setName(name);  
		        e.setWheels(wheelsInt);  
		        e.setSeats(seatsInt);  
		        e.setNumber_plate(number_plate);  
		        e.setDateOfPurchase(date_of_purchase1);
			status = vechicleDao.update(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Update Vehicle2: Connection failed");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			System.out.println("Update Vehicle2: Connection failed"+ e1.getMessage());
		}  
        if(status>0){  
            response.sendRedirect("ViewVehicle");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  