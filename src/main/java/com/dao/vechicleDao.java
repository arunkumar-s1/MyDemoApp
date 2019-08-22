package com.dao;
import java.util.*;

import com.beanclass.vechiclepojo;
import com.database.connection.DatabaseConnection;

import java.sql.*;
public class vechicleDao {
//	 public static Connection getConnection(){  
//	        Connection con=null;  
//	        try{  
//	            Class.forName("oracle.jdbc.driver.OracleDriver");  
//	            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");  
//	        }catch(Exception e){System.out.println(e);}  
//	        return con;  
//	    }  
	    public static int save(vechiclepojo v){  
	        int status=0;  
	        try{  
	            Connection con=DatabaseConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into vehicle values (seq_person.nextval,?,?,?,?)");  
//	            ps.setInt(1, v.getId());
	            ps.setString(1,v.getName()); 
	            ps.setInt(2, v.getWheels());
	            ps.setInt(3, v.getSeats());
	            ps.setString(4, v.getNumber_plate());
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int update(vechiclepojo e){  
	        int status=0;  
	        try{  
	            Connection con=DatabaseConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update vehicle set v_name=?,wheels=?,seats=?,number_plate=? where v_id=?");  
	            ps.setString(1,e.getName());  
	            ps.setInt(2,e.getWheels());  
	            ps.setInt(3,e.getSeats());  
	            ps.setString(4,e.getNumber_plate());  
	            ps.setInt(5,e.getId());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int delete(int id){  
	        int status=0;  
	        try{  
	            Connection con=DatabaseConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from vehicle where v_id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static vechiclepojo getVehicleById(int id){  
	    	vechiclepojo e=new vechiclepojo();  
	          
	        try{  
	            Connection con=DatabaseConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from vehicle where v_id=?");  
	            ps.setInt(1,id);  
	            System.out.println(id);
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                e.setId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setWheels(rs.getInt(3));  
	                e.setSeats(rs.getInt(4));  
	                e.setNumber_plate(rs.getString(5));  
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return e;  
	    }  
	    public static List<vechiclepojo> getAllVehicle(){  
	        List<vechiclepojo> list=new ArrayList<vechiclepojo>();  
	          
	        try{  
	            Connection con=DatabaseConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from vehicle");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	            	System.out.println(rs.getInt(3));
	                vechiclepojo v=new vechiclepojo();  
	                v.setId(rs.getInt(1));
	                v.setName(rs.getString(2));
	                v.setWheels(rs.getInt(3));
	                v.setSeats(rs.getInt(4));
	                v.setNumber_plate(rs.getString(5));
	                
	                list.add(v);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
}
