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
	  <div class="row = 12">
		   <div class="col-sm-7">
		    <form action="/teacher/assessment/search" method="get">
		    	<div class="row">
				    <div class="col-sm-6">
				    	<input class="form-control" type="text" name="inputSearch" placeholder="Search"
				    	aria-label="Search">
				    </div>
				    <div class="col-sm-6">
				    	<button type="submit" class="btn btn-default" >Search</button>
				    </div>
				</div>
			</form>
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
					<th scope="col">Name</th>
					<th scope="col">Class Name</th>
					<th scope="col">Start Date</th>
					<th scope="col">Expired Date</th>
					<th scope="col">Total Question</th>
					<th scope="col">Status</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="i" value="1" />
					<c:forEach items="${assessmentPage.getContent()}" var="assessment">
				       <tr>
					       <td>${i}</td>
					       <td>${assessment.assessmentname}</td>
					       <c:if test="${assessment.classid == null}">
									<td></td>
								</c:if>
					       	<c:forEach items="${listClass}" var="class">
								<c:if test="${class.classid == assessment.classid}">
									<td>${class.classname}</td>
								</c:if>

							</c:forEach>
					       <td>${assessment.startdate}</td>
					        <td>${assessment.expireddate}</td>
					        <td>${assessment.totalquestion}</td>
					        <td>${assessment.status}</td>
					        <td><a href="/teacher/assessment/editAssessment?assessmentid=<c:out value='${assessment.assessmentid}' />">Edit</a> &emsp;
					        <a href="/teacher/assessment/deleteAssessment?assessmentid=<c:out value='${assessment.assessmentid}' />">Delete</a> </td>

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
</body>
</html>