<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List student in class</title>

</head>
<body>
<div class="container-fluid">
		<div class="row">
			<div class="col-sm-7">
				<h1>List students into class: ${class.classname}</h1>
			</div>
		</div>
	</div>
	<br>
	<br>
	<div class="container-fluid">
		<div class="row">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th scope="col">User name</th>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Email</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${studentsInClass}" var="student">
							<tr>
								<td>${student.getStudent().getUsername()}</td>
								<td>${student.getStudent().getFirstname()}</td>
								<td>${student.getStudent().getLastname()}</td>
								<td>${student.getStudent().getEmail()}</td>
							</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
