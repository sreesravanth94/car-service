<%@ page language="java" import="datamodel.Services" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Oreos Car wash</title>
<style>
.container {
    width: 80%;
    height: 80%;
    border: 1px solid gray;}

header {
    padding: 1em;
    color: Blue;
    background-color: #a39f9f ;
    clear: left;
    text-align: center;
	}
#bar{float:left;
					padding-left:75px;}
			ol li{display:inline-block;
                font-size: 12px;
                font-family:arial;
                vertical-align: top;margin-top:0px;}
                a{text-decoration:none;
                	color:black;
                	padding:18px 15px;
                	display:block;}
			ol li:hover{background: #00b7ff;
				pointer:cursor;}	


.nav3 {
	background-color: #dcf1f2 ;
	
	padding-bottom :1em;
	 padding-left: 1em;
	 padding-top:1em;
	border:1px solid gray;"}

</style>
</head>

<body>

<div class="container">

<header>
   <h1><img src="Oreo.png" alt="Oreo's Car Wash"> </h1>
   
</header><br>


<div id="bar">
				<ol style="margin-top:0px;">
					<li><a href="Register.html">Account Signup</a></li>
					<li><a href="MakeAppointment.jsp">Make Appointment</a></li>
					<li><a href="YourAppointments.jsp">Your Appointments</a></li>
					
				</ol>
			</div><br>
			<br>
			<br>
		
<div class="nav3">
<div id="nav">
<%String firstName = request.getParameter("firstname");
String lastName = request.getParameter("lastname"); %>
</div>
<%out.println(" You Have the following UpComing Appointments ");%>
<%String[] selectedServices;%>
	<% Services S =new Services();%>
	 <selectedServices=S.getTitle(newAuto, fallSpecial, oilChange, diagnostic, wheelAlignment, airCondition); %>
	for (int i = 0; i < selectedServices.length; i++)
	{
        System.out.print( selectedServices[i] + ", ");
	}
	
</div>
</div>
</body>
</html>