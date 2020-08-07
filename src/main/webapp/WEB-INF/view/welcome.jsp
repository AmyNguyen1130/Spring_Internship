<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title><spring:message code="elearning-math-for-kid"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<style>
	.headerWelcome {
		overflow: hidden;
		height: 100px;
		text-align: center;
		font-weight: bold;
		font-size: 150px;
		font-size: 75px;
	}
	
	.welcomeImg {
		width: 66%;
		background-position: center;
		background-size: cover;
		position: relative;
		margin-left: 17%;
	}
	
	#bt-continue {
		display: inline-block;
		margin-left: 42%;
		margin-top: 16%;
		font-size: 27px;
	}
	</style>
</head>
<body>
	<div class="container">
		<div class="headerWelcome">WELCOME</div>
		<div class="img">
			<img src="<c:url value="/images/welcome.jpg"/>"
				class="welcomeImg">
		</div>

		<form method="get" action="/login">
			<button id="bt-continue" type="submit" class="btn btn-dark">Continue
				to login</button>
		</form>

	</div>
</body>
</html>