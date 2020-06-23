<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value=""/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Log in</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>

<div class="container">

    <form method="POST" action="/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ">
            <div class="col12 m-3">
	            <input name="username" type="text" class="form-control" placeholder="Username"
	                   autofocus="true"/>
			</div>
			<div class="col12 m-3">
            	<input name="password" type="password" class="form-control" placeholder="Password"/>
            </div>
            <div class="col12 m-3">
            	<button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            </div>
        </div>

    </form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script></body>
</html>