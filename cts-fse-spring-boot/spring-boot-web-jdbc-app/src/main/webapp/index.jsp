<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addTrainee" method="post">
<input type="number" placeholder="Enter Trainee ID" name="traineeId"><br>
<input type="text" placeholder="Enter Trainee Name" name="traineeName"><br>
<input type="email" placeholder="Enter Email" name="email"><br>
<input type="date" placeholder="Enter Trainee DOB" name="dob"><br>
<input type="submit" value="Add Trainee">

</form>

<div style="background-color: gray;">
<form action="searchTrainee" method="get">
<input type="number" placeholder="Enter Trainee ID" name="traineeId"><br>
<input type="submit" value="Find Trainee">
</form>
</div>

</body>
</html>