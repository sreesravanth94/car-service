package sqljava;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertServices {
	
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/carservice";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "password";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   PreparedStatement stmt = null;    	
	   ResultSet rs = null;
	
	Scanner keyboard = null;

	try {
		keyboard = new Scanner(new File("data.in"));
	} catch (FileNotFoundException e1) {
		System.out.println("file not found");
        System.exit(0);
	}

	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("JDBC driver loaded");

		String url = "jdbc:mysql://localhost/carservice";
		conn = DriverManager.getConnection(url, "root", "password");
		System.out.println("Database connection established");

        stmt = conn.prepareStatement("INSERT INTO carservice " + 
        		"(Service,ServicePrice)" + 
        		" VALUES (?,?)");

		System.out.println("\nLoading Data from file......");

		int count = 0;
        while (keyboard.hasNext()){
        	String[] record = (keyboard.next()).split(":");
			
        	stmt.setString(1, record[0]);
        	stmt.setString(2, record[1]);
			stmt.executeUpdate();
			count++;
			System.out.println("Inserted: row OK. count: " + count);           
        }

        

	} catch (ClassNotFoundException cnfe) {
		cnfe.printStackTrace();// not good!
		
	} catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}//end main
	}//end JDBCExample