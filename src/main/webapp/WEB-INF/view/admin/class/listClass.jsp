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
			<div class="col-sm-7"></div>
			<div class="col-sm-5">
				<div class="row">
					<div class="col-sm-8"></div>
					<div class="col-sm-4">
						<a href='/admin/class/addClass'><button class="btn btn-pink"
								type="button">Add new class</button></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<div class="container-fluid">
		<div class="row">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Class Name</th>
						<th scope="col">Teacher</th>
						<th scope="col">Status</th>
						<th scope="col">Total Students</th>
						<th scope="col">Total Assessments</th>
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
							<td>
								<a href="#"
									onclick="confirmation('/admin/class/editClassStatus/${class.classid}', 'update')">
										<button class="btn ${class.getStatus() ? 'btn-active' : 'btn-inactive'}">${class.getStatus() ? 'Enable' : 'Disable'}</button>
								</a>
							</td>
							<td>${class.totalStudents}</td>
							<td>${class.totalAssessments}</td>
							<td>
								<div class="row">
									<div class="col-sm-3">
										<a href="/admin/class/editClass/${class.classid}"> 
											<img alt="edit" src="<%=editImageAddress%>" class="optionSize" />
										</a> 
										<a onclick="confirmation('/admin/class/deleteClass?classid=<c:out value='${class.classid}'/>', 'delete ')">
											<img alt="delete" src="<%=deleteImageAddress%>" class="optionSize" />
										</a>
									</div>
									<div class="col-sm-8">
										<a href="/admin/getStudentInClass?classid=<c:out value='${class.classid}'/> ">
											<button class="btn btn-pink">Assign</button>
										</a>
									</div>
								</div>

							</td>
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
</body>
</html>