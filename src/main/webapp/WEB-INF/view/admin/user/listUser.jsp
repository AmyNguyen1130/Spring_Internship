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
			<div class="row = 12">
				<div class="col-sm-7">
				</div>
				<div class="col-sm-5">
					<div class="row = 12">
						<div class="col-sm-8">
	
						</div>
						<div class="col-sm-4">
							<a href="/admin/user/addUser">
								<button class="btn btn-default">Add New User</button>
							</a>
						</div>
					</div>
				</div>
			</div>
	</div>
	<br><br>
	<div class="container-fluid">
		<div class="row = 12">
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
						<th scope="col">Options</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="i" value="1" />
					<c:forEach items="${userPage.getContent()}" var="user">
						<tr>
							<td>${i}</td>
							<td>${user.getUsername()}</td>
							<td>${user.getFirstname()}</td>
							<td>${user.getLastname()}</td>
							<td>${user.getEmail()}</td>
							<td>${user.getRole().getRolename()}</td>
							<td><a href="/admin/user/editUserEnabled/${user.getUserid()}"
								onclick="return confirm('Are you sure?')"><button class="btn btn-default">${user.isEnabled() == true ? 'Active' : 'Inactive'}</button></a></td>
							<td><a href="/admin/user/editUser/${user.getUserid()}"> 
									<img alt="edit" src="<%=editImageAddress%>" class="optionSize" /></a> 
								<a href="/admin/user/deleteUser/${user.getUserid()}" class="delete-button"> 
									<img alt="delete" src="<%=deleteImageAddress%>" class="optionSize" /></a>
							</td>
						</tr>
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
	<script type="text/javascript">
		$(document).ready(function() {

			$(".delete-button").click(function() {
				if (confirm("Are you sure you want to delete this user?")) {
					return true;
				} else {
					return false;
				}
			});
		});
	</script>
</body>
</html>
