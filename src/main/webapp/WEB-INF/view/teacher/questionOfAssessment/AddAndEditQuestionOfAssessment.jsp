<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
p {
	color: red
}
</style>

<div>
	<div class="card-body">
		<h3>Enter assessment's informations here</h3>

		<form action="<%=request.getContextPath()%>${url}" method="post">
			<input type="hidden" name="questionid" value="${questionInf.questionid}" />

			<div class="form-group row">
				<label for="numericalorder" class="col-sm-1 col-form-label">Numerical Order</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="numericalorder"
						value="${questionInf.numericalorder}">
					<p id="errNumericalorder"></p>
				</div>
			</div>

			<div class="form-group row">
				<label for="questiontypeid" class="col-sm-1 col-form-label">Question Type ID</label>
				<div class="col-sm-4">
					<select name="questiontypeid" class="form-control">
						<c:forEach items="${listQuestionType}" var="questionType">
							<option value="${questionType.questionTypeId}"
								${questionInf.questiontypeid == questionType.questionTypeId ? 'selected' : ''}>
								${questionType.questionTypeName}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group row">
				<label for="content" class="col-sm-1 col-form-label">Content</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="content"
						value="${questionInf.content}">
					<p id="errContent"></p>
				</div>
			</div>

			<div class="form-group row">
				<label for="options" class="col-sm-1 col-form-label">Options</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="options"
						value="${questionInf.options}">
					<p id="errOptions"></p>
				</div>
			</div>

			<div class="form-group row">
				<label for="correctanswer" class="col-sm-1 col-form-label">Corrected Answer</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="correctanswer"
						value="${questionInf.correctanswer}">
					<p id="errCorrectanswer"></p>
				</div>
			</div>

			<div class="form-group row">
				<label for="assignmentid" class="col-sm-1 col-form-label">Assignment ID</label>
				<div class="col-sm-4">
					<select name="assessmentid" class="form-control">
						<c:forEach items="${listAssessment}" var="assessment">
							<option value="${assessment.assessmentid}"
								${questionInf.questiontypeid == assessment.assessmentid ? 'selected' : ''}>
								${assessment.assessmentname}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<input type="hidden" name="score"
						value="10">
			<button type="submit" class="btn btn-primary">Done</button>
			<a href="/teacher/questionOfAssessment"><button type="button"
					class="btn btn-danger">cancel</button></a>
		</form>
	</div>
</div>
