<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<body>
	<div class"parents" style="margin: 5%">
	<h1>List Class</h1>
	<a href='/admin/class/addClass'><button class="btn btn-success" type=\"button\">Add class</button></a>

	</br>
	</br>
	<table class="table table-bordered" id="table" style="width: 50%">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Class Name</th>
				<th scope="col">Teacher ID</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>

				<c:set var="i" value="1" />
				<c:forEach items="${data}" var="class">
			       <tr>
				       <td>${class.classId}</td>
				       <td>${class.className}</td>
				       <td>${class.teacherId}</td>
				       <td><a href="editClass?id=<c:out value='${class.classId}' />">Edit</a> &emsp;
					       <a href="deleteClass?id=<c:out value='${class.classId}' />">Delete</a> &emsp;
					      	<a href="/admin/getTeacherAddToClass?classId=<c:out value='${class.classId}'/>"><button>Assign</button></a></td>

				   </tr>
				   <c:set var="i" value="${i+1}" />
		     	</c:forEach>

		</tbody>
	</table>
</body>
</html>