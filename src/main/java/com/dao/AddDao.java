package com.dao;
import java.util.*;

import com.beanclass.AddPojo;
//import com.beanclass.vechiclepojo;
import com.database.connection.DatabaseConnection;

import java.sql.*;
/*
 * this class represent the database operation(CRUD) for advertisement 
 */
public class AddDao {
//	 public static Connection getConnection(){  
//	        Connection con=null;  
//	        try{  
//	            Class.forName("oracle.jdbc.driver.OracleDriver");  
//	            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");  
//	        }catch(Exception e){System.out.println(e);}  
//	        return con;  
//	    }  
	    public static int save(AddPojo a){  
	        int status=0;  
	        try{  
	            Connection con=DatabaseConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into advertisement values (?,?,?,?)");  
//	            ps.setInt(1, v.getId());
	            ps.setString(1,a.getName()); 
	            ps.setInt(2, a.getId());
	            ps.setString(3, a.getKilometer());
	            ps.setString(4, a.getUser_posted());
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int update(AddPojo e){  
	        int status=0;  
	        try{  
	            Connection con=DatabaseConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update advertisement set name=?,kilometer=?,user_posted=? where id=?");  
	            ps.setString(1,e.getName());  
	            ps.setString(2,e.getKilometer());  
	            ps.setString(3,e.getUser_posted());  
//	            ps.setInt(4,e.getNumber_plate());  
	            ps.setInt(4,e.getId());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int delete(int id){  
	        int status=0;  
	        try{  
	            Connection con=DatabaseConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from advertisement where id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static AddPojo getAddById(int id){  
	    	AddPojo e=new AddPojo();  
	          
	        try{  
	            Connection con=DatabaseConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from advertisement where id=?");  
	            ps.setInt(1,id);  
	            System.out.println(id);
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                e.setId(rs.getInt(2));  
	                e.setName(rs.getString(1));  
	                e.setKilometer(rs.getString(3));  
	                e.setUser_posted((rs.getString(4)));  
	                
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return e;  
	    }  
	    public static List<AddPojo> getAllAdd(){  
	        List<AddPojo> list=new ArrayList<AddPojo>();  
	          
	        try{  
	            Connection con=DatabaseConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from advertisement");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	            	System.out.println(rs.getString(3));
	                AddPojo v=new AddPojo();  
	                v.setName(rs.getString(1));
	                v.setId(rs.getInt(2));
	                v.setKilometer((rs.getString(3)));
	                v.setUser_posted((rs.getString(4)));
	                list.add(v);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
}
