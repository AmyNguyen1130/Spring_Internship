<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List student</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<style>
img {
	width: 30px;
	height: 30px;
	margin: 4px;
}

button {
	margin: 20px;
}
.field{
width: 50px;
}
td{
width: 40px;
}
</style>
<body>
	<%
		String deleteImageAddress = "https://img.icons8.com/cotton/2x/delete-sign--v2.png";
	String editImageAddress = "https://img.icons8.com/cotton/2x/edit.png";
	%>
	<div >
		<a href="/addUser">
			<button class="btn btn-primary">Add User</button>
		</a>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th scope="col">UserId</th>
					<th scope="col">Last Name</th>
					<th scope="col">First Name</th>
					<th scope="col">UserName</th>
					<th scope="col">Dob</th>
					<th scope="col">Gender</th>
					<th scope="col">Status</th>
					<th scope="col">RoleId</th>
					<th scope="col">Options</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listUser}" var="user">
					<tr>
						<td scope="row"><input class="field" name = "userId" value="${user.getUserId()}"/></td>
						<td><input class="field" name = "userId" value="${user.getLastName()}"/></td>
						<td><input class="field" name = "userId" value="${user.getFirstName()}"/></td>
						<td><input class="field" name = "userId" value="${user.getUserName()}"/></td>
						<td><input class="field" name = "userId" value="${user.getDob()}"/></td>
						<td><input class="field" name = "userId" value="${user.getGender()}"/></td>
						<td><input class="field" name = "userId" value="${user.getStatus()}"/></td>
						<td><input class="field" name = "userId" value="${user.getRoleId()}"/></td>

						<td><a href="/editUser/${user.getUserId()}"> <img
								alt="edit" src="<%=editImageAddress%>" class="optionSize" />
						</a> <a href="/deleteUser/${user.getUserId()}"> <img
								alt="delete" src="<%=deleteImageAddress%>" class="optionSize" />
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>