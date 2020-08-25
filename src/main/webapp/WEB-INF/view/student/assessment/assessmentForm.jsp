<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.codeenginestudio.elearning.constant.QuestionTypeEnum" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<body>
	<div class="container-fluid row">
		<div class="col-sm-3"></div>
		<div class="col-sm-7">
			<form:form method="POST" action="${url}" modelAttribute="lessonForm">
				<div class="descriptionAssessment row">
					<div class="col-sm-12">
						<span class="assignmentTitle">${assessment.getAssessmentname()}</span>
					</div>
					<div class="col-sm-12">
						<span><spring:message code="start-date-x" arguments="${assessment.getExpireddate()}" htmlEscape="false" /></span>
					</div>
					<div class="col-sm-12">
						<span><spring:message code="expired-date-x" arguments="${assessment.getExpireddate()}" htmlEscape="false" /></span>
					</div>
				</div>
				<c:choose>
					<c:when test="${listQuestionOfAssessment.size() > 0}">
						<c:forEach items="${listQuestionOfAssessment}" var="question" varStatus="status">
							<form:input type="hidden" path="resultDTOs[${status.index}].id" value="${resultDTOs[status.index].id}" />
							<form:input type="hidden" path="resultDTOs[${status.index}].assessment.assessmentid" value="${assessment.assessmentid}" />
							<form:input type="hidden" path="resultDTOs[${status.index}].question.questionid" value="${question.questionid}" />
	
							<div class="row">
								<div class="col-sm-1 question-numerical">
									<span>${question.numericalorder}.</span>
								</div>
								<div class="col-sm-11">
									<div class="row">
										<div class="col-sm-12 question-content">
											<span>${question.content}&ensp;?</span>
										</div>
										<c:choose>
											<c:when test="${question.getQuestionType().getQuestionTypeCode().equals(QuestionTypeEnum.INPUT.getCode())}">
												<div class="col-sm-12 mb-4">
													<form:input class="form-control col-sm-6" type="text" path="resultDTOs[${status.index}].answerchoice" value="" />
												</div>
											</c:when>
											<c:when test="${question.getQuestionType().getQuestionTypeCode().equals(QuestionTypeEnum.YESNO.getCode())}">
												<div class="col-sm-12 mb-2">
													<div class="form-group row ml-2 mb-4">
														<table >
															<tr>
																<th>
																	<div class="optionItem" data-id="yes_choice_${question.questionid}" >
																		<form:radiobutton data-id="yes_choice_${question.questionid}" path="resultDTOs[${status.index}].answerchoice" value="A" class="radio-none"/>
																		<img data-id="yes_choice_${question.questionid}" data-question="${question.questionid}" src="<c:url value="../../../images/_yes.png"/>" class="yesnoImage" />
																	</div>
																</th>
																<th>
																	<div class="optionItem" data-id="no_choice_${question.questionid}" >
																		<form:radiobutton data-id="no_choice_${question.questionid}" path="resultDTOs[${status.index}].answerchoice" value="B" class="radio-none"/>
																		<img data-id="no_choice_${question.questionid}" data-question="${question.questionid}" src="<c:url value="../../../images/_no.png"/>" class="yesnoImage" />
																	</div>
																</th>
															</tr>
														</table>
													</div>
												</div>
											</c:when>
											<c:otherwise>
												<div class="col-sm-12">
													<div class="form-group row">
														<c:forEach items="${question.options}" var="option">
															<div class="col-sm-12 answer-group">
																<lable class="answer-item">${option.getValue()}
																	<form:radiobutton
																		path="resultDTOs[${status.index}].answerchoice"
																		value="${option.getName()}" />
																	<span class="radio-btn"></span>
																</lable>
															</div>
														</c:forEach>
													</div>
												</div>
										</c:otherwise>
									</c:choose>	
								</div>
							</div>
						</div>
						</c:forEach>
						<div class="row mb-5">
							<div class="col-sm-12 button-row">
								<input id="submit-button" type="submit" class="btn btn-pink mr-2" value="Submit">
								<a href="/student/assessment">
									<input class="btn btn-warning" type="button" value="Cancel">
								</a>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<h1 class="mt-5"><strong ><spring:message code="no-question"/>${question.correctanswer}</strong></h1>
						<img src="<c:url value="../../../images/no-data.jpg"/>" class="welcomeImg"/>
					</c:otherwise>
				</c:choose>
			</form:form>
		</div>
		<div class="col-sm-2"></div>
	</div>
<script>
	$(document).ready(() => {
		questionForm = document.querySelector("#lessonForm");
		questionForm.addEventListener("click",(e) => {
			var dataId = e.target.getAttribute("data-id");
			var questionId = e.target.getAttribute("data-question");
			if(dataId){
				var currentYesOption = document.querySelector("div[data-id = 'yes_choice_" + questionId + "']");
				var currentNoOption = document.querySelector("div[data-id = 'no_choice_" + questionId + "']");

				if(dataId.indexOf("yes") === 0){
					currentYesOption.classList.add("optionActive");
					currentNoOption.classList.remove("optionActive");
				}else{
					currentNoOption.classList.add("optionActive");
					currentYesOption.classList.remove("optionActive");
				}
				e.target.previousElementSibling.checked = true;
			}
		});

		var radioSelect = document.querySelectorAll('[checked="checked"]');
		radioSelect.forEach((node) => { 
			if(node.matches('.radio-none')){
				if(node.parentNode){
					node.parentNode.classList.add("optionActive");
				}
			}
		});
	});

</script>
</body>
</html>