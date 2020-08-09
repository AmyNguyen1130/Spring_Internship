<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<style>
		p {
			color: red
		}
	</style>

	<div class="container-fluid center">
		<div class="col-sm-3"></div>
		<form action="<%=request.getContextPath()%>${url}" method="post" class="col-sm-6 form-general">
			<h1 class="form-title">Register User</h1>
			<br>
			<input type="hidden" name="userid" value="${userInf.getUserid()}" />

			<div class="form-group row">
				<div class="col-sm-1"></div>
				<label for="userName" class="col-sm-2 col-form-label">UserName</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="username" placeholder="Please enter username here"
						value="${userInf.getUsername()}">
					<div class="error">
						<p id="errUsername">${error.errUsername}</p>
					</div>
				</div>
			</div>

			<div class="form-group row">
				<div class="col-sm-1"></div>
				<label for="password" class="col-sm-2 col-form-label">Password</label>
				<div class="col-sm-8">
					<input type="password" class="form-control" name="password" placeholder="Please enter password here"
						value="${userInf.getPassword()}">
					<div class="error">
						<p id="errPassword">${error.errPassword}</p>
					</div>
				</div>
			</div>

			<div class="form-group row">
				<div class="col-sm-1"></div>
				<label for="firstName" class="col-sm-2 col-form-label">FirstName</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="firstname" placeholder="Please enter firstname here"
						value="${userInf.getFirstname()}">
					<div class="error">
						<p id="errFirstname">${error.errFirstname}</p>
					</div>
				</div>
			</div>

			<div class="form-group row">
				<div class="col-sm-1"></div>
				<label for="lastName" class="col-sm-2 col-form-label">LastName</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="lastname" placeholder="Please enter lastname here"
						value="${userInf.getLastname()}">
					<div class="error">
						<p id="errLastname">${error.errLastname}</p>
					</div>
				</div>
			</div>

			<div class="form-group row">
				<div class="col-sm-1"></div>
				<label for="email" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="email" placeholder="Please enter email here"
						value="${userInf.getEmail()}">
					<div class="error">
						<p id="errEmail">${error.errEmail}</p>
					</div>
				</div>
			</div>

			<div class="form-group row">
				<div class="col-sm-1"></div>
				<label for="gender" class="col-sm-2 col-form-label">Gender</label>
				<div class="col-sm-8 space-evenly">
					<div>
						<input type="radio" name="gender" value="Male" class="checkbox"
						${userInf.getGender() == 'Male' ? 'checked' : "" } checked><span>Male</span>
					</div>
					<div>
						<input type="radio" name="gender" value="Female" class="checkbox"
						${userInf.getGender() == 'Female' ? 'checked' : "" }><span>Female</span>
					</div>
				</div>
			</div>

			<div class="form-group row">
				<div class="col-sm-1"></div>
				<label for="role" class="col-sm-2 col-form-label">Role</label>
				<div class="col-sm-8">
						<c:choose>
							<c:when test="${roleId == null}">
								<select name="role.roleid" class="form-control">
									<c:forEach items="${listRole}" var="role">
										<option value="${role.getRoleid()}"
											${userInf.getRole().getRoleid() == role.getRoleid() ? 'selected' : "" }>
												${role.getRolename()}</option>
									</c:forEach>
								</select>
							</c:when>
							<c:otherwise>
								<c:forEach items="${listRole}" var="role">
									<c:if test="${roleId eq role.getRoleid()}">
										<input type="hidden" name="role.roleid"
											value="${role.getRoleid()}"/>
										<input type="text" class="form-control" value="${role.getRolename()}" disabled="disabled">
									</c:if>
								</c:forEach>
							</c:otherwise>
						</c:choose>
				</div>
			</div>

			<div class="form-group row">
				<input type="hidden"
					value="${url == '/admin/user/saveAddUser' ? 'true' : userInf.isEnabled()}"
					name="enabled" />
			</div>

			<input class="btn btn-pink" type="submit" value="Save">
		
			<a href="/admin/user"><input class="btn btn-warning" type="button" value="Cancel"></a>
		</form>

		<div  class="col-sm-3"></div>
	</div>











