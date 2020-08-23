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
		<div class="col-sm-9">
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
											<span>${question.content}:</span>
										</div>
										<div class="col-sm-12">
											<c:choose>
												<c:when test="${question.getQuestionType().getQuestionTypeCode().equals(QuestionTypeEnum.INPUT.getCode())}">
													<form:input class="form-control" type="text" path="resultDTOs[${status.index}].answerchoice" value="" />
												</c:when>
												<c:when test="${question.getQuestionType().getQuestionTypeCode().equals(QuestionTypeEnum.YESNO.getCode())}">
													<div class="form-group row ml-2">
														<table >
															<tr>
																<th>
																	<div class="optionItem">
																		<form:radiobutton data-id="yes_choice_${question.questionid}" path="resultDTOs[${status.index}].answerchoice" value="A" class="radio-none"/>
																		<button data-id="yes_choice_${question.questionid}" data-question="${question.questionid}" class="btn btn-success btn-action fa fa-check" type="button"></button>
																	</div>
																</th>
																<th>
																	<div class="optionItem">
																		<form:radiobutton data-id="no_choice_${question.questionid}" path="resultDTOs[${status.index}].answerchoice" value="B" class="radio-none"/>
																		<button data-id="no_choice_${question.questionid}" data-question="${question.questionid}" class="btn btn-warning btn-action fa fa-ban" type="button"></button>
																	</div>
																</th>
															</tr>
														</table>
													</div>
												</c:when>
												<c:otherwise>
													<div class="form-group row">
														<c:forEach items="${question.options}" var="option">
															<c:set var="check" value="${option.getName() eq resultDTOs[status.indexb].answerchoice && question.questionid eq resultDTOs[status.index].question.questionid ? 'checked': ''}" />
															<div class="col-sm-1">
																<label for="${option.getName()}"
																	class="col-form-label">${option.getName()}:
																</label>
															</div>
															<div class="col-sm-1 position-radio">
																<form:radiobutton
																	path="resultDTOs[${status.index}].answerchoice"
																	value="${option.getName()}" class="inputRadioOption"
																	checked="${check}" />
															</div>
															<div class="col-sm-10 answer-choice-postion">
																<label class="optionName">${option.getValue()}</label>
															</div>
														</c:forEach>
													</div>
												</c:otherwise>
											</c:choose>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
						<div class="row">
							<div class="col-sm-12 button-row">
								<input id="submit-button" type="submit" class="btn btn-pink mr-2" value="Submit">
								<a href="/student/assessment">
									<input class="btn btn-warning" type="button" value="Cancel">
								</a>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<h1><strong ><spring:message code="no-question"/>${question.correctanswer}</strong></h1>
						<img src="<c:url value="../../../images/no-data.jpg"/>" class="welcomeImg"/>
					</c:otherwise>
				</c:choose>
			</form:form>
		</div>
	</div>
<script>
	$(document).ready(() => {
		questionForm = document.querySelector("#lessonForm");
		questionForm.addEventListener("click",(e) => {
			var dataId = e.target.getAttribute("data-id");
			var questionId = e.target.getAttribute("data-question");
			if(dataId){
				var currentYesOption = document.querySelector("button[data-id = 'yes_choice_" + questionId + "']");
				var currentNoOption = document.querySelector("button[data-id = 'no_choice_" + questionId + "']");

				if(dataId.indexOf("yes") === 0){
					currentYesOption.setAttribute("style","filter: brightness(0.5)");
					currentNoOption.removeAttribute("style");
				}else{
					currentNoOption.setAttribute("style","filter: brightness(0.5)");
					currentYesOption.removeAttribute("style");
				}
				e.target.previousElementSibling.checked = true;
			}
		});

		var radioSelect = document.querySelectorAll('[checked="checked"]');
		radioSelect.forEach((node) => { 
			if(node.nextElementSibling){
				node.nextElementSibling.setAttribute("style","filter: brightness(0.5)");
			}
		});
	});

</script>
</body>
</html>
