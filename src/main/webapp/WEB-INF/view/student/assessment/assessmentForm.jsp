<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3"></div>

			<div class="col-sm-6" id="borderTest">
				<form:form method="POST" action="${url}" modelAttribute="lessonForm">
					<div class="descriptionAssessment">
						<p class="assignmentTitle">${assessment.getAssessmentname()}</p>
						<p class="dateTime">(${assessment.getStartdate()} -
							${assessment.getExpireddate()})</p>
					</div>
					<br>

					<c:forEach items="${listQuestionOfAssessment}" var="question" varStatus="status">
						<form:input type="hidden" path="resultDTOs[${status.index}].id" value="${resultDTOs[status.index].id}" />
						<form:input type="hidden" path="resultDTOs[${status.index}].assessment.assessmentid" value="${assessment.assessmentid}" />
						<form:input type="hidden" path="resultDTOs[${status.index}].question.questionid" value="${question.questionid}" />
						<div>
							<div class="questionName">
								<span> Question ${question.numericalorder}:${question.content}</span>
							</div>
							<div class="form-group row">
								<div class="col-sm-12">

									<c:forEach items="${question.options}" var="option">

										<div class="row">
											<div class="col-sm-1 display-inline">
												<label for="${option.getName()}"
													class="col-sm-1 col-form-label">${option.getName()}:
												</label>
												<form:radiobutton
													path="resultDTOs[${status.index}].answerchoice"
													value="${option.getName()}" class="inputRadioOption"
													items="${option.getName() eq resultDTOs[status.index].answerchoice && question.questionid eq resultDTOs[status.index].question.questionid ? 'checked': ''}" />
											</div>
											<div class="col-sm-11">
												<label class="optionName">${option.getOptionValue()}</label>
											</div>
										</div>

									</c:forEach>
								</div>
							</div>
						</div>
					</c:forEach>

					<input id="submit-button" type="submit" class="btn btn-pink" value="Submit">
					<a href="/student/assessment">
						<input class="btn btn-warning" type="button" value="Cancel">
					</a>
				</form:form>
			</div>
		</div>
	</div>

	<div id="confirm" class="modal">

		<form class="modal-content">
			<div class="container-model">
				<span onclick="document.getElementById('confirm').style.display='none'" class="close" title="Close Modal">&times;</span>
				<h1 id="title"></h1>
			<p id="ask"></p>
		
				<div class="clearfix">
					<a id="cancelConfirm" href="#" onclick="document.getElementById('confirm').style.display='none'">
						<button type="button" class="cancelbtn btn">No</button>
					</a>
					<a id="acceptConfirm" href="#"> <button type="button" class="btn-dark btn acceptbtn">Yes</button></a>
				</div>
			</div>
		</form>
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

		function confirmation(success, action) {
			$('#acceptConfirm').attr("href", success);
			$('#title').html(action + ' assignment');
			$('#ask').html('Are you sure you want to ' + action + ' this assignment ?');
			$('#confirm').show();
		}
	</script>

</body>
</html>
