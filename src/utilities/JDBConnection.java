package utilities;

import java.sql.*;

/**
 * Not used anymore 
 * 
 * @author dabrowsm
 */

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
	      String sql = "SELECT * FROM sendit_api.`order` WHERE date = (SELECT MAX(date) FROM sendit_api.`order` "
	        		+ "WHERE s_email = 'dariusz.juzwik@allegro.pl') AND s_email = 'dariusz.juzwik@allegro.pl';";
	      //stmt.executeUpdate(sql);
	      stmt.execute(sql);
	     
	      ResultSet rs = stmt.executeQuery(sql);
	      
	      while(rs.next()){
	          //Retrieve by column name
	          //int order  = rs.getInt("author");
	          String order = rs.getString("order_nr");
//	          int age = rs.getInt("age");
//	          String first = rs.getString("first");
//	          String last = rs.getString("last");

	          //Display values
	          System.out.print("Order: " + order);
//	          System.out.print(", Age: " + age);
//	          System.out.print(", First: " + first);
//	          System.out.println(", Last: " + last);
	       }
	       rs.close();
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