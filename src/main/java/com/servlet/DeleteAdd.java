package com.servlet;

import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.dao.AddDao;
/*
 * It reads the id from the user and delete the specific id from advertisement table
 */
@WebServlet("/DeleteAdd")  
public class DeleteAdd extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
        String id=request.getParameter("id");  
        int v_id=Integer.parseInt(id);  
        AddDao.delete(v_id);  
        response.sendRedirect("ViewAdd");  
    }  
}  