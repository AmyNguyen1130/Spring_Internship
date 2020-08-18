<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/fontawesome.min.css">
</head>
<body>

	<div class="container-fluid mg-top-2">
		<div class="row">
			<div class="col-sm-7">
					<div class="row mg-top-2 display-inline">
					<h4 class="title-class grey"><spring:message code="class"/></h4>
					<h4 class="name-class"> ${class.getClassname()} ${classNull}</h4>
				</div>
				<div class="row display-inline">
					<h4 class="title-class grey"><spring:message code="assessment"/></h4>
					<h4 class="name-class"> ${assessment.getAssessmentname()}</h4>
				</div>
				<div class="row display-inline">
					<h6 class="title-class grey">( ${assessment.getStartdate()} - ${assessment.getExpireddate()})</h6>
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
					<th scope="col"><spring:message code="numerical-order"/></th>
					<th scope="col"><spring:message code="question-type"/></th>
					<th scope="col"><spring:message code="content"/></th>
					<th scope="col"><spring:message code="correct-answer"/></th>
					<th scope="col"><spring:message code="score"/></th>
					<c:if test="${assessment.getStatus()}">
						<th scope="col"><spring:message code="options"/></th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listQuestionOfAssessment}"
					var="question">
					<tr>
						<td>${question.getNumericalorder()}</td>
						<td>${question.getQuestionType().getQuestionTypeName()}</td>
						<td>${question.content}</td>
						<td>${question.correctanswer}</td>
						<td>${question.score}</td>
						<td>
							<a href="/teacher/questionOfAssessment/editQuestionOfAssessment/${assessment.assessmentid}/${question.questionid}">
									<img alt="edit" src="<c:url value="../../images/edit.png"/>" /> 
							</a> 
							<a href="#" onclick="confirmation('/teacher/questionOfAssessment/deleteQuestionOfAssessment/${assessment.assessmentid}/${question.questionid}', 'delete')"> 
								<img alt="delete" src="<c:url value="../../images/delete.png"/>" />
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<util:pagination
			count="${listQuestionOfAssignment.getTotalElements()}"
			totalPages="${listQuestionOfAssignment.getTotalPages()}"
			url="${pageContext.request.contextPath}/teacher/questionOfAssignment"
			curpage="${listQuestionOfAssignment.getNumber()}" />
	</div>

</body>
</html>

