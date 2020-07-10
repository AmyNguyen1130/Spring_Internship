<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<body>
<div class="container-fluid">
	<div class="row = 12">

		<div class="col-sm-8">
			<h1>Add Class Form</h1>

			<c:forEach items="${errors}" var="error">
				<span style="color: red">${error}</span>
			</c:forEach>
			<form action="<%=request.getContextPath()%>${url}" method="post">

					<input type="hidden" name="classid" value="${editClass.classid}" />

					<div class="form-group row">
					Class Name: <input type="text" class="form-control" name="classname"
							value="${editClass.classname}">
				</div>
				
				<div class="form-group row">
					Teacher:
					<select class="form-control" name="user.userid">
					<option value="" ${editClass.getUser().getUserid() == null ? 'selected="selected"' : ''}>None</option>
					<c:forEach items="${users}" var="user">
						<option value="${user.userid}" ${user.userid == editClass.getUser().getUserid() ? 'selected="selected"' : ''}>${user.getUsername()}</option>
					</c:forEach>
				</select>
				</div><br>
				<input type="hidden" value="${url == '/admin/class/saveAddClass' ? 'true' : editClass.status}"  name="status" />

				<input class="btn btn-default" type="submit" value="Save">

				<a href="/admin/class"><input class="btn btn-default" type="button" value="Cancel"></a>
			</form>
		</div>
		<div class="col-sm-4">

		</div>
	</div>
</div>

</body>
</html>