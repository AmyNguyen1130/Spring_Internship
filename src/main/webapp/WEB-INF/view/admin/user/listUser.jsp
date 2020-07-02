<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List student</title>
</head>

<body>

	<%
		String deleteImageAddress = "https://img.icons8.com/cotton/2x/delete-sign--v2.png";
		String editImageAddress = "https://img.icons8.com/cotton/2x/edit.png";
	%>
	<div>
		<a href="/admin/user/addUser">
			<button class="btn btn-primary">Add User</button>
		</a>
		<form action="/admin/user/getUserByEnabledAndRoleid" method="get">
		<div class="form-group row"">

			<div class="col-sm-4">
				<select name="enabled" class="form-control">
				<option value="null" ${enabled == "all" ? 'selected' : ''}>All</option>
				<option value="true" ${enabled == true ? 'selected' : ''}>Activated</option>
				<option value="false" ${enabled == false ? 'selected' : ''}>Deactivated</option>

				</select>
			</div>
			<div class="col-sm-4">
				<select name="roleid" class="form-control">
					<option value="0" ${roleid == 0 ? 'selected' : ''}>All</option>
					<c:forEach items="${listRole}" var="role">
						<option value="${role.getRoleid()}" ${roleid == role.getRoleid() ? 'selected' : ''}>${role.getRolename()}</option>
					</c:forEach>

				</select>
			</div>
			<button type="submit" class="btn btn-large">Search</button>

		</div>
	</form>
		
		
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th scope="col">Username</th>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Email</th>
					<th scope="col">Role</th>
					<th scope="col">Status</th>
					<th scope="col">Options</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userPage.getContent()}" var="user">
					<tr>
						<td>${user.getUsername()}</td>
						<td>${user.getFirstname()}</td>
						<td>${user.getLastname()}</td>
						<td>${user.getEmail()}</td>
						<td>${listRole.get(user.getRoleid() - 1).getRolename()}</td>
						<td><a href="/admin/user/editUserEnabled/${user.getUserid()}" onclick="return confirm('Are you sure?')"><button>${user.isEnabled() == true ? 'Active' : 'Deactivated'}</button></a></td>
						<td><a href="/admin/user/editUser/${user.getUserid()}"> <img
								alt="edit" src="<%=editImageAddress%>" class="optionSize" />
						</a> <a href="/admin/user/deleteUser/${user.getUserid()}"> <img
								alt="delete" src="<%=deleteImageAddress%>" class="optionSize" />
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<util:pagination
			count="${userPage.getTotalElements()}"
			totalPages="${userPage.getTotalPages()}" 
			url="${pageContext.request.contextPath}/admin/user"
			curpage="${userPage.getNumber()}" />
	</div>
</body>
</html>
