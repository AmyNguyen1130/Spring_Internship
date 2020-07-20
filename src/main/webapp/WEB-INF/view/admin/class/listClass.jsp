<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<!DOCTYPE html>
<html>
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
						<a href='/admin/class/addClass'><button
								class="btn btn-default" type="button">Add new class</button></a>
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
						<th scope="col">Class Name</th>
						<th scope="col">Teacher</th>
						<th scope="col">Status</th>
						<th scope="col">Total Student</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>

					<c:set var="i" value="1" />
					<c:forEach items="${classPage.getContent()}" var="class">
						<tr>
							<td>${i}</td>
							<td>${class.classname}</td>
							<td>${class.getUser().getUsername()}</td>
							<td><a
								href="/admin/class/editClassStatus/${class.classid}"
								onclick="return confirm('Are you sure?')">
									<button class="btn btn-default">${class.getStatus() == true ? 'Active' : 'Inactive'}</button>
							</a></td>
							<td>${class.totalStudents}</td>
							<td><a href="/admin/class/editClass/${class.classid}">
									<img alt="edit" src="<%=editImageAddress%>" class="optionSize" /></a>
								<a href="/admin/class/deleteClass?classid=<c:out value='${class.classid}'/>" class="delete-button">
									<img alt="delete" src="<%=deleteImageAddress%>" class="optionSize" /></a>&emsp;
								<a href="/admin/getStudentInClass?classid=<c:out value='${class.classid}'/>"><button class="btn btn-default">Assign</button></a></td>

						</tr>
						<c:set var="i" value="${i+1}" />
					</c:forEach>

				</tbody>
			</table>

		</div>
	</div>

	<util:pagination count="${classPage.getTotalElements()}"
		totalPages="${classPage.getTotalPages()}"
		url="${pageContext.request.contextPath}/admin/class"
		curpage="${classPage.getNumber()}" />

	<script type="text/javascript">
		$(document).ready(function() {

			$(".delete-button").click(function() {
				if (confirm("Are you sure you want to delete this class?")) {
					return true;
				} else {
					return false;
				}
			});
		});
	</script>
</body>
</html>