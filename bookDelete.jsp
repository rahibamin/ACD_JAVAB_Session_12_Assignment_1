<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Logger</title>
</head>
<h1>Delete Book</h1>
<body>
	<form action="onlinebookRemove" method="post">
	Book Title: <input type= "text" name= "r_book_title" >
	Book Author: <input type= "text" name= "r_book_author" >
	Book Publisher: <input type= "text" name= "r_book_publisher" >
	Book Publish Year: <input type= "text" name= "r_book_publication_year" >
	Book Price: <input type= "text" name= "r_book_price" >
	<input type= "Submit" value="Delete Book">
	
	
	</form>
</body>
</html>