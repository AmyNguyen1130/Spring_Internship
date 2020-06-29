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
		<div class="form-group row">
				<div class="col-sm-4">
					<select name ="roleid" class="form-control">
					  <option value="2" ${userInf.getRoleid()}  == 2 : selected ? "" >Teacher</option>
					  <option value="3" ${userInf.getRoleid()}  == 3 : selected ? "">Student</option>
					</select>
				</div>
				
 				<div class="col-sm-4">
					<select name ="roleid" class="form-control">
					  <c:forEach items="${listRole}" var="role">
					  	<option value="${role.getRoleid()}"> ${role.getRolename()}</option>
					  </c:forEach>
					</select>
				</div>
			</div>
		
		
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Email</th>
					<th scope="col">Role</th>
					<th scope="col">Status</th>
					<th scope="col">Options</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listUser}" var="user">
					<tr>
						<td>${user.getFirstname()}</td>
						<td>${user.getLastname()}</td>
						<td>${user.getEmail()}</td>
						<td>${listRole.get(user.getRoleid() - 1).getRolename()}</td>
						<td><a href="/admin/user/editUserEnabled/${user.getUserid()}"><button>${user.isEnabled() == true ? 'Active' : 'Deactivated'}</button></a></td>
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
