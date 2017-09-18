<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style>
	*{
/* 		font-family: sans-serif; */
	}
	
	#container {
		width: 1000px;
		margin: 0px auto;
	}
	
	span{
		font-weight: normal;
	}
	
	</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile Page</title>
</head>
	<body>
		<div id="container">
		<h1><c:out value="${person.firstName}" /> <c:out value="${person.lastName}"/></h1>
		<h3>License Number: <span><c:out value="${person.license.number}"/></span></h3>
		<h3>State: <span><c:out value="${person.license.state}"/></span></h3>
		<h3>Expiration Date: <span><c:out value="${person.license.expiration_date}"/></span></h3>
		
		
		<a href="/newPerson">Back</a>
		</div>
	</body>
</html>

