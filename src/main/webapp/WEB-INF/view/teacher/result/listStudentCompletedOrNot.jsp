<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="list-users-finished-assignment"/></title>
</head>
<body>
	<div class="container-fluid">
			<div class="row mg-top-2 display-inline">
					<h4 class="title-class grey"><spring:message code="class"/></h4>
					<h4 class="name-class"> ${class.getClassname()}</h4>
				</div>
				<div class="row display-inline">
					<h4 class="title-class grey"><spring:message code="assessment"/></h4>
					<h4 class="name-class"> ${assessment.getAssessmentname()}</h4>
				</div>
				<div class="row display-inline">
					<h6 class="title-class grey">( ${assessment.getStartdate()} - ${assessment.getExpireddate()})</h6>
				</div>
	</div>
	<br><br>
	<div class="container-fluid">
		<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th scope="col"><spring:message code=".NO"/></th>
				<th scope="col"><spring:message code="first-name"/></th>
				<th scope="col"><spring:message code="last-name"/></th>
				<th scope="col"><spring:message code="email"/></th>
				<th scope="col"><spring:message code="gender"/></th>
				<th scope="col"><spring:message code="total-score"/></th>
				<th scope="col"><spring:message code="options"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listStudentInClass}" var="studentInClass" varStatus="num">
				<tr>
					<td>${num.index + 1}</td>
					<td>${studentInClass.student.firstname}</td>
					<td>${studentInClass.student.lastname}</td>
					<td>${studentInClass.student.email}</td>
					<td>${studentInClass.student.gender}</td>
					<td>${studentInClass.score} / ${assessment.totalscore}</td>
					<td>
						<c:choose>
							<c:when test="${listIdOfStudent.contains(studentInClass.student.userid)}">
								<a href="/teacher/viewResultOfStudent/${assessment.assessmentid}/${studentInClass.student.userid}">
									<button class="btn btn-pink"><spring:message code="view-detail"/></button>
								</a>
							</c:when>
							<c:otherwise>
								<p><spring:message code="haven't-done-the-assignment-yet"/></p>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
	</div>
</body>
</html>