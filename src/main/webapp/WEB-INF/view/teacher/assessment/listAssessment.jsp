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
<%
	String deleteImageAddress = "https://img.icons8.com/cotton/2x/delete-sign--v2.png";
	String editImageAddress = "https://img.icons8.com/cotton/2x/edit.png";
%>
<body>
	 <div class="container-fluid">
	  <div class="row = 12">
		   <div class="col-sm-7">

			</div>
			 <div class="col-sm-5">
			  <div class="row = 12">
			   <div class="col-sm-8">

			</div>
			 <div class="col-sm-4">
				<a href='/teacher/assessment/addAssessment'><button class="btn btn-default" type="button">Add new assessment</button></a>
			</div>
			 	</div>
			 </div>
		</div>
		</div>	
		<br><br>
		<div class="container-fluid">
		  <div class="row = 12">
		  	<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Assessment Name</th>
					<th scope="col">Class Name</th>
					<th scope="col">Start Date</th>
					<th scope="col">Expired Date</th>
					<th scope="col">Status</th>
					<th scope="col">Total Question</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="i" value="1" />
					<c:forEach items="${assessmentPage.getContent()}" var="assessment">
					<tr>
						<td>${i}</td>
						<td>${assessment.assessmentname}</td>
						<c:if test="${assessment.getClassForeign().getClassid() == null}">
							<td></td>
						</c:if>
						<c:forEach items="${listClass}" var="class">
							<c:if test="${class.classid == assessment.getClassForeign().getClassid()}">
								<td>${class.classname}</td>
							</c:if>
						</c:forEach>
						<td>${assessment.startdate}</td>
						<td>${assessment.expireddate}</td>
						<td><a href="/teacher/assessment/editAssessmentStatus/${assessment.assessmentid}"
								onclick="return confirm('Are you sure?')">
									<button class="btn btn-default">${assessment.getStatus() == true ? 'Active' : 'Inactive'}</button>
							</a></td>
						<td>${assessment.getTotalquestion()}</td>

						<td><a href="/teacher/assessment/editAssessment/${assessment.assessmentid}"><img alt="edit" src="<%=editImageAddress%>" class="optionSize" /></a> 
						<a href="/teacher/assessment/deleteAssessment?assessmentid=<c:out value='${assessment.assessmentid}'/>" class="delete-button"><img alt="delete" src="<%=deleteImageAddress%>" class="optionSize" /></a>&emsp;
						<a href="/teacher/questionOfAssessment?assessmentid=<c:out value='${assessment.assessmentid}'/>"><button class="btn btn-default" type="button">View questions</button></a></td>

						</tr>
						<c:set var="i" value="${i+1}" />
					</c:forEach>
				</tbody>
			</table>
			</div>
		</div>
<util:pagination
	count="${assessmentPage.getTotalElements()}"
	totalPages="${assessmentPage.getTotalPages()}" 
	url="${pageContext.request.contextPath}/teacher/assessment"
	curpage="${assessmentPage.getNumber()}" />

<script type="text/javascript">
	$(document).ready(function() {

		$(".delete-button").click(function() {
			if (confirm("Are you sure you want to delete this assessment?")) {
				return true;
			} else {
				return false;
			}
		});
	});
</script>
</body>
</html>