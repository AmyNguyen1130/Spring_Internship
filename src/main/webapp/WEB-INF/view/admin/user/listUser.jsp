<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>List student</title>
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
						<td scope="row">${user.getUserid()}</td>
						<td>${user.getLastname()}</td>
						<td>${user.getFirstname()}</td>
						<td>${user.getUsername()}</td>
						<td>${user.getDob()}</td>
						<td>${user.getGender()}</td>
						<td>${user.getStatus()}</td>
						<td>${user.getRoleid()}</td>
						<td><a href="/admin/user/editUser/${user.getUserid()}"> <img
								alt="edit" src="<%=editImageAddress%>" class="optionSize" />
						</a> <a href="/admin/user/deleteUser/${user.getUserid()}"> <img
								alt="delete" src="<%=deleteImageAddress%>" class="optionSize" />
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
