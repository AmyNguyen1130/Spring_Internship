<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div class"parents" style="margin: 5%">
	<h1>List Class</h1>
	<a href='addClass'><button class="btn btn-success" type=\"button\">Add class</button></a>

	</br>
	</br>
	<table class="table table-bordered" id="table" style="width: 50%">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Class Name</th>
				<th scope="col">Teacher ID</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>

				<c:set var="i" value="1" />
				<c:forEach items="${data}" var="class">
			       <tr>
				       <td>${i}</td>
				       <td>${class.className}</td>
				       <td>${class.teacherId}</td>
				       <td><a href="editClass?id=<c:out value='${class.classId}' />">Edit</a> &emsp;
					       <a href="deleteClass?id=<c:out value='${class.classId}' />">Delete</a></td>

				   </tr>
				   <c:set var="i" value="${i+1}" />
		     	</c:forEach>

		</tbody>
	</table>
</body>
</html>