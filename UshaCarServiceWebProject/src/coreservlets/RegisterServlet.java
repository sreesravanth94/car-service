package coreservlets;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * Servlet implementation class RegisterServlet
 */
//@WebServlet(description = "RegisterServletDescription", urlPatterns = { "/register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// JDBC driver name and database URL
	     String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	     String DB_URL="jdbc:mysql://localhost/carservice";

	      //  Database credentials
	     String USER = "root";
	     String PASS = "password";
	     
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
        String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String phoneNumber = request.getParameter("phnumber");
		String eMail = request.getParameter("email");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		//-----------------------------------------------------------------
		try
	    {
	      //STEP 1: create a mysql database connection
	      
	      Class.forName(JDBC_DRIVER);
          Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);	     

	      //STEP 2: the mysql insert statement for Person Table
          System.out.println("Creating Insert statement Person Table...");
	      String insert1 = " insert into Person (LastName,FirstName,Email,PhNumber)"
	        + " values (?, ?, ?, ?)";

	      //STEP 3: create the mysql insert preparedstatement
	      
	      PreparedStatement preparedStmt1 = conn.prepareStatement(insert1);
	      preparedStmt1.setString (1, firstName);
	      preparedStmt1.setString (2, lastName);
	      preparedStmt1.setString  (3, eMail);
	      preparedStmt1.setString (4, phoneNumber);

	      //STEP 4: execute the preparedstatement
	      preparedStmt1.execute(); 
	      
	    //STEP 5: Execute a query
	      System.out.println("Creating Select statement.Person Table..");
	      Statement stmt = conn.createStatement();
	      System.out.print("email: " +  eMail);
	      String query = "Select PersonID from Person where Email = eMail ORDER BY PersonID ASC";
	      ResultSet rs1 = stmt.executeQuery(query);
	      //STEP 6: Extract data from result set
	      int  tempid=0;
	      while(rs1.next()){
	      int id = rs1.getInt("PersonID");
	      System.out.print("ID:\n " + id);
	      tempid =id;
	      }
	       rs1.close(); 
	       
	       System.out.print("ID: " + tempid);
	      // Step 7: the mysql insert statement for login Table
	         
	         System.out.println("Creating Insert statement login Table...");
		     String insert2 = " insert into userlogin ( username, password, PersonID)"
		        + " values ( ?, ?, ?)";
		     
		     PreparedStatement preparedStmt2 = conn.prepareStatement(insert2);
		     preparedStmt2.setString (1, userName);
		     preparedStmt2.setString (2, password);
		     preparedStmt2.setInt(3, tempid);
		     
		  //STEP 8: execute the preparedstatement
		      preparedStmt2.execute();

		}
	    catch (Exception uv)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(uv.getMessage());
	    }
	
	
	
		//-----------------------------------------------------------------
		
		
		 String resultUrl = "MakeAppointment.jsp";
		 request.getRequestDispatcher(resultUrl).forward(request, response);
		
	}

}
