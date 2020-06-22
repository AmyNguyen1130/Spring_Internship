<div>
	<div class="card-body">
		<h3>Enter student's informations here</h3>

		<form action="<%=request.getContextPath()%>${url}" method="post">

			<div class="form-group row">
				<label for="userName" class="col-sm-1 col-form-label">User
					Name</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="userName">
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
					<input type="text" class="form-control" name="firstName">
				</div>
			</div>

			<div class="form-group row">
				<label for="lastName" class="col-sm-1 col-form-label">last
					Name</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="lastName">
				</div>
			</div>

			<div class="form-group row">
				<label for="email" class="col-sm-1 col-form-label">Email</label>
				<div class="col-sm-4">
					<input type="email" class="form-control" name="email">
				</div>
			</div>

			<div class="form-group row">
				<label for="gender" class="col-sm-1 col-form-label">Gender</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="gender">
				</div>
			</div>

			<div class="form-group row">
				<label for="gender">Gender</label>
				<div class="col-sm-4">
					<input type="radio" name="gender" value="Male">Male <input
						type="radio" name="gender" value="Female">Female <input
						type="radio" name="gender" value="Other">other
				</div>
			</div>

			<div class="form-group row">
				<label for="role">Role</label>
				<div class="col-sm-4">
					<input type="radio" name="roleId" value="Teacher">Teacher <input
						type="radio" name="roleId" value="Student">Student
				</div>
			</div>

			<button type="submit" class="btn btn-primary">Done</button>
		</form>

	</div>
</div>