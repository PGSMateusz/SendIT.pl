package utilities;

import java.sql.*;

public class JDBConnection {
	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://192.168.50.50:3306";

	   // Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      // Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      // Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
	      
	      // Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql = "DELETE from sendit_api.user where login = 'REGISTRATION_TEST';";
	      stmt.executeUpdate(sql);
   
	   }catch(SQLException se){
	      // Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      // Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      // finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }// end finally try
	   }// end try
	  }// end main
	}// end JDBCExample