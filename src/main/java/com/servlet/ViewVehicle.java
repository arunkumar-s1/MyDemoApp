package com.servlet;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.beanclass.vechiclepojo;
import com.dao.vechicleDao;  
@WebServlet("/ViewVehicle")  
/**
* used to display the values in the web 
*/
public class ViewVehicle extends HttpServlet {  
   
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();  
        RequestDispatcher rd=request.getRequestDispatcher("link.html");  
        rd.include(request, response);//method may be include or forward  
        out.println("<a href='AddVechicle.html'></a>");  
        out.println("<a href='AddVechicle.html'>Add New Vehicle</a>");  
        out.println("<h1>Vehicle List</h1>");  
          
        List<vechiclepojo> list=vechicleDao.getAllVehicle();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th><Wheels</th><th>Seats</th><th>Number plate</th><th>Edit</th><th>Delete</th></tr>");  
        for(vechiclepojo e:list){  
         out.print("<tr><td>"+e.getId()+"</td>"
        		 	+ "<td>"+e.getName()+"</td>"
        		 			+ "<td>"+e.getWheels()+"</td>"
        		 					+ "<td>"+e.getSeats()+"</td>"
        		 							+ "<td>"+e.getNumber_plate()+"</td>"
//                 +"<td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td>
//        		 +"<td><a href='ViewAdd?id="+e.getId()+"'>View Advertisement</a></td>  "  
//        		 +"<td><a href='AddAdvertisement.jsp?id="+e.getId()+"'>Add Advertisement</a></td>  "        		 							
        		 +"<td><a href='UpdateVehicle1?id="+e.getId()+"'>Update</a></td>  "
                 +"<td><a href='DeleteVehicle?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table><br><br>");  
        out.print("<a href='ProfileServlet'>Back to Profile</a>");
        out.close();  
    }  
}  
