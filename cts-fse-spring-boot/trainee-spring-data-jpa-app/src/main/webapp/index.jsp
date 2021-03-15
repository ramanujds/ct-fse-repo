<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<div class="row">
<div class="col-12">
<jsp:include page="nav-bar.jsp"></jsp:include>

<form action="trainees/add" method="post">
		<div class="form-group row">
		
			<label class="col-12 col-lg-2 col-form-label" for="traineeId">Trainee ID : </label> 
			<div class="col-12 col-lg-10">
			<input type="number"
				placeholder="Enter Trainee ID" name="traineeId" class="form-control">
		</div>
		</div>
		<div class="form-group row">
			<label class="col-12 col-lg-2 col-form-label" for="traineeName">Trainee Name : </label> 
			<div class="col-12 col-lg-10">
			<input type="text"
				placeholder="Enter Trainee Name" name="traineeName" class="form-control">
		</div>
		</div>
		<div class="form-group row">
			<label class="col-12 col-lg-2 col-form-label" for="email">Email : </label> 
			<div class="col-12 col-lg-10">
			<input type="email"
				placeholder="Enter Email" name="email" class="form-control">
		</div>
		</div>
		<div class="form-group row">
			<label class="col-12 col-lg-2 col-form-label" for="dob">Date of Birth : </label> 
			<div class="col-12 col-lg-10">
			<input type="date"
				placeholder="Enter Trainee DOB" name="dob" class="form-control">
		</div>
		</div>
		<button type="submit" class="btn btn-primary">Add Trainee</button>
	</form>
</div>
</div>
</div>
	
<!-- 
	<div style="background-color: gray;">
		<form action="searchTrainee" method="get">
			<input type="number" placeholder="Enter Trainee ID" name="traineeId"><br>
			<input type="submit" value="Find Trainee">
		</form>
	</div>

 -->
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script>
</html>