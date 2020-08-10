<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/fontawesome.min.css">
</head>
<div class="container-fluid center pd-10">
	<div>
		<div>
			<h4>There are no data. Please creating the first user here!</h4>
			<a href="/admin/user/addUser?role=3">
				<button class="btn btn-pink">Add New Student</button>
			</a>
			<a href="/admin/user/addUser?role=2">
				<button class="btn btn-warning">Add New Teacher</button>
			</a>		
		</div>
	</div>
</div>
