<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<div style="margin: 5%">
		<h1>Add Class Form</h1>

		<form class="form-group" action="<%=request.getContextPath()%>/admin/addClass"
			method="POST" style="width: 50%;">
			Class Name: <input class="form-control" type="text" name="classname"> <br>
			Teacher Id: <input class="form-control" type="text" name="teacherid"><br>

			<input class="btn btn-success" type="submit" value="Save"
				style="margin-top: 30px; width: 100%">

		</form>
	</div>

</body>
</html>