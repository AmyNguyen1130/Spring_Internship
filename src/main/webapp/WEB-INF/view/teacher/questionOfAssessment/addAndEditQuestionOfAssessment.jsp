<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
p {
	color: red
}

.optionItem {
	display: flex;
	flex-flow: row;
	margin: 5px;
}

.radioOption {
	margin: 15px;
}
</style>

<div>
	<div class="card-body">
		<h3>Enter question's informations here</h3>

		<form action="<%=request.getContextPath()%>${url}" method="post">
			<input type="hidden" name="questionid"
				value="${questionInf.questionid}" />

			<div class="form-group row">
				<label for="numericalorder" class="col-sm-1 col-form-label">Numerical
					Order</label>
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

					<p id="errContent">${error.getErrContent()}</p>
				</div>
			</div>

			<div class="form-group row">
				<label for="options" class="col-sm-1 col-form-label">Options: </label>
				<div class="col-sm-4">

					<div class="optionItem">
						<label for="A" class="col-sm-1 col-form-label" >A: </label>
						<input type="hidden" name="options[0].name" value="A">
						<input type="text" class="form-control" name="options[0].optionValue" value="${questionInf.options}"> 
						<input type="radio" name="correctanswer" value="A" class="radioOption">
					</div>

					<div class="optionItem">
						<label for="B" class="col-sm-1 col-form-label">B: </label>
						<input type="hidden" name="options[1].name" value="B">
						<input type="text" class="form-control" name="options[1].optionValue" value="${questionInf.options}"> 
						<input type="radio" name="correctanswer" value="B" class="radioOption">
					</div>

					<div class="optionItem">
						<label for="C" class="col-sm-1 col-form-label">C: </label>
						<input type="hidden" name="options[2].name" value="C">
						<input type="text" class="form-control" name="options[2].optionValue" value="${questionInf.options}"> 
						<input type="radio" name="correctanswer" value="C" class="radioOption">
					</div>

					<div class="optionItem">
						<label for="D" class="col-sm-1 col-form-label">D: </label>
						<input type="hidden" name="options[3].name" value="D">
						<input type="text" class="form-control" name="options[4].optionValue" value="${questionInf.options}"> 
						<input type="radio" name="correctanswer" value="D" class="radioOption">
					</div>
					<p id="errOptions">${error.getErrOptions()}</p>
				</div>
			</div>
			
	

			<input type="hidden" name="assessment.assessmentid"
				value="${assessmentid}">

			<div class="form-group row">
				<label for="score" class="col-sm-1 col-form-label">Score</label>
				<div class="col-sm-4"> 
					<select name="score" class="form-control">
						<%
							for (int i = 0; i < 10; i++) {
						%>
						<option value="<%=i + 1%>"><%=i + 1%></option>
						<%
							}
						%>
					</select>
				</div>
			</div>
			<button type="submit" class="btn">Done</button>

			<a href="/teacher/questionOfAssessment?assessmentid=${assessmentid}"><button
					type="button" class="btn">Cancel</button></a>

		</form>
	</div>
</div>
