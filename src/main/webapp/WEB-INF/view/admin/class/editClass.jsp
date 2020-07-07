<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<body>
<div class="container-fluid">
	<div class="row = 12">
	    <div class="col-sm-8">

		    <h1>Edit Class Form</h1>

			<c:forEach items="${errors}" var="error">
			<span style="color: red">${error}</span>
		</c:forEach>

		<form class="form-group" action="<%=request.getContextPath()%>/admin/class/saveEditClass"
			method="POST">
			<input class="form-control" type="hidden" name="classid" value="${data.classid}">
			Class Name: <input class="form-control" type="text" name="classname" value="${data.classname}"> <br>
			Teacher:
			<select class="form-control" id="teacherid" name="teacherid">
				<option value="" ${data.teacherid == null ? 'selected="selected"' : ''}>None</option>
				 <c:forEach items="${user}" var="user">
					<option value="${user.userid}" ${user.userid == data.teacherid ? 'selected="selected"' : ''}>${user.getUsername()}</option>
			     </c:forEach>
			</select><br>

			<a href="/admin/class"><input class="btn btn-default" type="button" value="Cancel"></a>

			<input class="btn btn-default" type="submit" value="Save">

		</form>
		</div>
		<div class="col-sm-4">

		</div>
	</div>
</div>
</body>
</html>