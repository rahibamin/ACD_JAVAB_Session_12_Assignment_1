<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Logger</title>
</head>
<h1>Insert Book</h1>
	<form action="onlineBooks" method="post">
	Book Title: <input type= "text" name= "book_title" >
	Book Author: <input type= "text" name= "book_author" >
	Book Publisher: <input type= "text" name= "book_publisher" >
	Book Publish Year: <input type= "text" name= "book_publication_year" >
	Book Price: <input type= "text" name= "book_price" >
	
	<input type= "Submit" value="Submit">
	
	</form>
</body>
</html>