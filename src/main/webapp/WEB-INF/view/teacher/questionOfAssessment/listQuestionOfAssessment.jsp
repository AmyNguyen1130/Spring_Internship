<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/fontawesome.min.css">
</head>
<%
	String deleteImageAddress = "https://img.icons8.com/cotton/2x/delete-sign--v2.png";
	String editImageAddress = "https://img.icons8.com/cotton/2x/edit.png";
%>
<body>
	<div class="container-fluid">
		<div class="row = 12">
			<div class="col-sm-7">
				<h5> Class Name: ${class.getClassname() }</h5>
				<h5> Assessment Name: ${assessment.getAssessmentname()}</h5>
				<h5>( ${assessment.getStartdate()} - ${assessment.getExpireddate()})</h5>
			</div>
			<div class="col-sm-5">
				<div class="row = 12">
					<div class="col-sm-8">

					</div>
					<div class="col-sm-4">
						<a href='/teacher/questionOfAssessment/addQuestionOfAssessment/${assessment.assessmentid}'>
							<button class="btn btn-default" type="button">Add new question</button>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br><br>
	<div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th scope="col">Numerical Order</th>
					<th scope="col">Question Type</th>
					<th scope="col">Content</th>
					<th scope="col">Correct Answer</th>
					<th scope="col">Score</th>
					<th scope="col">Assignment</th>
					<th scope="col">Options</th>
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
						<td>${question.getAssessment().getAssessmentname()}</td>
						<td><a
							href="/teacher/questionOfAssessment/editQuestionOfAssessment/${assessment.assessmentid}/${question.questionid}">
								<img alt="edit" src="<%=editImageAddress%>" />
						</a> <a
							href="/teacher/questionOfAssessment/deleteQuestionOfAssessment/${assessment.assessmentid}/${question.questionid}"
							onclick="return confirm('Are you sure?')"> <img alt="delete"
								src="<%=deleteImageAddress%>" />
						</a></td>
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
