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

			<form class="form-group" action="<%=request.getContextPath()%>/admin/class/saveAddClass"
				method="POST">
				Class Name: <input class="form-control" type="text" name="classname">

				 <br>
				Teacher:
				<select class="form-control" id="teacherid" name="teacherid">
					<option value="">None</option>
				 <c:forEach items="${data}" var="user">
					   <option value="${user.userid}">${user.username}</option>
			     </c:forEach>
				</select>
				<br>
				<input type="hidden" value="true" name="status" />

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