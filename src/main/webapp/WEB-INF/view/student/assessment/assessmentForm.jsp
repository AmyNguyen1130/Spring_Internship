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
					<div class="descriptionAssessment">
						<p class="assignmentTitle">${assessment.getAssessmentname()}</p>
						<p class="dateTime">(${assessment.getStartdate()} -
							${assessment.getExpireddate()})</p>
					</div>
					<br>
					<c:choose>
						<c:when test="${listQuestionOfAssessment.size() > 0}">
							<c:forEach items="${listQuestionOfAssessment}" var="question" varStatus="status">
								<form:input type="hidden" path="resultDTOs[${status.index}].id" value="${resultDTOs[status.index].id}" />
								<form:input type="hidden" path="resultDTOs[${status.index}].assessment.assessmentid" value="${assessment.assessmentid}" />
								<form:input type="hidden" path="resultDTOs[${status.index}].question.questionid" value="${question.questionid}" />
								<!-- TODO: please using the class col-x to design, not using br -->
								<div>
									<div class="questionName">
										<span> Question ${question.numericalorder}:${question.content}</span>
									</div>
									<c:choose>
										<c:when test="${question.getQuestionType().getQuestionTypeCode().equals(QuestionTypeEnum.INPUT.getCode())}">
											<br>
											<form:input class="form-control" type="text" path="resultDTOs[${status.index}].answerchoice" value="" />
										</c:when>
										<c:otherwise>
											<div class="form-group row">
												<c:forEach items="${question.options}" var="option">
													<div class="col-sm-1">
														<label for="${option.getName()}"
															class="col-form-label">${option.getName()}:
														</label>
													</div>
													<div class="col-sm-1 position-radio">
														<!--  TODO: what is the "items" attribute meaning ? -->
														<form:radiobutton
															path="resultDTOs[${status.index}].answerchoice"
															value="${option.getName()}" class="inputRadioOption"
															items="${option.getName() eq resultDTOs[status.index].answerchoice && question.questionid eq resultDTOs[status.index].question.questionid ? 'checked': ''}" />
													</div>
													<div class="col-sm-10 answer-choice-postion">
														<label class="optionName">${option.getValue()}</label>
													</div>
												</c:forEach>
											</div>
										</c:otherwise>
									</c:choose>
								</div>
								<br>
							</c:forEach>
						<input id="submit-button" type="submit" class="btn btn-pink" value="Submit">
						<a href="/student/assessment">
							<input class="btn btn-warning" type="button" value="Cancel">
						</a>
					</c:when>
					<c:otherwise>
						<br>
						<h1><strong ><spring:message code="no-question"/>${question.correctanswer}</strong></h1>
						<img src="<c:url value="../../../images/no-data.jpg"/>" class="welcomeImg"/>
					</c:otherwise>
				</c:choose>
			</form:form>
		</div>
	</div>
</body>
</html>
