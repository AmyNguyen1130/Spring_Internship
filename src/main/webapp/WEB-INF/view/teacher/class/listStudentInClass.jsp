<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List student in class</title>

</head>
<body>
	<div class="container-fluid mg-top-2">
		<div class="row display-center">
			<h1 class="name-class">&nbsp; ${class.classname}</h1>
		</div>
		<table class="table table-bordered table-hover mg-top-2">
			<thead>
				<tr>
					<th scope="col"><spring:message code="username"/></th>
					<th scope="col"><spring:message code="first-name"/></th>
					<th scope="col"><spring:message code="last-name"/></th>
					<th scope="col"><spring:message code="email"/></th>
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
</body>
</html>
