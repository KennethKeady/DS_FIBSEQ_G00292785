<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fibonacci Sequence</title>
</head>
<body>
	<form action="FibonacciServlet" method="get">			
		Please enter a number to calculate fibonacci up to: <br>
		//<input type="hidden" />
		<input type="text" name="length" size="60px">
		<input type="submit" value="submit">						
	</form>	
</body>
</html>