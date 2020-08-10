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
	<div class="container-fluid">
			<div class="row">
				<div class="col-sm-7"></div>
				<div class="col-sm-5">
					<div class="row">
						<div class="col-sm-4">
						</div>
						<div class="col-sm-8">
							<ul class="navbar-nav ml-auto ml-md-0" style="position: absolute; right: 20px; color: white;">
								<li class="nav-item dropdown">
									<a class="nav-link dropdown-toggle btn-pink capitalize" href="#" id="userDropdown"
										role="button" data-toggle="dropdown">
										<button class="btn btn-pink"> Add User</button>
									</a>
									<div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
										<a class="dropdown-item" href="/admin/user/addUser?role=3">Add New Student</a>
										<a class="dropdown-item" href="/admin/user/addUser?role=2">Add New Teacher</a>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
	</div>
	<br><br><br>
	<div class="container-fluid">
		<div class="row">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">User Name</th>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Email</th>
						<th scope="col">Role</th>
						<th scope="col">Status</th>
						<th scope="col">Total Assigned</th>
						<th scope="col">Options</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="i" value="1" />
					<c:forEach items="${userPage.getContent()}" var="user">
						<c:if test="${user.getRole().getRoleid() != 1}">
							<tr>
								<td>${i}</td>
								<td>${user.getUsername()}</td>
								<td>${user.getFirstname()}</td>
								<td>${user.getLastname()}</td>
								<td>${user.getEmail()}</td>
								<td>${user.getRole().getRolename()}</td>
								<td>
									<a href="#" onclick="confirmation('/admin/user/editUserEnabled/${user.getUserid()}', 'update')">
										<button class="btn ${user.isEnabled() ? 'btn-active' : 'btn-inactive'}">${user.isEnabled() ? 'Enable' : 'Disable'}</button>
									</a>
								</td>
								<td class="pink-highlight">${user.getTotalAssigned()}</td>
								<td>
									<a href="/admin/user/editUser/${user.getUserid()}"> 
										<img alt="edit" src="<%=editImageAddress%>" class="optionSize"/>
									</a>
									<a href="#" onclick="confirmation('/admin/user/deleteUser/${user.getUserid()}', 'delete')">
										<img alt="delete" src="<%=deleteImageAddress%>" class="optionSize"/>
									</a>
								</td>
							</tr>
						</c:if>
						<c:set var="i" value="${i+1}" />
					</c:forEach>

				</tbody>
			</table>
		<util:pagination count="${userPage.getTotalElements()}"
			totalPages="${userPage.getTotalPages()}"
			url="${pageContext.request.contextPath}/admin/user"
			curpage="${userPage.getNumber()}" />
	</div>
	</div>

</body>
</html>
