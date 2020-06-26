<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.codeenginestudio.elearning.controller.StudentIntoClassController"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List student</title>

<style>
	img {
		width: 30px;
		height: 30px;
		margin: 4px;
	}
	
	button {
		margin: 20px;
	}
	
	.field {
		width: 50px;
		border: none;
	}
	
	td {
		width: 40px;
	}
</style>
</head>

<body>
	<div style="width: 50%; margin: 5%">
		<h1>Assign students into class</h1>
		<br><br>
		<form class="form-group" action="<%=request.getContextPath()%>/admin/saveTeacherAddToClass?classId=<c:out value='${classId}'/>"
			method="POST" style="width: 50%;">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th scope="col">User Name</th>
						<th scope="col">Status</th>
						<th scope="col">RoleId</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listUser}" var="user">
						<tr>
						<td><input type="checkbox" name="checkSelected" id="checkSelected" value="${user.getUserId()}"></td>
							<td>${user.getUsername()}</td>
							<td>${user.getStatus()}</td>
							<td>${user.getRoleId()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button type="submit" class="btn btn-success">Save</button>

		</form>	
	</div>
</body>
</html>













