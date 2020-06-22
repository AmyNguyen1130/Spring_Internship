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

<body>

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
	<%
		String deleteImageAddress = "https://img.icons8.com/cotton/2x/delete-sign--v2.png";
	String editImageAddress = "https://img.icons8.com/cotton/2x/edit.png";
	%>
	<div>
		<a href="/admin/user/addUser">
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
						<td scope="row"><input class="field ${user.getUserId()}"
							name="userId" id="${user.getUserId()}" disabled
							value="${user.getUserId()}" /></td>

						<td><input class="field" name="lastName"
							id="${user.getUserId()}" disabled value="${user.getLastName()}" /></td>

						<td><input class="field" name="firstName"
							id="${user.getUserId()}" disabled value="${user.getFirstName()}" /></td>

						<td><input class="field" name="userName"
							id="${user.getUserId()}" disabled value="${user.getUserName()}" /></td>

						<td><input class="field" name="dob" id="${user.getUserId()}"
							disabled value="${user.getDob()}" /></td>

						<td><input class="field" name="gender"
							id="${user.getUserId()}" disabled value="${user.getGender()}" /></td>

						<td><input class="field" name="status"
							id="${user.getUserId()}" disabled value="${user.getStatus()}" /></td>

						<td><input class="field" name="roleId"
							id="${user.getUserId()}" enable value="${user.getRoleId()}" /></td>

						<td><a href="#"> <img alt="edit"
								src="<%=editImageAddress%>" class="optionSize"
								onClick="enableField('${user.getUserId()}')" />
						</a> <a href="/editUser/${user.getUserId()}"> <img alt="edit"
								src="<%=editImageAddress%>" class="optionSize" />
						</a> <a href="/admin/user/deleteUser/${user.getUserId()}"> <img
								alt="delete" src="<%=deleteImageAddress%>" class="optionSize" />
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script type="text/javascript">
		function enableField(idUser) {
			document.getElementsByClassName(idUser).removeAttribute("disabled");
		}
	</script>

</body>
</html>