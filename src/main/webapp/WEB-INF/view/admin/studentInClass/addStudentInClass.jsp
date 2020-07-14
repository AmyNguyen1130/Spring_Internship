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
		<div class="row = 12">
			<div class="col-sm-7">
			</div>
			<div class="col-sm-5"> 
			</div>
		</div>
	</div>
	<br><br>
	<div class="container-fluid">
			<form class="form-group"
				action="<%=request.getContextPath()%>/admin/saveStudentInClass?classid=<c:out value='${classid}'/>"
				method="POST">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">Email</th>
							<th scope="col">Total assignment</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${userPage}" var="user">
							<tr>
								<td>
									<input type="checkbox" name="checkSelected"
										id="checkbox_${user.getUserid() }"
										value="${user.getUserid()}"
										${studentChecked.contains(user.getUserid()) ? 'checked' : ''}>
								</td>
								<td>${user.getFirstname()}</td>
								<td>${user.getLastname()}</td>
								<td>${user.getEmail()}</td>
								<td>****************</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>	
				<br>
				<button type="submit" id="assign_buton" class="btn btn-default">Save</button>
				<a href="/admin/class"><button type="button" class="btn btn-default">Cancel</button></a>
			</form>
		</div>

</body>
</html>
