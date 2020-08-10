<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="WEB-INF/taglibs/util.tld" prefix="util"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-7">

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
						<th scope="col"><spring:message code="class-name"/></th>
						<th scope="col"><spring:message code="teacher-name"/></th>
						<th scope="col"><spring:message code="status"/></th>
						<th scope="col"><spring:message code="total-student"/></th>
						<th scope="col"><spring:message code="action"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${classPage.getContent()}" var="class" varStatus="status">
						<tr>
							<td>${status.index + 1}</td>
							<td>${class.classname}</td>
							<td>${class.getUser().getUsername()}</td>
							<td>${class.getStatus() == true ? 'Active' : 'Inactive'}</td>
							<td class="pink-highlight">${class.totalStudents}</td>
							<td>
								<a href="/teacher/getStudentInClass?classid=<c:out value='${class.classid}'/>">
									<input class="btn btn-pink" value="View Students In Class">
								</a>
							</td>
						</tr>
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