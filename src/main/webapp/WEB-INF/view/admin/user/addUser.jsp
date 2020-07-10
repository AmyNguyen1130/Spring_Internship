<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
p {
	color: red
}
</style>
<div>
	<div class="card-body">
		<h3>Enter student's informations here</h3>

		<form action="<%=request.getContextPath()%>${url}" method="post">
			<input type="hidden" name="userid" value="${userInf.getUserid()}" />

			<div class="form-group row">
				<label for="userName" class="col-sm-1 col-form-label">UserName</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="username"
						value="${userInf.getUsername()}">
					<p id="errUsername">${error.errUsername}</p>
				</div>
			</div>

			<div class="form-group row">
				<label for="password" class="col-sm-1 col-form-label">Password</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" name="password"
						value="${userInf.getPassword()}">
					<p id="errPassword">${error.errPassword}</p>
				</div>
			</div>

			<div class="form-group row">
				<label for="firstName" class="col-sm-1 col-form-label">FirstName</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="firstname"
						value="${userInf.getFirstname()}">
					<p id="errFirstname">${error.errFirstname}</p>
				</div>
			</div>

			<div class="form-group row">
				<label for="lastName" class="col-sm-1 col-form-label">LastName</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="lastname"
						value="${userInf.getLastname()}">
					<p id="errLastname">${error.errLastname}</p>
				</div>
			</div>

			<div class="form-group row">
				<label for="email" class="col-sm-1 col-form-label">Email</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="email"
						value="${userInf.getEmail()}">
					<p id="errEmail">${error.errEmail}</p>
				</div>
			</div>

			<div class="form-group row">
				<label for="gender" class="col-sm-1 col-form-label">Gender</label>
				<div class="col-sm-4">
					<input type="radio" name="gender" value="Male"
						${userInf.getGender()  == 'Male' ? 'checked' : "" } checked>Male
					<input type="radio" name="gender" value="Female"
						${userInf.getGender()  == 'Female' ? 'checked' : "" }>Female
				</div>
			</div>

			<div class="form-group row">
				<label for="role" class="col-sm-1 col-form-label">Role</label>
				<div class="col-sm-4">
					<select name="role.roleid" class="form-control">
						<c:forEach items="${listRole}" var="role">
							<option value="${role.getRoleid()}"
								${userInf.getRole().getRoleid() == role.getRoleid() ? 'selected' : "" }>
								${role.getRolename()}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<input type="hidden" value="${url == '/admin/user/saveAddUser' ? 'true' : userInf.isEnabled()}" name="enabled" />
				<button type="submit" class="btn btn-primary">Save</button>
				<a href="/admin/user">
					<button type="button" class="btn btn-danger">Cancel</button>
				</a>
			</div>
		</form>
	</div>
</div>
