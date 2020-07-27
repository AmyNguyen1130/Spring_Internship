<%@page import="java.util.List"%>
<%@page import="com.codeenginestudio.elearning.dto.ResultDTO"%>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3"></div>

			<div class="col-sm-6" id="borderTest">
				<form action="<%=request.getContextPath()%>${url}" method="post">
					<div class="descriptionAssessment">
						<p class="assignmentTitle">${assessment.getAssessmentname()}</p>
						<p class="dateTime">(${assessment.getStartdate()} -
							${assessment.getExpireddate()})</p>
					</div>
					<br>

					<c:forEach items="${listQuestionOfAssessment}" var="question"
						varStatus="status">
						<div>
							<div class="questionName">
								<span> Question ${question.numericalorder}:
									${question.content}</span>
							</div>
							<div class="form-group row">
								<div class="col-sm-6">

									<c:forEach items="${question.options}" var="option">

										<c:set var="check"
											value='${option.getName() eq listSubmitEdit[status.index].answerchoice ? "checked" : ""}' />

										<div class="row">
											<div class="col-sm-1">
												<label for="${option.getName()}"
													class="col-sm-1 col-form-label">${option.getName()}:
												</label>
											</div>
											<div class="col-sm-1">
												<input type="radio" name="${question.getQuestionid()}"
													value="${option.getName()}_${listSubmitEdit[status.index].id}"
													class="inputRadioOption" ${check}>
											</div>
											<div class="col-sm-6">
												<label class="optionName">${option.getOptionValue()}</label>
											</div>
										</div>

									</c:forEach>
								</div>
							</div>
						</div>
					</c:forEach>

					<button id="submit-button" type="submit" class="btn">Submit</button>
					<a href="/student/assessment"><input class="btn btn-default"
						type="button" value="Cancel"></a>
				</form>
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
