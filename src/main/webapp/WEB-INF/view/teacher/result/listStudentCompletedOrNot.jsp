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
	<div class="container-fluid mg-top-2">
		<div class="row">
			<div class="col-sm-7">
					<div class="row mt-2">
					<h4 class="pl-3"><spring:message code="class"/></h4>
					<h4 class="name-class">&nbsp; ${class.getClassname()}</h4>
				</div>
				<div class="row">
					<h4 class="pl-3"><spring:message code="assessment"/></h4>
					<h4 class="name-class">&nbsp; ${assessment.getAssessmentname()}</h4>
				</div>
				<div class="row">
					<h6 class="pl-3">
						<spring:message code="start-date-x" arguments="${assessment.getStartdate()}" htmlEscape="false" />
					</h6>
				</div>
				<div class="row">
					<h6 class="pl-3">
						<spring:message code="expired-date-x" arguments="${assessment.getExpireddate()}" htmlEscape="false" />
					</h6>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="row">
					<div class="col-sm-8"></div>
					<div class="col-sm-4 justify-end">
						<a href='/teacher/questionOfAssessment/addQuestionOfAssessment/${assessment.assessmentid}'>
							<button class="btn btn-pink" type="button"><spring:message code="add-new-question"/></button>
						</a>		
						<a href='/teacher/assessment/preview/${assessment.assessmentid}' class="preview">
							<button class="btn btn-warning" type="button"><spring:message code="preview"/></button>
						</a>
					</div>
				</div>
			</div>
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