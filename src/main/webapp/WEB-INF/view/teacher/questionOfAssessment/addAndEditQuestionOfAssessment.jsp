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
		<h3>Enter question's informations here</h3>

		<form action="<%=request.getContextPath()%>${url}" method="post">
			<input type="hidden" name="questionid"
				value="${questionInf.questionid}" /> 
				
			<div class="form-group row">
				<label for="numericalorder" class="col-sm-1 col-form-label">Numerical Order</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="numericalorder"
						value="${numericalorder}" disabled="disabled">
				</div>
			</div>

			<div class="form-group row">
				<label for="questiontypeid" class="col-sm-1 col-form-label">Question
					Type</label>
				<div class="col-sm-4">
					<select name="questionType.questionTypeId" class="form-control">
						<c:forEach items="${listQuestionType}" var="questionType">
							<option value="${questionType.questionTypeId}"
								${questionInf.getQuestionType().getQuestionTypeId() == questionType.questionTypeId ? 'selected' : ''}>
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
					<p id="errContent"> ${error.getErrContent()} </p>
				</div>
			</div>

			<div class="form-group row">
				<label for="options" class="col-sm-1 col-form-label">Options</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="options"
						value="${questionInf.options}">
					<p id="errOptions">${error.getErrOptions()}</p>
				</div>
			</div>

			<div class="form-group row">
				<label for="correctanswer" class="col-sm-1 col-form-label">Corrected
					Answer</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="correctanswer"
						value="${questionInf.correctanswer}">
					<p id="errCorrectAnswer">${error.getErrCorrectAnswer()}</p>
				</div>
			</div>

			<input type="hidden" name="assessment.assessmentid" value="${assessmentid}"> 

			<div class="form-group row">
				<label for="score" class="col-sm-1 col-form-label">Score</label>
				<div class="col-sm-4">
					<select name="score" class="form-control">
					<% for(int i = 0; i < 10; i++) { %>
			            <option value="<%= i + 1 %>"> <%= i + 1 %></option>
			        <% } %>
					</select>
				</div>
			</div>
			<button type="submit" class="btn">Done</button> 
			
			<a href="/teacher/questionOfAssessment?assessmentid=${assessmentid}"><button type="button"
					class="btn">Cancel</button></a>
		</form>
	</div>
</div>
