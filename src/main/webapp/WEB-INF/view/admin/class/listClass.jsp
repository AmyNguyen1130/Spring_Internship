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
				<form action="/admin/class/search" method="get">
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
			<div class="col-sm-5">
				<div class="row = 12">
					<div class="col-sm-8">
						<form action="/admin/class/getClassByStatus" method="get">
							<div class="row = 12">
								<div class="col-sm-8">
									<select name="status" class="form-control">
										<option value="true" ${status == true ? 'selected' : ''}>Active</option>
										<option value="false" ${status == false ? 'selected' : ''}>Inactive</option>
									</select>
								</div>
								<div class="col-sm-4">
									<button class="btn btn-default" type="submit">Filter</button>
								</div>
							</div>
						</form>
					</div>
					<div class="col-sm-4">
						<a href='/admin/class/addClass'><button
								class="btn btn-default" type="button">Add new class</button></a>
					</div>
				</div>
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
							<td><a
								href="/admin/class/editClassStatus?classid=<c:out value='${class.classid}' />"
								onclick="return confirm('Are you sure?')">
									<button class="btn btn-default">${class.getStatus() == true ? 'Active' : 'Inactive'}</button>
							</a></td>
							<td>${class.totalStudents}</td>
							<td><a
								href="/admin/class/editClass?classid=<c:out value='${class.classid}' />">Edit</a>
								&emsp; <a
								href="/admin/class/deleteClass?classid=<c:out value='${class.classid}'/>"
								id="delete-button">Delete</a> &emsp; <a
								href="/admin/getTeacherAddToClass?classid=<c:out value='${class.classid}'/>"><button
										class="btn btn-default">Assign</button></a></td>

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

	<script type="text/javascript">
		$(document).ready(function() {

			$("#delete-button").click(function() {
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