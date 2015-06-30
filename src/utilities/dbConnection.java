package utilities;

import java.sql.*;

public class dbConnection {

	 public static void main(String args[]) throws ClassNotFoundException, SQLException {
		 
	 String dbUrl = "jdbc:mysql://192.168.50.50:3306";  //This URL is based on your IP address
	 String username = "root"; //Default username is root
	 String password = ""; //Default password is root
	 String dbClass = "com.mysql.jdbc.Driver";
	 String query = "delete from sendit_api.user where login = 'REGISTRATION_TEST';";

	 try {

	 Class.forName(dbClass);
	 Connection con = DriverManager.getConnection (dbUrl, username, password);
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);

	 while (rs.next()) {
		 
	 String uName = rs.getString(1);
	 System.out.println(uName);
	 
	 } //end while

	 con.close();
	 
	 } //end try

	 catch(ClassNotFoundException e) {
	 
		 e.printStackTrace();
	 }

	 catch(SQLException e) {
	 
		 e.printStackTrace();
	 }
	
   }  //end main
	
}
