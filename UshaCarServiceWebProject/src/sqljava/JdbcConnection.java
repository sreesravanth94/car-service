package sqljava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 

public class JdbcConnection {
	
	 // JDBC driver name and database URL
	   private String JDBC_DRIVER;  
	   private String DB_URL; 

	   //  Database credentials
	   private String USER;
	   private String PASS;
	   
	   

	public JdbcConnection() {
		// TODO Auto-generated constructor stub
	}

	public void selectDataBase(String JDBC_DRIVER,String DB_URL,String USER,String PASS) {
		
		
		 try{
		      //STEP 2: Register JDBC driver
		      Class.forName(JDBC_DRIVER);
		      Connection conn = null;

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      System.out.println("Created DB Connection....");
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
	
	
	
	}
	
	
	
	

	
	
	         
	      


