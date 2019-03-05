package sqljava;


import java.sql.*;



public class SelectStatement {
	//STEP 1. Import required packages

	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/carservice";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "password";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
	      System.out.println("Creating Select statement.Person Table..");
	      Statement stmt = conn.createStatement();
	      
	      String query = "Select PersonID from Person where Email = 'nixvan@yahoo.com'";
	      System.out.print("test1\n" );
	      ResultSet rs1 = stmt.executeQuery(query);
	      System.out.print("test2 \n" );
	      int tempid =0;
	      //STEP 6: Extract data from result set
	      while(rs1.next()){
	      int id = rs1.getInt("PersonID");
	      System.out.print("ID: " + id);
	      tempid =id;
	      }
	       rs1.close(); 
	       
	       System.out.print("\n tempid: " + tempid);
	   }catch(SQLException se){
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

}
}