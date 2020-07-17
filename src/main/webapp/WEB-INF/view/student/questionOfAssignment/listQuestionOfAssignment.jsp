<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/fontawesome.min.css">

<style>
.assignmentTitle {
	font-size: 30px;
	font-weight: bold;
}

.title {
	text-align: center;
}

.dateTime {
	color: grey;
}

.question {
	display: inline-block;
}

.questionName {
	font-weight: bold;
}
</style>
</head>

<body>
	<div class="container-fluid">
		<div class="row = 12">
			<div class="col-sm-3"></div>

			<div class="col-sm-6" id="borderTest">
				<form
					action="<%=request.getContextPath()%>${url}"
					method="post">
					<div class="description">
						<div class="title">

							<p class="assignmentTitle">${assessment.getAssessmentname()}</p>
							<p class="dateTime">(${assessment.getStartdate()} -
								${assessment.getExpireddate()})</p>
						</div>

					</div>

					<c:forEach items="${listQuestionOfAssessment}" var="question"
						varStatus="status">
						<div>
							<div class="questionName">
								<span> Question ${question.numericalorder}:
									${question.content} (score: ${question.score})</span>
							</div>

							<div class="form-group row">
								<div class="col-sm-4">

									<c:forEach items="${question.options}" var="option">
										<div class="optionItem">
											<label for="${option.getName()}" class="col-sm-1 col-form-label">${option.getName()}: </label> 
											<input type="radio" name="${question.getQuestionid()}" value="${option.getName()}" class="radioOption"> 
											<span>${option.getOptionValue()}</span>
										</div>

									</c:forEach>
								</div>
							</div>
						</div>
					</c:forEach>
					<button type="submit" class="btn">Submit</button>
				</form>
			</div>
			<div class="col-sm-2">
				<div class="row = 12">
					<div class="col-sm-8"></div>
					<div class="col-sm-4">

					</div>
				</div>
			</div>


		</div>
	</div>
	<br>
	<br>

</body>
</html>
