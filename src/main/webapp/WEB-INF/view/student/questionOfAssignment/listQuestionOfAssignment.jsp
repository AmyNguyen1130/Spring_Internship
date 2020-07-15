<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/fontawesome.min.css">
	
<style>
#borderTest{
	border: 2px solid black;
    padding: 5%;
}

.assignmentTitle{
	font-size: 30px;
	font-weight: bold;
}

.title{
	text-align: center;
}

.dateTime{
	color: grey;
}

.question{
	display: inline-block;
}

</style>
</head>
<%
	String deleteImageAddress = "https://img.icons8.com/cotton/2x/delete-sign--v2.png";
	String editImageAddress = "https://img.icons8.com/cotton/2x/edit.png";
%>

<body>
	<div class="container-fluid">
		<div class="row = 12">
		<div class="col-sm-3"></div>
		
			<div class="col-sm-6" id="borderTest">
					
					<div class="description">
						<div class="title">
							<p class="assignmentTitle" >${assessment.getAssessmentname()}</p>
							<p class="dateTime">(${assessment.getStartdate()} - ${assessment.getExpireddate()})</p>
						</div>
						
					</div>
				
					<c:forEach items="${listQuestionOfAssessment}" var="question">
						<div>
							<div class="question">
								<span> Question: ${question.numericalorder}  ${question.content} (score:
									${question.score})</span>
							</div>
							<p>${question.options}</p>
						</div>
					</c:forEach>
			
			</div>
			<div class="col-sm-2">
				<div class="row = 12">
					<div class="col-sm-8"></div>
					<div class="col-sm-4">
						<a href='#'><button class="btn btn-default" type="button">Edit
								Your Answer</button></a>
					</div>
				</div>
			</div>
			

		</div>
	</div>
	<br>
	<br>
	
</body>
</html>
