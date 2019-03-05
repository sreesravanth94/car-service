package sqljava;

import java.sql.*;

public class CarServiceTables {

	// STEP 1. Import required packages

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/CARSERVICE";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "password";

	public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      System.out.println("Creating table in given database...");
	      stmt = conn.createStatement();
	      
	      String sql0 = "CREATE TABLE  Person "
	      		+ "(PersonID int NOT NULL AUTO_INCREMENT,"
	    		+ "LastName varchar(255) NOT NULL,"
	    		+"FirstName varchar(255) NOT NULL,"
	    		+"Email varchar(255) NOT NULL UNIQUE,"
	    		+" PhNumber varchar(255) NOT NULL,"
	    		//+"License varchar(255) NOT NULL UNIQUE,"
	    		//+"Street varchar(355) NOT NULL,"
	    		//+"City varchar(255) NOT NULL,"
	    		//+"State varchar(10) NOT NULL,"
	    		//+"Zip varchar(10) NOT NULL,"
	    		+"PRIMARY KEY (PersonID))" +" AUTO_INCREMENT = 10000";
          stmt.executeUpdate(sql0);
	      System.out.println("Created table Person in given database...");
	      
	      
	      String sql1 = "CREATE TABLE  CarInfo"
	    		  +"(CarID int NOT NULL AUTO_INCREMENT,"
	    		  +"Year YEAR(4) NOT NULL,"
	    		  +"Model varchar(255) NOT NULL,"
	    		  +"VINNUMBER varchar(255) NOT NULL UNIQUE,"
	    		  +"Odometer varchar(255) NOT NULL,"
	    		  +"PersonID int,"
	    		  +"PRIMARY KEY (CarID),"
	    		  +"FOREIGN KEY (PersonID) REFERENCES Person(PersonID) ON DELETE CASCADE)" 
	    		  +" AUTO_INCREMENT = 100";
	      stmt.executeUpdate(sql1);
	      System.out.println("Created table CarInfo in given database...");
	      
	      
	      String sql2 = "CREATE TABLE  CarService"
	    		  +"(ServiceID int NOT NULL AUTO_INCREMENT,"
	    		  + "Service varchar(255) NOT NULL,"
	    		  +"ServicePrice varchar(255) NOT NULL,"
	    		  +"PRIMARY KEY (ServiceID)) AUTO_INCREMENT = 1";
	      
	      stmt.executeUpdate(sql2);
	      System.out.println("Created table CarService in given database...");
	      
	      
	      String sql3 ="CREATE TABLE  userlogin"
	    		  +"(LoginID int NOT NULL AUTO_INCREMENT ,"
	    		  +"username varchar(255) NOT NULL UNIQUE,"
	    		  +"password varchar(255) NOT NULL,"
	    		  +"PersonID int,"
	    		  +"PRIMARY KEY (LoginID),"
	    		  +"FOREIGN KEY (PersonID) REFERENCES Person(PersonID) on Delete CASCADE )"
	    		  +"AUTO_INCREMENT = 10";
	      
	      stmt.executeUpdate(sql3);
	      System.out.println("Created table userlogin in given database...");



	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}// end main
}// end JDBCExample
