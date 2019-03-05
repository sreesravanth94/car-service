package coreservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Services;

public class ServicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
 
    // TODO Auto-generated constructor stub


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
	
	
    String newAuto = request.getParameter("S1");
	String fallSpecial = request.getParameter("S2");
	String oilChange = request.getParameter("S3");
	String diagnostic= request.getParameter("S4");
	String wheelAlignment = request.getParameter("S5");
	String airCondition = request.getParameter("S5");
	String serviceDate=request.getParameter ("Sdate");
	String serviceTime=request.getParameter ("Stime");
	
//	String resultUrl = "YourAppointments.jsp";
//	request.getRequestDispatcher(resultUrl).forward(request, response);
	
	String[] selectedServices;
	Services S =new Services();
	selectedServices=S.getTitle(newAuto, fallSpecial, oilChange, diagnostic, wheelAlignment, airCondition);
	
	
	out.println("<html>");
	out.println("<head><title>Car Service Appointment</title></head>");
	out.println("<body>");
	
	out.println("<h2>"+"Your Appointments"+"</h2>");
	out.print("<h3>"+ "Service Details"+" </h3>");
	for (int i = 0; i < selectedServices.length; i++)
	{
      

	out.print("<h3>" + selectedServices[i] +","+"</h3>");
	}
	out.println("<h3> Service Date " + serviceDate+"</h3>");
	out.println("<h3> Service  Time " + serviceTime+"</h3>");
	
	out.println("<p>Thank you for working with us.</p>");

	out.println("</body></html>");
	out.close();
    
}}
