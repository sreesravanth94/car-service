

import java.sql.*;
//import java.util.Calendar;

/**
 * A Java MySQL PreparedStatement INSERT example.
 * Demonstrates the use of a SQL INSERT statement against a
 * MySQL database, called from a Java program, using a
 * Java PreparedStatement.
 * 
 * 
 */
public class InsertIntoDatabase
{

  public static void main(String[] args)
  {
    try
    {
      // create a mysql database connection
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/carservice";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "password");
    
      // create a sql date object so we can use it in our INSERT statement
      //Calendar calendar = Calendar.getInstance();
     // java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

      // the mysql insert statement
      String query = " insert into Person (LastName,FirstName,Email,PhNumber)"
        + " values (?, ?, ?, ?)";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setString (1, "Barney");
      preparedStmt.setString (2, "Rubble");
      preparedStmt.setString  (3, "v@yahoo.com");
      preparedStmt.setString (4, "6174294857");
      

      // execute the preparedstatement
      preparedStmt.execute();
      
      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }
}
