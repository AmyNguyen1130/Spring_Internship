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
		<div class="row">
			<div class="col-sm-7">

			</div>
			<div class="col-sm-5">
				<div class="row">
					<div class="col-sm-8">
					</div>
					 <div class="col-sm-4">
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
				<c:forEach items="${assessmentPage}" var="assessment" varStatus="count">
					<c:if test="${listClassAssigned.contains(assessment.getClassForeign().getClassid()) }">
						<tr>
							<td>${count.index + 1}</td>
							<td>${assessment.assessmentname}</td>
							<!-- TODO : Revise from line 54 to line 61 -->
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
							<td>${assessment.getStatus() == true ? 'Active' : 'Inactive'}</td>
							<td>${assessment.getTotalquestion()}</td>
							<td>
								<a href="/student/questionOfAssessment/${assessment.assessmentid}"><button class="btn btn-default" type="button">Do Exercise</button></a>
								<a href="/student/editSubmitAssessment/${assessment.assessmentid}"><button class="btn btn-default" type="button">Edit Exercise</button></a>
							</td>
						</tr>
					</c:if>

				</c:forEach>
			</tbody>
			</table>
			</div>
		</div>
</body>
</html>