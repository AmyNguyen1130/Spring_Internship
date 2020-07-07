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
		  	<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">question id</th>
					<th scope="col">content</th>
					<th scope="col">answer</th>
					<th scope="col">assessment id</th>

				</tr>
			</thead>
			<tbody>
				<c:set var="i" value="1" />
					<c:forEach items="${questionPage}" var="question">
				       <tr>
					       <td>${i}</td>
					       <td>${question.questionid}</td>
					       <td>${question.content}</td>
					        <td>${question.answer}</td>
					        <td>${question.assessmentid}</td>
					   </tr>
					   <c:set var="i" value="${i+1}" />
					</c:forEach>
				</tbody>
			</table>
			</div>
		</div>

</body>
</html>