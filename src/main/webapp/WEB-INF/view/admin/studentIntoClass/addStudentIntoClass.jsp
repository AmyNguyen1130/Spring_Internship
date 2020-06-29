<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List student in class</title>

</head>
<body>
	<div style="width: 50%; margin: 5%">
		<h1>Assign students into class</h1>
		<br>
		<br>
		<form class="form-group"
			action="<%=request.getContextPath()%>/admin/saveTeacherAddToClass?classid=<c:out value='${classid}'/>"
			method="POST" style="width: 50%;">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>UserID</th>
						<th scope="col">User Name</th>
						<th scope="col">Status</th>
						<th scope="col">RoleId</th>
					</tr>
				</thead>
				<tbody>

						<c:forEach items="${listUser}" var="user">
						<tr>
							<td><input type="checkbox" name="checkSelected"
								id="checkSelected" value="${user.getUserid()}" ${studentChecked.contains(user.getUserid()) ? 'checked="checked"' : ''}></td>
							<td>${user.getUserid()}</td>
							<td>${user.getUsername()}</td>
							<td>${user.getStatus()}</td>
							<td>${user.getRoleid()}</td>

						</tr>


					</c:forEach>
				</tbody>
			</table>
			<button type="submit" class="btn btn-success">Save</button>

		</form>
	</div>
</body>
</html>
