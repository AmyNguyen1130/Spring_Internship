<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<!DOCTYPE html>
<html>
<body>
	<div class="container-fluid">
		<div class="row = 12">
			<div class="col-sm-7">
				<form action="/teacher/class/search" method="get">
					<div class="row">
						<div class="col-sm-6">
							<input class="form-control" type="text" name="inputSearch"
								placeholder="Search" aria-label="Search">
						</div>
						<div class="col-sm-6">
							<button type="submit" class="btn btn-default">Search</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<br>
	<br>
	<div class="container-fluid">
		<div class="row = 12">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Class Name</th>
						<th scope="col">Teacher ID</th>
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
							<td>${class.teacherid}</td>
							<td>${class.status}</td>
							<td>${class.totalStudents}</td>
							<td><a
								href="/teacher/getTeacherInClass?classid=<c:out value='${class.classid}'/>"><button
										class="btn btn-default">View Students In Class</button></a></td>

						</tr>
						<c:set var="i" value="${i+1}" />
					</c:forEach>

				</tbody>
			</table>
			<h1 class="noResult">${noResult}</h1>
		</div>
	</div>
	<util:pagination count="${classPage.getTotalElements()}"
		totalPages="${classPage.getTotalPages()}"
		url="${pageContext.request.contextPath}/admin/class"
		curpage="${classPage.getNumber()}" />
</body>
</html>