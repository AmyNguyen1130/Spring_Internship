<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
		 <div class="row">
			<div class="col-sm-7"></div>
			<div class="col-sm-5">
				<div class="row">
					<div class="col-sm-8"></div>
					 <div class="col-sm-4">
						<a href='/teacher/assessment/addAssessment'><button class="btn btn-pink" type="button">Add new assessment</button></a>
					</div>
				</div>
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
				<th scope="col"><spring:message code="assessment-name"/></th>
				<th scope="col"><spring:message code="class-name"/></th>
				<th scope="col"><spring:message code="start-date"/></th>
				<th scope="col"><spring:message code="expired-date"/></th>
				<th scope="col"><spring:message code="status"/></th>
				<th scope="col"><spring:message code="total-question"/></th>
				<th scope="col"><spring:message code="action"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listAssessment}" var="assessment" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${assessment.assessmentname}</td>
					<td>${assessment.getClassForeign().getClassname()}</td>
					<td>${assessment.startdate}</td>
					<td>${assessment.expireddate}</td>
					<td>
						<a href="#" onclick="confirmation('/teacher/assessment/editAssessmentStatus/${assessment.assessmentid}', 'update')">
							<button class="btn ${assessment.getStatus() ? 'btn-active' : 'btn-inactive'}">${assessment.getStatus() ? 'Enable' : 'Disable'}</button>
						</a>
					</td>
					<td class="pink-highlight">${assessment.getTotalquestion()}</td>
					<td>
						<a href="/teacher/assessment/editAssessment/${assessment.assessmentid}">
							<img alt="edit" src="<%=editImageAddress%>" class="optionSize" />
						</a> 
						<a href="#" onclick="confirmation('/teacher/assessment/deleteAssessment?assessmentid=<c:out value='${assessment.assessmentid}'/>', 'delete')">
							<img alt="delete" src="<%=deleteImageAddress%>" class="optionSize" />
						</a>&emsp;
						<a href="/teacher/questionOfAssessment?assessmentid=<c:out value='${assessment.assessmentid}'/>">
							<input class="btn btn-pink" type="button" value="View questions">
						</a>&emsp;
						<a href="/teacher/viewResult?assessmentid=<c:out value='${assessment.assessmentid}'/>">
							<input class="btn btn-warning" type="button" value="View result">
						</a>
					</td>
				</tr>
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
		function confirmation(success, action) {
			
			$('#acceptConfirm').attr("href", success);
			$('#title').html(action + ' Item');
			$('#ask').html('Are you sure you want to ' + action + ' this Item ?');
			$('#confirm').show();
		}
	</script>
</body>
</html>