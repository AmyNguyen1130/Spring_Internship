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
			<form class="form-inline col-sm-7" action="/admin/user/search" method="get">
				<input class="form-control mr-3 " type="text" placeholder="Search" name="search">
				<button type="submit" class="btn btn-large btn-primary" > Search</button>
			</form>

			<form class="form-inline col-sm-4"
				action="/admin/user/getUserByEnabledAndRoleid" method="get">
				<div class="col-sm-5 form-inline">
					<label class="col-sm-4 col-form-label">Status</label> <select
						name="enabled" class="form-control">
						<option value="null" ${enabled == "all" ? 'selected' : ''}>All</option>
						<option value="true" ${enabled == true ? 'selected' : ''}>Activated</option>
						<option value="false" ${enabled == false ? 'selected' : ''}>Deactivated</option>
					</select>
				</div>
				<div class="col-sm-5 form-inline">
					<label class="col-sm-4 col-form-label">Role</label> <select
						name="roleid" class="form-control">
						<option value="0" ${roleid == 0 ? 'selected' : ''}>All</option>
						<c:forEach items="${listRole}" var="role">
							<option value="${role.getRoleid()}"
								${roleid == role.getRoleid() ? 'selected' : ''}>${role.getRolename()}</option>
						</c:forEach>
					</select>
				</div>
				<button type="submit" class="btn btn-large">Filter</button>
			</form>

			<div class="col-sm-1">
				<a href="/admin/user/addUser">
					<button class="btn btn-primary">Add User</button>
				</a>
			</div>
		</div>

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
						<c:forEach items="${listRole}" var="role">
							<c:if test="${role.roleid == user.getRoleid()}">
								<td>${role.getRolename()}</td>
							</c:if>
						</c:forEach>
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
