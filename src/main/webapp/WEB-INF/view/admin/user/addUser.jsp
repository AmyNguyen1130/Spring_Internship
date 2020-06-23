<div>
	<div class="card-body">
		<h3>Enter student's informations here</h3>

		<form action="<%=request.getContextPath()%>${url}" method="post">
			<input type="hidden" name="userId" value="${userInf.getUserId()}" />
			<div class="form-group row">
				<label for="userName" class="col-sm-1 col-form-label">User
					Name</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="userName"
						value="${userInf.getUserName()}">
				</div>
			</div>

			<div class="form-group row">
				<label for="password" class="col-sm-1 col-form-label">Password</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" name="password">
				</div>
			</div>

			<div class="form-group row">
				<label for="firstName" class="col-sm-1 col-form-label">First
					Name</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="firstName"
						value="${userInf.getFirstName()}">
				</div>
			</div>

			<div class="form-group row">
				<label for="lastName" class="col-sm-1 col-form-label">last
					Name</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="lastName"
						value="${userInf.getLastName()}">
				</div>
			</div>

			<div class="form-group row">
				<label for="email" class="col-sm-1 col-form-label">Email</label>
				<div class="col-sm-4">
					<input type="email" class="form-control" name="email"
						value="${userInf.getEmail()}">
				</div>
			</div>

			<div class="form-group row">
				<label for="dob" class="col-sm-1 col-form-label">Dob</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="dob"
						value="${userInf.getDob()}">
				</div>
			</div>

			<div class="form-group row">
				<label for="gender">Gender</label>
				<div class="col-sm-4">
					<input type="radio" name="gender" value="Male"
						${userInf.getGender()}  == "Male" :checked ? "" >Male <input
						type="radio" name="gender" value="Female"
						${userInf.getGender()}  == "Female" :checked ? "">Female
					<input type="radio" name="gender" value="Other"
						${userInf.getGender()} == "Other" :checked ? "">other
				</div>
			</div>

			<div class="form-group row">
				<label for="role">Role</label>
				<div class="col-sm-4">
					<input type="radio" name="roleId" value="1"
						${userInf.getGender()}  == 1 :checked ? "">Teacher <input
						type="radio" name="roleId" value="2"
						${userInf.getGender()}  == 2 :checked ? "">Student
				</div>
			</div>

			<input type="hidden" value="actived" name="status" />

			<button type="submit" class="btn btn-primary">Done</button>
		</form>

	</div>
</div>