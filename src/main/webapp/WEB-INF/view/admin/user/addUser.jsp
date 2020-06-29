<div>
	<div class="card-body">
		<h3>Enter student's informations here</h3>

		<form action="<%=request.getContextPath()%>${url}" method="post" id="addAndEditForm">
			<input type="hidden" name="userid" value="${userInf.getUserid()}" />
			<div class="form-group row">
				<label for="userName" class="col-sm-1 col-form-label">UserName</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="username" value="${userInf.getUsername()}">
					<p id="errUsername"> </p>
				</div>
			</div>

			<div class="form-group row">
				<label for="password" class="col-sm-1 col-form-label">Password</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" name="password">
					<p id="errPassword"> </p>
				</div>
			</div>

			<div class="form-group row">
				<label for="firstName" class="col-sm-1 col-form-label">FirstName</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="firstname"
						value="${userInf.getFirstname()}">
						<p id="errFirstname"> </p>
				</div>
			</div>

			<div class="form-group row">
				<label for="lastName" class="col-sm-1 col-form-label">LastName</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="lastname" value="${userInf.getLastname()}">
					<p id="errLastname"> </p>
				</div>
			</div>

			<div class="form-group row">
				<label for="email" class="col-sm-1 col-form-label">Email</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="email" value="${userInf.getEmail()}">
					<p id="errEmail"> </p>
				</div>
			</div>

			<div class="form-group row">
				<label for="gender" class="col-sm-1 col-form-label">Gender</label>
				<div class="col-sm-4">
					<input type="radio" name="gender" value="Male"
						${userInf.getGender()}  == "Male" : checked ? "" >Male <input
						type="radio" name="gender" value="Female"
						${userInf.getGender()}  == "Female" : checked ? "">Female
				</div>
			</div>

			<div class="form-group row">
				<label for="role" class="col-sm-1 col-form-label">Role</label>
				<div class="col-sm-4">
					<select name ="roleid" class="form-control">
					  <option value="2" ${userInf.getRoleid()}  == 2 : selected ? "" >Teacher</option>
					  <option value="3" ${userInf.getRoleid()}  == 3 : selected ? "">Student</option>
					</select>
				</div>
			</div>

			<input type="hidden" value="true" name="enabled" />
			<button type="submit" class="btn btn-primary">Done</button>
		</form>
	</div>
</div>
 <script>
 $( document ).ready(function() {
	 
		 function isEmail(email) {
			  var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			  return regex.test(email);
			}

		function checkLength(String input, int minLength, int maxLength){
			if(value < minLength || value > maxLength){
					return false;
				}
			return true;
			}
	 
	    $('#addAndEditForm').bind({
	    	'submit': function(){
					if($('username').val().length == "" || !checkLength($('username').val(), 1, 8)){
						$('errUsername').html('Username could not null and must be between 1 to 8');
					return false;
					}
	
					if($('password').val().length == "" || !checkLength($('password').val(), 1, 8)){
						$('errPassword').html('Password could not null and must be between 1 to 8');
					return false;
					}

					if($('firstname').val().length == "" || !checkLength($('firstname').val(), 1, 8)){
						$('errFirstname').html('Firstname could not null and must be between 1 to 8');
					return false;
					}

					if($('lastname').val().length == "" || !checkLength($('lastname').val(), 1, 8)){
						$('errLastname').html('Lastname could not null and must be between 1 to 8');
					return false;
					}

					if($('email').val().length == "" || !isEmail($('email').val())){
						$('errEmail').html('Email could not null and must be formatted');
					return false;
					}

				return true;
	    	}
	});
 </script>