<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/fontawesome.min.css">
</head>
<%
	String deleteImageAddress = "https://img.icons8.com/cotton/2x/delete-sign--v2.png";
	String editImageAddress = "https://img.icons8.com/cotton/2x/edit.png";
%>
<body>
	<div>
		<div class="form-group row">
			<div class="col-sm-1">
				<a href="/admin/user/addUser">
					<button class="btn btn-primary">Add User</button>
				</a>
			</div>
		</div>
		<br><br>
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
						<td>${user.getRole().getRolename()}</td>
						<td><a href="/admin/user/editUserEnabled/${user.getUserid()}"
							onclick="return confirm('Are you sure?')"><button>${user.isEnabled() == true ? 'Active' : 'Deactivated'}</button></a></td>
						<td><a href="/admin/user/editUser/${user.getUserid()}"> <img
								alt="edit" src="<%=editImageAddress%>" class="optionSize" />
						</a> <a href="/admin/user/deleteUser/${user.getUserid()}"> <img
								alt="delete" src="<%=deleteImageAddress%>" class="optionSize" />
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<util:pagination count="${userPage.getTotalElements()}"
			totalPages="${userPage.getTotalPages()}"
			url="${pageContext.request.contextPath}/admin/user"
			curpage="${userPage.getNumber()}" />
	</div>
</body>
</html>
