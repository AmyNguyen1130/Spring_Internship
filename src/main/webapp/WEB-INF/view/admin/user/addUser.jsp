<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<div class="card-body">
		<h3>Enter student's informations here</h3>

		<form action="<%=request.getContextPath()%>${url}" method="post">
			<input type="hidden" name="userid" value="${userInf.getUserid()}" />
			<div class="form-group row">
				<label for="userName" class="col-sm-1 col-form-label">UserName</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="username" value="${userInf.getUsername()}">
					<p id="errUsername"> ${error.getErrUsername()}</p>
				</div>
			</div>

			<div class="form-group row">
				<label for="password" class="col-sm-1 col-form-label">Password</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" name="password">
					<p id="errPassword"> ${error.getErrPassword()} </p>
				</div>
			</div>

			<div class="form-group row">
				<label for="firstName" class="col-sm-1 col-form-label">FirstName</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="firstname"
						value="${userInf.getFirstname()}">
						<p id="errFirstname"> ${error.getErrFirstname()} </p>
				</div>
			</div>

			<div class="form-group row">
				<label for="lastName" class="col-sm-1 col-form-label">LastName</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="lastname" value="${userInf.getLastname()}">
					<p id="errLastname"> ${error.getErrLastname()} </p>
				</div>
			</div>

			<div class="form-group row">
				<label for="email" class="col-sm-1 col-form-label">Email</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="email" value="${userInf.getEmail()}">
					<p id="errEmail"> ${error.getErrEmail()} </p>
				</div>
			</div>

			<div class="form-group row">
				<label for="gender" class="col-sm-1 col-form-label">Gender</label>
				<div class="col-sm-4">
					<input type="radio" name="gender" value="Male"
						${userInf.getGender()}  == "Male" ? checked : "" >Male <input
						type="radio" name="gender" value="Female"
						${userInf.getGender()}  == "Female" ? checked : "">Female
				</div>
			</div>

			<div class="form-group row">
				<label for="role" class="col-sm-1 col-form-label">Role</label>
				<div class="col-sm-4">
					<select name ="roleid" class="form-control">
					<c:forEach items="${listRole}" var="role">
					  	<option value="${role.getRoleid()}" ${userInf.getRoleid()}  == ${role.getRoleid()}  ? selected : "" > ${role.getRolename()}</option>
					  </c:forEach>
					</select>
				</div>
			</div>

			<input type="hidden" value="true" name="enabled" />
			<button type="submit" class="btn btn-primary">Done</button>
		</form>
	</div>
</div>
 