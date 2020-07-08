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
	<div class="col-sm-6">
		<a href="/admin/questionOfAssessment/addQuestionOfAssessment">
			<button class="btn btn-primary">Add New Question</button>
		</a>
	</div>

	<div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th scope="col">Numerical Order</th>
					<th scope="col">Question Type </th>
					<th scope="col">Content</th>
					<th scope="col">Options</th>
					<th scope="col">Correct Answer</th>
					<th scope="col">Score</th>
					<th scope="col">Assignment</th>
					<th scope="col">Options</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listQuestionOfAssessment.getContent()}"
					var="question">
					<tr>
						<td>${question.numericalorder}</td> 
						<c:forEach items="${listQuestionType}" var="questionType">
							<c:if test="${questionType.questionTypeId == question.questiontypeid}">
								<td>${questionType.questionTypeName}</td>
							</c:if>
						</c:forEach>
						<td>${question.content}</td>
						<td>${question.options}</td>
						<td>${question.correctanswer}</td>
						<td>${question.score}</td>
						<c:forEach items="${listAssessment}" var="assessment">
							<c:if test="${assessment.assessmentid == question.assessmentid}">
								<td>${assessment.assessmentname}</td>
							</c:if>
						</c:forEach>
						<td><a href="/admin/questionOfAssessment/editQuestionOfAssessment/${question.questionid}"> <img alt="edit"
								src="<%=editImageAddress%>" />
						</a> <a
							href="/admin/questionOfAssessment/deleteQuestionOfAssessment/${question.questionid}"
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
			url="${pageContext.request.contextPath}/admin/questionOfAssignment"
			curpage="${listQuestionOfAssignment.getNumber()}" />
	</div>
</body>
</html>
