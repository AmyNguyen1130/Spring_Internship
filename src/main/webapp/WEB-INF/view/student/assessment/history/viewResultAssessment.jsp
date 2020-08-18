<%@page import="java.util.List"%>
<%@page import="com.codeenginestudio.elearning.dto.ResultDTO"%>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="com.codeenginestudio.elearning.constant.QuestionTypeEnum" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<body>
	<div class="container-fluid row">
		<div class="col-sm-3"></div>

		<div class="col-sm-6" id="borderTest">
			<div class="descriptionAssessment">
				<p class="assignmentTitle">${assessment.getAssessmentname()}</p>
				<p class="dateTime">(${assessment.getStartdate()}-${assessment.getExpireddate()})</p>
			</div>
			<br>
			<c:forEach items="${listQuestionOfAssessment}" var="question" varStatus="status">
				<div class="questionName">
					<c:if test="${!preview}">
						<c:choose>
							<c:when test="${question.correctanswer eq listResult[status.index].answerchoice}">
								<img alt="correct" src="<c:url value="../images/cancel.jpg"/>"
									class="optionSize" />
							</c:when>
							<c:otherwise>
								<img alt="incorrect" src="<c:url value="../images/tick.jpg"/>"
									class="optionSize" />
							</c:otherwise>
						</c:choose>
					</c:if>
					<span> Question ${question.numericalorder}: ${question.content}</span>
				</div>
				<c:choose>
					<c:when test="${question.getQuestionType().getQuestionTypeCode().equals(QuestionTypeEnum.INPUT.getCode())}">
						<br>
						<input type="text" class="form-control" name="${question.getQuestionid()}" value="${listResult[status.index].answerchoice}" disabled="disabled">
						<c:if test="${!preview}">
							<c:if test="${question.correctanswer != listResult[status.index].answerchoice}">
								<div class="correctAnswer">
									<strong><spring:message code="correct-answer"/>${question.correctanswer}</strong>
								</div>
							</c:if>
						</c:if>
						<br>
					</c:when>
					<c:otherwise>
						<div class="form-group row">
							<c:forEach items="${question.options}" var="option">
								<c:set var="check" value='${option.getName() eq listResult[status.index].answerchoice ? "checked" : ""}' />
									<div class="col-sm-1">
										<label for="${option.getName()}" class="col-form-label">${option.getName()}: </label>
									</div>
									<div class="col-sm-1 position-radio">
										<input type="radio" name="${question.getQuestionid()}"
											value="${option.getName()}"
											class="inputRadioOption"
											${check}
											disabled="disabled">
									</div>
									<div class="col-sm-10 answer-choice-postion">
										<label class="optionName">${option.getValue()}</label>
									</div>
							</c:forEach>
						</div>
							<c:if test="${!preview}">
								<c:if test="${question.correctanswer != listResult[status.index].answerchoice}">
									<div class="correctAnswer">
										<strong ><spring:message code="correct-answer"/>${question.correctanswer}</strong>
									</div>
							</c:if>
						</c:if>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<br><br>
			<a href="${urlBack}"><input class="btn btn-warning" type="button" value="Back"></a>
		</div>
		<div class="col-sm-3"></div>
	</div>

</body>
</html>
