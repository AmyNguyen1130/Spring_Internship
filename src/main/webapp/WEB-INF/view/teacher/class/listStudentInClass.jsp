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
	<div class="container-fluid row">
		<div class="mg-top-2 display-inline">
			<h4 class="title-class grey"><spring:message code="class"/></h4>
			<h4 class="name-class"> ${class.classname}</h4>
		</div>
	</div>
	<br>
	<br>
	<div class="container-fluid">
		<table class="table table-bordered table-hover">
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
