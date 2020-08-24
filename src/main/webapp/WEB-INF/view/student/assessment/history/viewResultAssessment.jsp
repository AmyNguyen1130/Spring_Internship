<%@page import="java.util.List"%>
<%@page import="com.codeenginestudio.elearning.dto.ResultDTO"%>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="com.codeenginestudio.elearning.constant.QuestionTypeEnum" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<body>
	<div class="container-fluid row">
		<div class="col-sm-3"></div>
			<div class="col-sm-7" id="borderTest">
				<div class="descriptionAssessment">
					<p class="assignmentTitle">${assessment.getAssessmentname()}</p>
					<p class="dateTime">(${assessment.getStartdate()}-${assessment.getExpireddate()})</p>
				</div>
				<c:choose>
					<c:when test="${listQuestionOfAssessment.size() > 0}">
						<c:forEach items="${listQuestionOfAssessment}" var="question" varStatus="status">
							<div class="questionName mt-5">
								<c:if test="${!preview}">
									<c:choose>
										<c:when test="${question.correctanswer eq listResult[status.index].answerchoice}">
											<img alt="correct" src="<c:url value="/images/correct.png"/>" class="optionSize" />
										</c:when>
										<c:otherwise>
											<img alt="incorrect" src="<c:url value="/images/incorrect.png"/>"
												class="optionSize" />
										</c:otherwise>
									</c:choose>
								</c:if>
								<span> Question ${question.numericalorder}: ${question.content}</span>
							</div>
							<c:choose>
								<c:when test="${question.getQuestionType().getQuestionTypeCode().equals(QuestionTypeEnum.INPUT.getCode())}">
									<input type="text" class="form-control" name="${question.getQuestionid()}" value="${listResult[status.index].answerchoice}" disabled="disabled">
									<c:if test="${question.correctanswer != listResult[status.index].answerchoice}">
										<div class="correctAnswer pt-4">
											<strong><spring:message code="correct-answer"/>&ensp;${question.correctanswer}</strong>
										</div>
									</c:if>
								</c:when>
								<c:when test="${question.getQuestionType().getQuestionTypeCode().equals(QuestionTypeEnum.YESNO.getCode())}">
									<div data-track="hel" class="form-group row ml-2">
										<table>
											<tr>
												<th>
													<div class="optionItem ${listResult[status.index].answerchoice == 'A' ? 'checkCorrect' : 'checkInCorrect'}">
														<img data-id="yes_choice_${question.questionid}" data-question="${question.questionid}" src="<c:url value="/images/_yes.png"/>" class="yesnoImage" />
													</div>
												</th>
												<th>
													<div class="optionItem ${listResult[status.index].answerchoice == 'B' ? 'checkCorrect' : 'checkInCorrect'}">
														<img data-id="yes_choice_${question.questionid}" data-question="${question.questionid}" src="<c:url value="/images/_no.png"/>" class="yesnoImage" />
													</div>
												</th>
											</tr>
										</table>
									</div>
								</c:when>
								<c:otherwise>
									<div class="form-group row ml-2">
										<c:forEach items="${question.options}" var="option">
											<c:set var="check" value='${option.getName() eq listResult[status.index].answerchoice ? "checked" : ""}' />
											<div class="col-sm-12 answer-group">
												<lable class="answer-item">${option.getValue()}
													<input value="${option.getName()}" ${check} type="radio" ${option.getName() eq question.correctanswer ? 'checked' : ''} disabled />
													<span class="radio-btn ${option.getName() eq listResult[status.index].answerchoice ? 'multiple-incorrect' : ''} ${option.getName() eq question.correctanswer ? 'multiple-correct' : ''}"></span>
												</lable>
											</div>
										</c:forEach>
									</div>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<div class="mt-5 pb-5">
							<a href="${urlBack}"><input class="btn btn-warning" type="button" value="Back"></a>
						</div>
					</c:when>
					<c:otherwise>
						<h1><strong ><spring:message code="no-question"/>${question.correctanswer}</strong></h1>
						<img src="<c:url value="../../../images/no-data.jpg"/>" class="welcomeImg"/>
					</c:otherwise>
				</c:choose>
			</div>
		<div class="col-sm-2"></div>
	</div>
</body>
</html>
