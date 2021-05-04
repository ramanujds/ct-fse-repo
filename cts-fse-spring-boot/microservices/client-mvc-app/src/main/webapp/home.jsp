<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Token - ${token}
<form action="get-food-info" method="get">
<input type="number" name="item-id" placeholder="Item ID">
<input type="text" name="coupon-code" placeholder="Coupon Code">
<input type="submit" value="Get Food Details"> 
</form>
</body>
</html>