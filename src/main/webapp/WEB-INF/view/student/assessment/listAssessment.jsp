<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="col-sm-7">
			<div class="alert success" style="display:none">
				<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
				<strong id="message">${messageSuccess}</strong>
			</div>
		</div>
		</div>	
		<br><br>
		<div class="container-fluid">
		  <div class="row">
		  	<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Assessment Name</th>
					<th scope="col">Class Name</th>
					<th scope="col">Start Date</th>
					<th scope="col">Expired Date</th>
					<th scope="col">Status</th>
					<th scope="col">Total Score</th>
					<th scope="col">Total Question</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${assessmentPage}" var="assessment" varStatus="count">
					<c:if test="${listClassAssigned.contains(assessment.getClassForeign().getClassid())}">
						<c:if test="${assessment.status}">
							<tr>
								<td>${count.index + 1}</td>
								<td>${assessment.assessmentname}</td>
								<td>${assessment.getClassForeign().getClassname()}</td>
								<td>${assessment.startdate}</td>
								<td>${assessment.expireddate}</td>
								<td>${assessment.getStatus() ? 'Enable' : 'Disable'}</td>
								<td class="pink-highlight">${assessment.getTotalscore()}</td>
								<td class="pink-highlight">${assessment.getTotalquestion()}</td>
								<td>
									<c:choose>
										<c:when test="${!assessment.isEdit()}">
											<a class="href" href="/student/addSubmitLesson/${assessment.assessmentid }"><button class="btn btn-pink" type="button" ${!listAssessmentId.contains(assessment.assessmentid) ? 'disabled' : ''}>Do Exercise</button></a>
										</c:when>
										<c:otherwise>
											<a class="href" href="/student/editSubmitLesson/${assessment.assessmentid }"><button class="btn btn-warning" type="button" ${!listAssessmentId.contains(assessment.assessmentid) ? 'disabled' : ''}>Edit Exercise</button></a>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:if>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
		
	<script type="text/javascript">	
		$(document).ready(function() {

			if($("#message").html() != ""){
				$(".alert").css("display", "block");
				setTimeout(function(){ $(".alert").css("display", "none"); }, 5000);
			}
		});

	</script>
</body>
</html>