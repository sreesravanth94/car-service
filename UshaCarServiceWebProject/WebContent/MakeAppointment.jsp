<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Oreos Car wash</title>
<%String firstName = request.getParameter("firstname");
String lastName = request.getParameter("lastname"); %>
<style>
.container {
	width: 80%;
	height: 80%;
	border: 1px solid gray;
}

header {
	padding: 1em;
	color: Blue;
	background-color: #a39f9f;
	clear: left;
	text-align: center;
}

#bar {
	float: left;
	padding-left: 75px;
}

ol li {
	display: inline-block;
	font-size: 12px;
	font-family: arial;
	vertical-align: top;
	margin-top: 0px;
}

a {
	text-decoration: none;
	color: black;
	padding: 18px 15px;
	display: block;
}

ol li:hover {
	background: #00b7ff;
	pointer: cursor;
}

.nav3 {
	background-color: #dcf1f2;
	padding-bottom: 1em;
	padding-left: 1em;
	padding-top: 1em;
	border: 1px solid gray;
	"
}
</style>
</head>

<body>

	<div class="container">

		<header>
			<h1>
				<img src="Oreo.png" alt="Oreo's Car Wash">
			</h1>

		</header>

		<div class="nav3">Please Make a Selection.</div>
		<br>
		<div id="bar">
			<ol style="margin-top: 0px;">
				<li><a href="Register.html">Account Signup</a></li>
				<li><a href="MakeAppointment.jsp">MakeAppointment</a></li>
				<li><a href="YourAppointments.html">YourAppointments</a></li>

			</ol>
		</div>
		<br> <br> <br>

		<div class="nav3">
			<div id="nav">
			Firstname: <span><%=firstName%> </span>
            Lastname: <span> <%=lastName%>  </span>
				<form method="post" action="services">
					Please select a service
					<br>
					<br> <input type="radio" name="S1"> NEW! Auto Detailing!
					<br> <input type="radio" name="S2"> FallSpecial
					<br> <input type="radio" name="S3"> OilChange/ 6K Service(1 Hour)
					<br> <input type="radio" name="S4">Diagnostic
					<br> <input type="radio" name="S5"> 4-WHEELALIGNMENT
					<br> <input type="radio" name="S6"> AirConditioning
					<br>
				
				<br>
				<br>
<!-- 				<form action="YourAppointments.html"> -->
					Service Time and Date <input type="date" name="Sdate"> <input
						type="time" name="Stime"> <input type="submit"
						value="Submit">
				</form>
<!-- 				</form> -->
			</div>

		</div>
	</div>
</body>
</html>