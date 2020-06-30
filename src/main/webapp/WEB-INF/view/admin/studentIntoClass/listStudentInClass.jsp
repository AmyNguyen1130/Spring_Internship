<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<body>
	<div class"parents" style="margin: 5%">
	<h1>List Students In Class</h1>

	</br>
	</br>
	<table class="table table-bordered" id="table" style="width: 50%">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Class ID</th>
				<th scope="col">Student ID</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>

				<c:set var="i" value="1" />
				<c:forEach items="${data}" var="data">
			       <tr>
				       <td>${i}</td>
				       <td>${data.classid}</td>
				       <td>${data.studentid}</td>
				   </tr>
				   <c:set var="i" value="${i+1}" />
		     	</c:forEach>

		</tbody>
	</table>

	<a href="/admin/getTeacherAddToClass?classid=<c:out value='${classid}'/>"><input class="btn btn-warning" type="button" value="Return"></a>
</body>
</html>