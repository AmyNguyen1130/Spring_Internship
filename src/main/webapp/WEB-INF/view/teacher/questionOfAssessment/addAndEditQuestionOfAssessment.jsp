<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container-fluid center">

		<div class="col-sm-3"></div>

		<form action="<%=request.getContextPath()%>${url}" method="post" class="col-sm-6 form-general">
			<h1 class="form-title"><spring:message code="new-question"/></h1>

			<input type="hidden" name="questionid"
				value="${questionInf.questionid}"/>

			<div class="form-group row">
				<label for="numericalorder" class="col-sm-3 col-form-label"><spring:message code="numerical-order"/></label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="numericalorder"
						value="${questionInf.numericalorder}" placeholder="<spring:message code="please-enter-numericalorder-here"/>">
					<p class="err errContent">${error.getErrNumericalOrder()}</p>
				</div>
			</div>

			<div class="form-group row">
				<label for="score" class="col-sm-3 col-form-label"><spring:message code="score"/></label>
				<div class="col-sm-8">
					<select name="score" class="form-control">
						<c:forEach begin="1" end="10" step="1" varStatus="num">
							<option value="${num.index}" ${questionInf.getScore() == num.index ? 'selected' : ''}>${num.index}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group row">
				<label for="content" class="col-sm-3 col-form-label"><spring:message code="content"/></label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="content"
						value="${questionInf.content}" placeholder="<spring:message code="please-enter-question's-content-here"/>">
					<p class="err errContent">${error.getErrContent()}</p>
				</div>
			</div>

			<div class="form-group row">
				<label for="questiontypeid" class="col-sm-3 col-form-label"><spring:message code="question-type"/></label>
				<div class="col-sm-8">
					<select name="questionType.questionTypeId" class="form-control" id="questionType">
						<c:forEach items="${listQuestionType}" var="questionType">
							<option value="${questionType.questionTypeId}" 
								${questionInf.getQuestionType().getQuestionTypeId() == questionType.questionTypeId ? 'selected' : ""}>
								${questionType.questionTypeName}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group row" id="option">
				<label for="options" class="col-sm-3 col-form-label"><spring:message code="options"/></label>

				<div class="col-sm-8" id="yesNoOptions">
						<div class="optionItem">
							<input type="radio" name="correctanswer" value="A" 
								class="radioOption yesNoOption" checked>
							<label for="A" class="col-sm-1 col-form-label">A: </label> 
							<input type="hidden" name="options[0].name" value="A" class="yesNoOption"> 
							<input type="text" class="form-control yesNoOption" name="options[0].optionValue" 
								value="Yes">
						</div>
						<div class="optionItem">
							<input type="radio" name="correctanswer" value="B" 
								class="radioOption yesNoOption">
							<label for="B" class="col-sm-1 col-form-label">B: </label> 
							<input type="hidden" name="options[1].name" value="B" class="yesNoOption"> 
							<input type="text" class="form-control yesNoOption" name="options[1].optionValue" value="No">
						</div>
				</div>

				<div class="col-sm-8" id="multipleOptions">
					<c:set var="totalOption" value='0' />
						<c:forEach begin="0" end="${totalOption}" step="1" varStatus="num">
							<c:choose>
								<c:when test="${num.index == 0}">
									<c:set var="name" value='A' />
								</c:when>
								<c:when test="${num.index == 1}">
									<c:set var="name" value='B' />
								</c:when>
								<c:when test="${num.index == 2}">
									<c:set var="name" value='C' />
								</c:when>
								<c:otherwise>
									<c:set var="name" value='D' />
								</c:otherwise>
							</c:choose>
							<div class="optionItem">
								<input type="radio" name="correctanswer" value="${name}"
									class="radioOption multipleOption" ${questionInf.getCorrectanswer() == name ? 'checked' : '' } ${num.index == 0 ? 'checked' : ''}>
								<label for="${name}" class="col-sm-1 col-form-label">${name}: </label> 
								<input type="hidden" name="options[${num.index}].name" value="${name}" class="multipleOption"> 
								<input type="text" class="form-control multipleOption" name="options[${num.index}].optionValue"
									value="${questionInf.getOptions().size() > num.index ? questionInf.getOptions().get(num.index).getOptionValue() : ''}">
							</div>
						</c:forEach>
				</div>
			</div>

			<input type="hidden" name="assessment.assessmentid"
				value="${assessmentid}">

			<button type="submit" class="btn btn-pink"><spring:message code="save"/></button>

			<a href="/teacher/questionOfAssessment?assessmentid=${assessmentid}"><button
					type="button" class="btn btn-warning"><spring:message code="cancel"/></button></a>
		</form>

		<div class="col-sm-3"></div>
	</div>

<script>

$(document).ready(function() {
	$("#option").show();
	$("#multipleOptions").show();
	$("#yesNoOptions").hide();
	$(".yesNoOption").prop("disabled" , true );
	$(".multipleOption").prop("disabled" , false );
});

$(function() {
    $('#questionType').change(function(e) {
        var selected = $(e.target).val();
        if(selected == 1){
	$("#option").show();
	$("#multipleOptions").show();
	$("#yesNoOptions").hide();
	$(".multipleOption").prop("disabled" , false );
	$(".yesNoOption").prop("disabled" , true );
	       	
          }else if(selected == 2){
	$("#option").show();
	$("#multipleOptions").hide();
	$("#yesNoOptions").show();
	$(".yesNoOption").prop("disabled" , false );
	$(".multipleOption").prop("disabled" , true );
          }
    }); 
});

</script>
