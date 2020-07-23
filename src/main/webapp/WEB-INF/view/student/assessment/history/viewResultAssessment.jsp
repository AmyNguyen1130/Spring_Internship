<%@page import="java.util.List"%>
<%@page import="com.codeenginestudio.elearning.dto.ResultDTO"%>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<%
	String wrongAnswerIcon = "https://p1.hiclipart.com/preview/972/429/230/windows-live-for-xp-red-x-illustration-png-clipart.jpg";
String correctAnswerIcon = "https://img.pngio.com/tilde-png-and-tilde-transparent-clipart-free-download-tilde-png-260_240.jpg";
%>
<meta charset="UTF-8">
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3"></div>

			<div class="col-sm-6" id="borderTest">
				<div class="descriptionAssessment">
					<p class="assignmentTitle">${assessment.getAssessmentname()}</p>
					<p class="dateTime">(${assessment.getStartdate()} -
						${assessment.getExpireddate()})</p>
				</div>
				<br>
				<!-- TODO: revise here -->
				<c:forEach items="${listQuestionOfAssessment}" var="question"
					varStatus="status">

					<div class="questionName">
						<c:choose>
							<c:when
								test="${question.correctanswer eq listSubmitEdit[status.index].answerchoice}">
								<img alt="correct" src="<%=correctAnswerIcon%>"
									class="optionSize" />
							</c:when>
							<c:otherwise>
								<img alt="incorrect" src="<%=wrongAnswerIcon%>"
									class="optionSize" />
							</c:otherwise>
						</c:choose>
						<span> Question ${question.numericalorder}:
							${question.content}</span>
					</div>
					<div class="form-group row">
						<div class="col-sm-6">

							<c:forEach items="${question.options}" var="option">
								<c:set var="check"
									value='${option.getName() eq listSubmitEdit[status.index].answerchoice &&  question.questionid == listSubmitEdit[status.index].getQuestion().getQuestionid() ? "checked" : ""}' />

								<div class="row">
									<div class="col-sm-1">
										<label for="${option.getName()}"
											class="col-sm-1 col-form-label">${option.getName()}:
										</label>
									</div>
									<div class="col-sm-1">
										<input type="radio" name="${question.getQuestionid()}"
											value="${option.getName()}_${listSubmitEdit[status.index].id}"
											class="inputRadioOption"
											${option.getName() eq listSubmitEdit[status.index].answerchoice ? "checked" : ""}
											disabled="disabled">
									</div>
									<div class="col-sm-6">
										<label class="optionName">${option.getOptionValue()}</label>
									</div>
								</div>

							</c:forEach>
							<c:if
								test="${question.correctanswer != listSubmitEdit[status.index].answerchoice}">
								<div class="correctAnswer">
									<strong id="message">Correct answer is
										${question.correctanswer}</strong>
								</div>
							</c:if>
						</div>
					</div>

				</c:forEach>

				<c:choose>
					<c:when test="${currentRole == 'Student'}">
						<a href="/student/assessment/history"><input class="btn btn-default" type="button" value="Cancel"></a>
					</c:when>
					<c:otherwise>
						<a href="/teacher/viewResult?assessmentid=<c:out value='${assessment.assessmentid}'/>"><input class="btn btn-default" type="button" value="Cancel"></a>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {

			$("#submit-button").click(function() {
				if (confirm("Are you sure to submit this assessment?")) {
					return true;
				} else {
					return false;
				}
			});

			if ($("#messageError").html() != "") {
				$(".alert").css("display", "block");
				setTimeout(function() {
					$(".alert").css("display", "none");
				}, 5000);
			}
		});
	</script>

</body>
</html>
